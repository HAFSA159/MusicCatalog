package com.example.musiccatalog.DTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private String id;

    @NotBlank(message = "Le nom du rôle est obligatoire")
    private String name;
}
