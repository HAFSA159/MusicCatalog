package com.example.musiccatalog.Mapper;


import com.example.musiccatalog.DTO.UserDTO;
import com.example.musiccatalog.Entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users toEntity(UserDTO userDTO);

    UserDTO toDTO(Users user);
}
