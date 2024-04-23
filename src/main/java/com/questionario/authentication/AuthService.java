package com.questionario.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.questionario.entities.User;
import com.questionario.jwt.JwtService;

@Service
public class AuthService implements UserDetailsService {
  @Autowired
  private JwtService jwtService;
  @Autowired
  private UserRepo userRepo;

  public UserDTO registerUser(UserDTO user){
    try{
      userRepo.save(new User(user.getName(), user.getEmail(), user.getPassword()));
      return user;
    } catch(Exception e){
      return null;
    }
  }

  public String authenticate(Authentication authentication){
    return jwtService.generateToken(authentication);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User userLogado = userRepo.findByEmail(email)
      .orElseThrow(() -> new UsernameNotFoundException("User não encontrado com esse email: " +  email));
    return userLogado;
  }
  
}
