package com.questionario.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AuthController {
  @Autowired
  AuthService authService;

  @PostMapping("authenticate")
  public String authenticate(Authentication authentication){
    return authService.authenticate(authentication);
  }
}
