package com.example.musiccatalog.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
public class Users {
    @Id
    private String id;
    private String username;
    private String password;

    private Boolean active;
    private List<Role> roles;



}
