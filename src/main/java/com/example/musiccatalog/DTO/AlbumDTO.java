package com.example.musiccatalog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlbumDTO {
    private String id;
    private String titre;
    private String artiste;
    private Integer annee;
    private List<MusicDTO> chansons;
}
