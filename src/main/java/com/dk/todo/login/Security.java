package com.dk.todo.login;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class Security 
{
    private UserDetails GetUserDetails(String userName, String pass) 
    {
        Function<String, String> passEncoder = input -> PassEncoder().encode(input);

        UserDetails userDetails = User.builder().
        passwordEncoder(passEncoder).
        username(userName).
        password(pass).
        roles("User", "Admin").build();
        return userDetails;
    }

    @Bean
    public InMemoryUserDetailsManager CreateUserDetailManager()
    {
        UserDetails user1 = GetUserDetails("DK", "pass");
        UserDetails user2 = GetUserDetails("Om", "pass");
        
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder PassEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }
}