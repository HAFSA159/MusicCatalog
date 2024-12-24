package com.example.musiccatalog.Controller;


import com.example.musiccatalog.DTO.RoleDTO;
import com.example.musiccatalog.Service.Interface.RoleService;
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
@RequestMapping("/api/admin/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createRole(@Valid @RequestBody RoleDTO roleDTO) {
        RoleDTO createdRole = roleService.createRole(roleDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rôle ajouté avec succès !");
        response.put("data", createdRole);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getRoleById(@PathVariable String id) {
        RoleDTO role = roleService.getRoleById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rôle récupéré avec succès !");
        response.put("data", role);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Liste des rôles récupérée avec succès !");
        response.put("data", roles);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paged")
    public ResponseEntity<Map<String, Object>> getAllRolesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RoleDTO> roles = roleService.getAllRolesPaged(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Page des rôles récupérée avec succès !");
        response.put("data", roles);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateRole(
            @PathVariable String id,
            @Valid @RequestBody RoleDTO roleDTO
    ) {
        RoleDTO updatedRole = roleService.updateRole(id, roleDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rôle modifié avec succès !");
        response.put("data", updatedRole);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rôle supprimé avec succès !");
        return ResponseEntity.ok(response);
    }
}
