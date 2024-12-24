package com.example.musiccatalog.Service.Interface;


import com.example.musiccatalog.DTO.MusicDTO;

import java.util.List;

public interface MusicService {

    List<MusicDTO> getAllChansons();

    MusicDTO addChanson(MusicDTO musicDTO);

    MusicDTO updateChanson(String id, MusicDTO musicDTO);

    void deleteChanson(String id);
    public void deleteChansonByTitre(String titre);
}
