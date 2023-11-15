//package com.PATCH.PetDatingApp.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    private final String secretKey;
//
//    public JwtRequestFilter(String secretKey) {
//        this.secretKey = secretKey;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwtToken = null;
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwtToken = authorizationHeader.substring(7);
//            try {
//                Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
//                username = claims.getSubject();
//                List<String> authorities = (List<String>) claims.get("authorities");
//
//                if (username != null) {
//                    Authentication auth = new UsernamePasswordAuthenticationToken(username, null, authorities.stream()
//                            .map(SimpleGrantedAuthority::new)
//                            .collect(Collectors.toList()));
//                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                }
//            } catch (Exception e) {
//                // Handle JWT validation errors, if any
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
