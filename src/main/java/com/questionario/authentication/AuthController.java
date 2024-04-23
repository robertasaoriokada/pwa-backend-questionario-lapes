package com.questionario.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  @Autowired
  AuthService authService;

  @PostMapping("register")
  public String registerUser(@RequestBody UserDTO user){
    authService.registerUser(user);
    return authService.authenticate(null);
  }

  @PostMapping("authenticate")
  public String authenticate(@RequestBody Authentication authentication){
    return authService.authenticate(authentication);
  }

  @GetMapping("authenticate")
  public String mensagem(){
    return "BAIACUUUUUUUUUUUUU";
  }
}
