package com.example.demo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        // Validate registrationRequest and handle registration logic
        // ...

        // Save the new user to the database
        userRepository.save(new User(registrationRequest.getUsername(), passwordEncoder.encode(registrationRequest.getPassword())));

        return ResponseEntity.ok("Registration successful!");
    }
}
