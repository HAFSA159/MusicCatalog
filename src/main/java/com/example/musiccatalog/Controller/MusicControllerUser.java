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
@RequestMapping("/api/user/music")
@Validated
public class MusicControllerUser {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public ResponseEntity<List<MusicDTO>> getAllMusics(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<MusicDTO> chansons = musicService.getAllChansons();
        return new ResponseEntity<>(chansons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMusic(@Valid @RequestBody MusicDTO musicDTO) {
        musicService.addChanson(musicDTO);
        String message = "Music Added Successfully.";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMusic(
            @PathVariable("id") String id,
            @Valid @RequestBody MusicDTO musicDTO) {
        musicService.updateChanson(id, musicDTO);
        String message = "Music Updates Successfully.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{titre}")
    public ResponseEntity<String> deleteMusicByTitre(@PathVariable("titre") String titre) {
        musicService.deleteChansonByTitre(titre);
        String message = "Music Deleted Successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
