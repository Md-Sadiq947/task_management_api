package com.sadique.task_api.config;

import com.sadique.task_api.service.UserDetailServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Autowired
    private UserDetailServiceIMPL userDetailServiceIMPL;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(userDetailServiceIMPL)
                .csrf(AbstractHttpConfigurer::disable) // Pehle CSRF disable karo
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/task/**","/user/**","/user").authenticated() // Lock this
                        // Explicitly open these
                        .anyRequest().permitAll() // Safety net: open everything else
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
