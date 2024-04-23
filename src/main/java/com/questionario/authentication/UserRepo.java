package com.questionario.authentication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionario.entities.User;


public interface UserRepo extends JpaRepository<User, String>{
  Optional<User> findByEmail(String email);
}
