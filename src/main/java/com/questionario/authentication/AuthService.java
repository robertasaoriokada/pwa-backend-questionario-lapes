package com.questionario.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.questionario.jwt.JwtService;

@Service
public class AuthService {
  @Autowired
  private JwtService jwtService;
  public String authenticate(Authentication authentication){
    return jwtService.generateToken(authentication);
  }
}
