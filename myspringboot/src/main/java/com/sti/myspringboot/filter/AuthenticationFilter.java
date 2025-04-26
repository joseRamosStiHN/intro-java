package com.sti.myspringboot.filter;

import com.sti.myspringboot.repositories.IStudentRepository;
import com.sti.myspringboot.services.IStudentService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    private final IStudentRepository studentRepository;
    private final IStudentService studentService;

    public AuthenticationFilter(IStudentRepository studentRepository, IStudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //revisar las cookies o headers
        final String header = request.getHeader("Auth");
        logger.info("header {}", header);
        if(header== null || header.isEmpty()){
            logger.error("no existe el header");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"No se encontró el header\"}");
            response.getWriter().flush();
            response.getWriter().close();
            return;
        }
        long count = studentRepository.count();
        logger.info("rows in db {}", count);


        //get user info
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(header, null);
        SecurityContextHolder.getContext().setAuthentication(user);

        filterChain.doFilter(request, response);
    }
}
