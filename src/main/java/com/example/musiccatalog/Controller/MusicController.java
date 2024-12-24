package com.example.musiccatalog.Controller;

import com.example.musiccatalog.DTO.MusicDTO;
import com.example.musiccatalog.Service.Interface.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/music")
@Validated
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public ResponseEntity<List<MusicDTO>> getAllChansons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<MusicDTO> chansons = musicService.getAllChansons();
        return new ResponseEntity<>(chansons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChanson(@Valid @RequestBody MusicDTO musicDTO) {
        musicService.addChanson(musicDTO);
        String message = "Chanson ajoutée avec succès.";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChanson(
            @PathVariable("id") String id,
            @Valid @RequestBody MusicDTO musicDTO) {
        musicService.updateChanson(id, musicDTO);
        String message = "Chanson mise à jour avec succès.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{titre}")
    public ResponseEntity<String> deleteChansonByTitre(@PathVariable("titre") String titre) {
        musicService.deleteChansonByTitre(titre);
        String message = "Chanson(s) supprimée(s) avec succès.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
