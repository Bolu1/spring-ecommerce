package com.springecommerce.ecommerce.controller;

import com.springecommerce.ecommerce.config.JwtService;
import com.springecommerce.ecommerce.interfaces.AuthenticationRequest;
import com.springecommerce.ecommerce.interfaces.AuthenticationResponse;
import com.springecommerce.ecommerce.interfaces.RegisterRequest;
import com.springecommerce.ecommerce.models.User;
import com.springecommerce.ecommerce.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody RegisterRequest request
    ){
        User user = service.getUserByEmail(request.getEmail()).orElse(null);
        if(user != null){
            return ResponseEntity.badRequest().body(String.format("Email %s already in use", request.getEmail()));
        }
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody AuthenticationRequest request
    ){
        User user = service.getUserByEmail(request.getEmail()).orElse(null);
        System.out.println(user);
        if(user == null){
            return ResponseEntity.badRequest().body("Invalid login details");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.matches(request.getPassword(), user.getPassword()));
        if(!encoder.matches(request.getPassword(), user.getPassword())){
            return ResponseEntity.badRequest().body("Invalid login details");
        }
        var jwtToken = jwtService.generateToken(user);

        return ResponseEntity.ok(AuthenticationResponse.builder()
                .token(jwtToken)
                .build());
    }
}
