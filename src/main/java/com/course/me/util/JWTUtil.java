package com.course.me.util;

import com.course.me.exception.TicketException;
import com.course.me.model.User;
import io.jsonwebtoken.*;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class JWTUtil {

    private String mySignKey="Dhinesh";

    public String createToken(User userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("issuedBy" , "Ticket Server");
        claims.put("roles" , userDetails.getRoles());
        claims.put("username", userDetails.getEmail());
        claims.put("iat", Instant.now().getEpochSecond());
        long millSecondsTime = new Date().getTime() + 30*60*1000;
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(mySignKey.getBytes())).setExpiration(new Date(millSecondsTime)).compact();
    }

    public Claims claimToken(String token){
        try{
            return Jwts.parser().setSigningKey(Base64.getEncoder().encode(mySignKey.getBytes())).parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
//        logger.info("Invalid JWT signature.");
//        logger.trace("Invalid JWT signature trace: {}", e);
        throw new TicketException(HttpStatus.UNAUTHORIZED,"Invalid JWT signature", e);
    } catch (MalformedJwtException e) {
//        logger.info("Invalid JWT token.");
//        logger.trace("Invalid JWT token trace: {}", e);
        throw new TicketException(HttpStatus.UNAUTHORIZED,"Invalid JWT token", e);
    } catch (ExpiredJwtException e) {
//        logger.info("Expired JWT token.");
//        logger.trace("Invalid JWT token trace {}", e);
        throw new TicketException(HttpStatus.UNAUTHORIZED,"Invalid JWT token", e);
    } catch (ClaimJwtException e) {
//        logger.info("Claiming the JWT token is Failed");
//        logger.trace("Claiming JWT token trace: {}", e);
        throw new TicketException(HttpStatus.UNAUTHORIZED,"Claiming JWT token", e);
    }
    }

    public boolean isTokenExpired(String token){
            return claimToken(token).getExpiration().before(new Date());
    }
}
