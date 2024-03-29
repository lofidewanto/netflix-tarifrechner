package com.example.netflix.tarif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> {
                    request.antMatchers("/", "/greeting").permitAll();
                    request.anyRequest().authenticated();
                })
                .formLogin((form) -> {
                    form.loginPage("/login").permitAll();
                })
                .logout((logout) -> {
                    logout.permitAll();
                    logout.logoutSuccessUrl("/");
                });

        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("test").password("{noop}test").roles("USER").build();

        return new InMemoryUserDetailsManager(user);
    }
}