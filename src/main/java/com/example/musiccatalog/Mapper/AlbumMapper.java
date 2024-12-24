package com.example.musiccatalog.Mapper;

import com.example.musiccatalog.DTO.AlbumDTO;
import com.example.musiccatalog.Entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MusicMapper.class})
public interface AlbumMapper {

    AlbumDTO toDTO(Album album);
    Album toEntity(AlbumDTO albumDTO);
    List<AlbumDTO> toDTO(List<Album> albums);
}
