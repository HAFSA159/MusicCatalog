package com.example.musiccatalog.Service.Interface;


import com.example.musiccatalog.DTO.RoleDTO;
import com.example.musiccatalog.Entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(RoleDTO roleDTO);

    RoleDTO getRoleById(String id);

    List<RoleDTO> getAllRoles();

    Page<RoleDTO> getAllRolesPaged(Pageable pageable);

    RoleDTO updateRole(String id, RoleDTO roleDTO);

    void deleteRole(String id);
    public Role findByName(String name);
}
