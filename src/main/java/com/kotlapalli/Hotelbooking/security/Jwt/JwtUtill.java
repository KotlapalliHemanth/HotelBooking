package com.kotlapalli.Hotelbooking.security.Jwt;

import java.security.Key;
import java.util.Date;

import com.kotlapalli.Hotelbooking.models.Auth.User;
import com.kotlapalli.Hotelbooking.repositories.Auth.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtUtill {

	@Autowired
	private UserRepository userRepo;
	
	private final Key key;
	private final int accessTokenExpirationMs;
	private final int refreshTokenExpirationMs;
	
	public JwtUtill( @Value("${jwt.screct}") String screctKey,@Value("${jwt.expirationMs}") int accessTokenExpirationMs,@Value("${jwt.refreshExpirationMs}") int refreshTokenExpirationMs) {
		this.key = Keys.hmacShaKeyFor(screctKey.getBytes());
		this.accessTokenExpirationMs = accessTokenExpirationMs;
		this.refreshTokenExpirationMs= refreshTokenExpirationMs;
	}
	
	public String generateAccessTokken(User user) {
		return Jwts.builder()
					.setSubject(user.getUsername())
			        .claim("role", user.getRole().name())
			        .setIssuedAt(new Date())
			        .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpirationMs))
			        .signWith(key, SignatureAlgorithm.HS512)
			        .compact();
	}
	
	public boolean validateToken(String Token) {
		Claims claim= getAllClaimsFromToken(Token);
		
		User user= userRepo.findByEmailOrUsername(claim.getAudience()).orElse(null);
		if(claim.getExpiration().before(new Date()) ) {
			System.out.println("Token Expired");
			return false;
		}else if( user ==null){
			System.out.println("user does not exist");
			return false;
		}else if ((user.getRole().name().equals(claim.get("role", String.class)))) {
			System.out.println("Role does not match");
			return false;
		}else {
			return true;
		}
	}
	
	public Claims getAllClaimsFromToken(String Token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(Token)
				.getBody();
	}
}
