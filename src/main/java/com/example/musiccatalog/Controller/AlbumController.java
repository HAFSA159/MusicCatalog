package com.example.musiccatalog.Controller;

import com.example.musiccatalog.DTO.AlbumDTO;
import com.example.musiccatalog.Service.Interface.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/album")
@Validated
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        List<AlbumDTO> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> getAlbumById(@PathVariable("id") String id) {
        AlbumDTO album = albumService.getAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addAlbum(@Valid @RequestBody AlbumDTO albumDTO) {
        albumService.addAlbum(albumDTO);
        String message = "Album ajouté avec succès.";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlbum(
            @PathVariable("id") String id,
            @Valid @RequestBody AlbumDTO albumDTO) {
        albumService.updateAlbum(id, albumDTO);
        String message = "Album mis à jour avec succès.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable("id") String id) {
        albumService.deleteAlbum(id);
        String message = "Album supprimé avec succès.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
