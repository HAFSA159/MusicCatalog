package com.example.musiccatalog.Controller;

import com.example.musiccatalog.DTO.UserDTO;
import com.example.musiccatalog.Service.Interface.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Utilisateur ajouté avec succès !");
        response.put("data", createdUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable String id) {
        UserDTO user = userService.getUserById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Utilisateur récupéré avec succès !");
        response.put("data", user);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Liste des utilisateurs récupérée avec succès !");
        response.put("data", users);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paged")
    public ResponseEntity<Map<String, Object>> getAllUsersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserDTO> users = userService.getAllUsersPaged(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Page des utilisateurs récupérée avec succès !");
        response.put("data", users);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(
            @PathVariable String id,
            @Valid @RequestBody UserDTO userDTO
    ) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Utilisateur modifié avec succès !");
        response.put("data", updatedUser);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Utilisateur supprimé avec succès !");
        return ResponseEntity.ok(response);
    }
}
