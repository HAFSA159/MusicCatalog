package com.example.musiccatalog.Service.Implimentation;

import com.example.musiccatalog.DTO.UserDTO;
import com.example.musiccatalog.DTO.Response.UserResponse;
import com.example.musiccatalog.Entity.Role;
import com.example.musiccatalog.Entity.Users;
import com.example.musiccatalog.Mapper.UserMapper;
import com.example.musiccatalog.Repository.UserRepository;
import com.example.musiccatalog.Service.Interface.RoleService;
import com.example.musiccatalog.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Users user = userMapper.toEntity(userDTO);
        Users savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(String id) {
        Optional<Users> user = userRepository.findById(id);
        return user.map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'id : " + id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<UserDTO> getAllUsersPaged(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDTO);
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'id : " + id));
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setRoles(userMapper.toEntity(userDTO).getRoles());
        Users updatedUser = userRepository.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur non trouvé avec l'id : " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse registerUser(UserDTO request) {
        Users user = userMapper.toEntity(request);
       //Role role = roleService.findByName("USER");
        //user.setRoles(Collections.singletonList(role));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        UserResponse response = new UserResponse();
        response.setUsername(user.getUsername());
        response.setRoles(user.getRoles().stream()
                .map(Role::getName)
                .toList());

        return response;
    }

}
