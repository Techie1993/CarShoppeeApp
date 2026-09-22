package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private UserService userve;

	// Password encoder
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {

		return new BCryptPasswordEncoder();
	}

	// Authentication Manager
	@Bean
	public AuthenticationManager authenticationManagerBean(
	        HttpSecurity http) throws Exception {


	    AuthenticationManagerBuilder auth =
	            http.getSharedObject(
	                    AuthenticationManagerBuilder.class
	            );


	    auth.userDetailsService(userve)
	    .passwordEncoder(pwdEncoder());

	    return auth.build();
	}
	
	
	// Security Filter Chain
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http

				// JWT साठी CSRF disable
				.csrf().disable()

				// JWT मध्ये session नको
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				.authorizeRequests()

				// Public URLs
				.antMatchers("/register", "/login", "/home", "/images/**", "/navigate", "/cars/new", "/seller",
						"/trust", "/cars", "/enlisted", "/garage", "/rti", "/logout", "/myaccount", "/pgarage",
						"/enlistedsellers", "/search", "/searchGarage", "/searchSeller", "/editprofile",
						"/profileImage/**", "/editprofile/**", "/contacts", "/chat/send", "/send", "/deletecars",
						"/deletegarage", "/deleteseller", "/details/**", "/garagedetails/**", "/sellerdetails/**",
						"/sellerImage/**", "/bookings", "/bookingservice", "/servicehistory", 
						"/payment","/creditcard","/mode")
				.permitAll()

				// बाकी URL साठी JWT required
				.anyRequest().authenticated();

		// JWT Filter add
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();

	}
}