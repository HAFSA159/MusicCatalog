package com.example.musiccatalog.Service.Interface;

import com.example.musiccatalog.DTO.UserDTO;
import com.example.musiccatalog.DTO.Response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(String id);

    List<UserDTO> getAllUsers();

    Page<UserDTO> getAllUsersPaged(Pageable pageable);

    UserDTO updateUser(String id, UserDTO userDTO);

    void deleteUser(String id);
    public UserResponse registerUser(UserDTO request);
}
