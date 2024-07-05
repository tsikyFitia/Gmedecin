package com.exam.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((auth)->auth
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/client/**").hasAnyRole("CLIENT", "ADMIN")
                .requestMatchers("/medecin/**").hasAnyRole("MEDECIN", "ADMIN")
                .requestMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
        ).httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails client = User.builder()
                .username("client")
                .password(passwordEncoder().encode("client"))
                .roles("CLIENT")
                .build();
        UserDetails medecin = User.builder()
                .username("medecin")
                .password(passwordEncoder().encode("medecin"))
                .roles("MEDECIN")
                .build();

        return new InMemoryUserDetailsManager(admin, client, medecin);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
