package com.mercatura.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mercatura.api.dto.auth.PostLoginDto;
import com.mercatura.api.dto.user.PostUserDto;
import com.mercatura.api.mapper.UserMapper;
import com.mercatura.api.repository.UserRepository;

@Service
public class AuthService {
   @Autowired UserRepository userRepository;
   @Autowired AuthenticationManager authManager;
   @Autowired UserMapper userMapper;


   public ResponseEntity<String> login(PostLoginDto getLogin){
      UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(getLogin.getUsername(), getLogin.getPassword());

      Authentication auth = authManager.authenticate(authToken);
      SecurityContextHolder.getContext().setAuthentication(auth);
      return ResponseEntity.ok("Login success.");
   }

   public ResponseEntity<String> register(PostUserDto user){
      if (userRepository.existsByUsername(user.getUsername())) {
         return ResponseEntity.badRequest().body("Username is already taken");
      }
      userRepository.save(userMapper.toEntity(user));

      return ResponseEntity.ok("User created.");
   }

   public ResponseEntity<String> logout(){
      SecurityContextHolder.clearContext();
      return ResponseEntity.ok("Logged out.");
   }
}
