package com.example.musiccatalog.Controller;


import com.example.musiccatalog.DTO.Response.JwtAuthenticationResponse;
import com.example.musiccatalog.DTO.UserDTO;
import com.example.musiccatalog.DTO.Response.UserResponse;
import com.example.musiccatalog.Scurity.JwtTokenProvider;
import com.example.musiccatalog.Service.Interface.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserDTO userRequest) {
       UserResponse response =  userService.registerUser(userRequest);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(
            @Valid @RequestBody UserDTO userRequest
    ) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()

                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        JwtAuthenticationResponse jwt = new JwtAuthenticationResponse();
        jwt.setAccessToken(tokenProvider.generateToken(authentication,userRequest.getRoles()));
        return ResponseEntity.ok(jwt);
    }

}

