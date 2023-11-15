package com.PATCH.PetDatingApp.util;


import com.PATCH.PetDatingApp.configuration.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;

    @Autowired
    public JwtAuthenticationFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authorizationHeader = request.getHeader("Authorization");
//
//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid or missing Authorization header");
//            return;
//        }
//
//        String jwtToken = authorizationHeader.replace("Bearer ", "");
//        try {
//            Jws<Claims> claimsJws = Jwts.parser()
//                    .setSigningKey(jwtConfig.getSecretKey())
//                    .parseClaimsJws(jwtToken);
//
//            String email = claimsJws.getBody().getSubject();
//            request.setAttribute("email", email);
//        } catch (Exception e) {
//            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid or expired JWT token");
//            return;
//        }
//
//        try {
//            filterChain.doFilter(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        // Allow access to /user/login and /user/register without token
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/user/login") || requestURI.equals("/user/register")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid or missing Authorization header");
            return;
        }

        String jwtToken = authorizationHeader.replace("Bearer ", "");
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(jwtConfig.getSecretKey())
                    .parseClaimsJws(jwtToken);

            String email = claimsJws.getBody().getSubject();
            request.setAttribute("email", email);
        } catch (Exception e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid or expired JWT token");
            return;
        }

        try {
            filterChain.doFilter(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}
