package com.sti.myspringboot.config;

import com.sti.myspringboot.filter.AuthenticationFilter;
import com.sti.myspringboot.repositories.IStudentRepository;
import com.sti.myspringboot.services.IStudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final IStudentRepository studentRepository;
    private final IStudentService studentService;

    public SecurityConfig(IStudentRepository studentRepository, IStudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        return security.csrf(AbstractHttpConfigurer::disable)// deshabilita cors
                .authorizeHttpRequests(
                        auth->auth.requestMatchers("/v1/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new AuthenticationFilter(studentRepository, studentService), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
