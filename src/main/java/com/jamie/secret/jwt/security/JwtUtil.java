package com.jamie.secret.jwt.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    static final long EXPIRATION_TIME = 3600_000; // 1 hour
    static final String SECRET = "JamieSever";
    public static final String TOKEN_PATTERN = "/secret/authentication/**";
    public static final String TOKEN_PREFIX = "Token:";
    public static final String HEADER_STRING = "Authorization";
    public static String generateToken(String username) {
        Map<String, Object> map = new HashMap<>();
        //you can put any data in the map
        map.put("username", username);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return jwt;
    }

    public static String validateToken(String token) {
        if (token != null) {
            // parse the token.
            Map<String,Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String username = (String) (body.get("username"));
            if(username == null || username.isEmpty())
                throw new TokenValidationException("Wrong token without username");
            else
                return username;
        }else{
            throw new TokenValidationException("Missing token");
        }
    }

    static class TokenValidationException extends RuntimeException {
        public TokenValidationException(String msg) {
            super(msg);
        }
    }
}