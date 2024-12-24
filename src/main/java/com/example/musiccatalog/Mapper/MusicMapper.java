package com.example.musiccatalog.Mapper;


import com.example.musiccatalog.DTO.MusicDTO;
import com.example.musiccatalog.Entity.Music;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MusicMapper {

    MusicDTO toDto(Music music);

    List<MusicDTO> toDto(List<Music> music);

    Music toEntity(MusicDTO musicDTO);

    List<Music> toEntity(List<MusicDTO> musicDTOS);
}
