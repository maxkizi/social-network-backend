package org.maxkizi.socialnetworkbackend.config.security;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetworkbackend.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ConditionalOnProperty(name = "security.enabled", havingValue = "false")
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityDisabledConfig {
    @Value("${security.principalUsername}")
    private String principalUsername;
    private final UserDetailsRepository repository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                    .sessionManagement()
                .and()
                    .cors()
                .and()
                    .csrf().disable()
                .addFilterAfter(new OncePerRequestFilter() {
                    @Override
                    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                        SecurityContextHolder.getContext().setAuthentication(
                                new UsernamePasswordAuthenticationToken(
                                        repository.findByUsername(principalUsername).get(),
                                        null,
                                        null
                                ));
                        filterChain.doFilter(request, response);
                    }
                }, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated();


        return http.build();
    }


}