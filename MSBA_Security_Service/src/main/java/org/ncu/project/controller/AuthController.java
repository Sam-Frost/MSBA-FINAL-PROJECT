package org.ncu.project.controller;

import org.ncu.project.dto.AuthRequest;
import org.ncu.project.entity.UserCredential;
import org.ncu.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
//            throw new RuntimeException("invalid access");
        	return("Invalid Access WORKING");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        return service.validateToken(token);
    }
}