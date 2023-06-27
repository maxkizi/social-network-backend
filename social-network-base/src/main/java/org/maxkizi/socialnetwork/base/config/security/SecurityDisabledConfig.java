package org.maxkizi.socialnetwork.base.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.maxkizi.socialnetwork.common.repository.UserDetailsRepository;
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

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ConditionalOnProperty(name = "security.enabled", havingValue = "false")
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
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

    @PostConstruct
    public void printWarn(){
        log.warn("SECURITY DISABLED, PRINCIPAL USER WITH USERNAME: {}", principalUsername);
    }
}