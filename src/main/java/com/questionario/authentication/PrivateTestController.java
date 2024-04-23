package com.questionario.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateTestController {
  
  @GetMapping("private")
  public String getMessage(){
    return "Conseguiu, hehehe";
  }
  
}
