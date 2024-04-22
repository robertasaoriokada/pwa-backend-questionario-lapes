package com.questionario.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http){
    http.csrf().disable()
    .authorizeRequests(
      auth -> auth.requestMatchers("/authenticate").permitAll()
      .anyRequest().authenticated())
    .httpBasic(Customizer.withDefaults())
    .oauth2ResourceServer(
      config -> config.jwt(Customizer.withDefaults())
    );
    return http.build();
  }

}
