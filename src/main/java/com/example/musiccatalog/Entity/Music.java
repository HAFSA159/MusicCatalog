package com.example.musiccatalog.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "musics")
public class Music {
    @Id
    private String id;
    private String titre;
    private int duree;
    private int trackNumber;
    private String albumId;
}
