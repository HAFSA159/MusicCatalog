package com.example.musiccatalog.Mapper;


import com.example.musiccatalog.DTO.RoleDTO;
import com.example.musiccatalog.Entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleDTO roleDTO);

    RoleDTO toDTO(Role role);
}
