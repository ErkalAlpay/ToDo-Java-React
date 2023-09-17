package com.erkalalpay.todofullstack.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenService {

    private final static String secretKey= "secretKey";
    private final Algorithm algorithm= Algorithm.HMAC512(secretKey);

    public String generateToken(String email){
        String token = JWT.
                create().
                withSubject(email).
                sign(algorithm);
        return token;
    }

    public String getTokenMail(String token){
        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
        return decodedJWT.getSubject();
    }


}
