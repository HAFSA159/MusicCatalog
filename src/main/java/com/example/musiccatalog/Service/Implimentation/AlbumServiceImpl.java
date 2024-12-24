package com.example.musiccatalog.Service.Implimentation;


import com.example.musiccatalog.DTO.AlbumDTO;
import com.example.musiccatalog.Entity.Album;
import com.example.musiccatalog.Mapper.AlbumMapper;
import com.example.musiccatalog.Repository.AlbumRepository;
import com.example.musiccatalog.Service.Interface.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<AlbumDTO> getAllAlbums() {
        List<Album> albums = albumRepository.findAll();
        return albumMapper.toDTO(albums);
    }

    @Override
    public AlbumDTO getAlbumById(String id) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
        return albumMapper.toDTO(album);
    }

    @Override
    public AlbumDTO addAlbum(AlbumDTO albumDTO) {
        Album album = albumMapper.toEntity(albumDTO);
        album = albumRepository.save(album);
        return albumMapper.toDTO(album);
    }

    @Override
    public AlbumDTO updateAlbum(String id, AlbumDTO albumDTO) {
        Album existingAlbum = albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
        existingAlbum.setTitre(albumDTO.getTitre());
        existingAlbum.setArtiste(albumDTO.getArtiste());
        existingAlbum.setAnnee(albumDTO.getAnnee());
        Album updatedAlbum = albumRepository.save(existingAlbum);
        return albumMapper.toDTO(updatedAlbum);
    }

    @Override
    public void deleteAlbum(String id) {
        albumRepository.deleteById(id);
    }
}
