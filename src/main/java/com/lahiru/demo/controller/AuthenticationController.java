package com.lahiru.demo.controller;

import com.lahiru.demo.dto.JwtRequestDto;
import com.lahiru.demo.dto.JwtResponseDto;
import com.lahiru.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/api/v1/jwt")
    public String jwt() {
        return "Welcome to JWT";
    }

    @PostMapping("/api/v1/authenticate")
    public JwtResponseDto authenticate(@RequestBody JwtRequestDto jwtRequestDto) throws Exception{

        return authenticationService.authenticate(jwtRequestDto);
    }

    @GetMapping("/api/v1/logged-in-user")
    public ResponseEntity<?> getLoggedInUser() {
        Map<String, String> username = new HashMap<>();
        username.put("username", authenticationService.getLoggedInUser());
        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
