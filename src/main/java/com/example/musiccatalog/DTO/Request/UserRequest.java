package com.example.musiccatalog.DTO.Request;

import com.example.musiccatalog.Entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    private String username;
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;
    private List<Role> roles;
}
