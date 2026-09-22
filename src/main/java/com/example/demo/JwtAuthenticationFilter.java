package com.example.demo;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;




@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
    private JWTService jwtService;


    @Autowired
    private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 String token = null;
	        String username = null;


	        String header =
	                request.getHeader("Authorization");



	        if(header != null && header.startsWith("Bearer ")) {

	            token = header.substring(7);

	            username =
	                jwtService.extractUsername(token);
	        }



	        if(username != null &&
	           SecurityContextHolder
	           .getContext()
	           .getAuthentication() == null) {



	            UserDetails userDetails =
	                    userService
	                    .loadUserByUsername(username);



	            UsernamePasswordAuthenticationToken auth =
	                    new UsernamePasswordAuthenticationToken(
	                            userDetails,
	                            null,
	                            userDetails.getAuthorities()
	                    );



	            SecurityContextHolder
	            .getContext()
	            .setAuthentication(auth);

	        }



	        filterChain.doFilter(request, response);

	    }
	}


