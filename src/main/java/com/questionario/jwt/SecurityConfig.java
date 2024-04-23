package com.questionario.jwt;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Value("${jwt.public.key}")
  private RSAPublicKey pub;
  @Value("${jwt.private.key}")
  private RSAPrivateKey priv; 

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http
    .authorizeRequests().antMatchers("/authenticate").permitAll().and().csrf().disable();
    // .httpBasic(Customizer.withDefaults())
    // .oauth2ResourceServer(
    //   config -> config.jwt(Customizer.withDefaults())
    // );
    return http.build();
  }

  @Bean
  JwtDecoder jwtDecoder(){
    return NimbusJwtDecoder.withPublicKey(pub).build();
  }

  @Bean
  JwtEncoder jwtEncoder(){
    //json web key
    RSAKey jwk = new RSAKey.Builder(pub).privateKey(priv).build();
    //json web keys
    var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
    return new NimbusJwtEncoder(jwks);
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
