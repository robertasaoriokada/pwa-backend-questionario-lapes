package com.questionario.authentication;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthRepo extends JpaRepository<UserDTO, String>{

}
