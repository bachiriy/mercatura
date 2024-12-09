package com.mercatura.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mercatura.api.dto.auth.PostLoginDto;
import com.mercatura.api.dto.user.PostUserDto;
import com.mercatura.api.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody PostUserDto user){
        return service.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody PostLoginDto getLogin){
        return service.login(getLogin);
    }

    @PostMapping("logout")
    public ResponseEntity<String> logout(){
        return service.logout();
    }
}
