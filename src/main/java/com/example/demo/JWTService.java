package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;
import io.jsonwebtoken.security.Keys;
import java.util.function.Function;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTService {

	// Secret key should be minimum 256 bits for HS256
	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkeymysecretkey123456";

	private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

	// Generate JWT Token
	public String generateToken(String username) {

		Map<String, Object> claims = new HashMap<>();

		return createToken(claims, username);
	}

	// Create Token
	private String createToken(Map<String, Object> claims, String username) {

		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))

				// Token 1 hour
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))

				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	// Extract Username from Token
	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);
	}

	// Extract Expiry Date
	public Date extractExpiration(String token) {

		return extractClaim(token, Claims::getExpiration);
	}

	// Generic Claim Extractor
	public <T> T extractClaim(String token, Function<Claims, T> resolver) {

		final Claims claims = extractAllClaims(token);

		return resolver.apply(claims);
	}

	// Extract All Claims
	private Claims extractAllClaims(String token) {

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	// Check Token Expired
	private Boolean isTokenExpired(String token) {

		return extractExpiration(token).before(new Date());
	}

	// Validate Token
	public Boolean validateToken(String token, String username) {

		final String tokenUsername = extractUsername(token);

		return (tokenUsername.equals(username) && !isTokenExpired(token));
	}
}
