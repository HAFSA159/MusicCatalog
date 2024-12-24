package com.example.musiccatalog.Service.Implimentation;

import com.example.musiccatalog.DTO.MusicDTO;
import com.example.musiccatalog.Entity.Album;
import com.example.musiccatalog.Entity.Music;
import com.example.musiccatalog.Exception.MusicNotFoundException;
import com.example.musiccatalog.Mapper.MusicMapper;
import com.example.musiccatalog.Repository.AlbumRepository;
import com.example.musiccatalog.Repository.MusicRepository;
import com.example.musiccatalog.Service.Interface.AlbumService;
import com.example.musiccatalog.Service.Interface.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private MusicMapper musicMapper;
    @Autowired
    private AlbumService albumService;

    @Override
    public List<MusicDTO> getAllChansons() {
        List<Music> music = musicRepository.findAll();
        return musicMapper.toDto(music);
    }

    @Override
    public MusicDTO addChanson(MusicDTO musicDTO) {

        Music music = musicMapper.toEntity(musicDTO);

        music = musicRepository.save(music);

        Album album = albumRepository.findById(musicDTO.getAlbumId())
                .orElseThrow(() -> new RuntimeException("Album not found"));

        if (album.getMusic() == null) {
            album.setMusic(new ArrayList<>());
        }
        album.getMusic().add(music);

        albumRepository.save(album);


        return musicMapper.toDto(music);
    }


    @Override
    public MusicDTO updateChanson(String id, MusicDTO musicDTO) {
        Music music = musicRepository.findById(id).orElseThrow(() -> new MusicNotFoundException("Music Un found !"));
        music.setTitre(musicDTO.getTitre());
        music.setDuree(musicDTO.getDuree());
        music.setTrackNumber(musicDTO.getTrackNumber());
        music = musicRepository.save(music);
        return musicMapper.toDto(music);
    }

    @Override
    public void deleteChanson(String id) {
        musicRepository.deleteById(id);
    }

    @Override
    public void deleteChansonByTitre(String titre) {
        List<Music> music = musicRepository.findByTitreContaining(titre);
        if (music.isEmpty()) {
            throw new MusicNotFoundException("Music with the title '" + titre + "' is un found !");
        }
        musicRepository.deleteAll(music);
    }
}
