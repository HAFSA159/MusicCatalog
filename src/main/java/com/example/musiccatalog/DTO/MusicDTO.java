package com.example.musiccatalog.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MusicDTO {

    private String id;

    @NotBlank(message = "Le titre de la chanson est obligatoire")
    private String titre;

    @NotNull(message = "La durée de la chanson est obligatoire")
    @Min(value = 1, message = "La durée doit être supérieure à 0")
    private int duree;

    @NotNull(message = "Le numéro de piste est obligatoire")
    @Min(value = 1, message = "Le numéro de piste doit être supérieur ou égal à 1")
    private int trackNumber;

    @NotBlank(message = "L'ID de l'album est obligatoire")
    private String albumId;
}
