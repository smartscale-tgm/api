package io.swagger.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.swagger.database.MongoUser;
import io.swagger.database.UserRepository;
import io.swagger.error.HttpStatusError;
import io.swagger.model.Authenticate;
import io.swagger.model.Jwt;
import io.swagger.model.RegisterData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;

import static io.swagger.security.JWTAuthenticationFilter.generateJwtToken;
import static io.swagger.security.SecurityConstants.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-24T07:50:52.967Z[GMT]")
@Controller
public class PublicApiController implements PublicApi {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger log = LoggerFactory.getLogger(PublicApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public PublicApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Jwt> authenticate(@ApiParam(value = "The authenticate details", required = true) @Valid @RequestBody Authenticate body) {
        if (body.getEmail() == null || body.getPassword() == null) {
            return new ResponseEntity<Jwt>(HttpStatus.BAD_REQUEST);
        }
        MongoUser user = this.userRepository.findByEmail(body.getEmail().toLowerCase());
        if (!user.getPassword().equals(body.getPassword())) {
            return new ResponseEntity<Jwt>(HttpStatus.BAD_REQUEST);
        }

        Jwt ret = new Jwt();
        Algorithm algorithm = Algorithm.HMAC256("secret");
        ret.setJwt(JWT.create()
                .withClaim("email", user.getEmail())
                .sign(algorithm));

        return new ResponseEntity<Jwt>(ret, HttpStatus.OK);
    }

    public ResponseEntity<Void> publicPingGet() {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> register(@ApiParam(value = "", required = true) @Valid @RequestBody RegisterData body) {

        if (!EmailValidator.getInstance().isValid(body.getEmail())) {
            throw new HttpStatusError("Email is not valid.", HttpStatus.BAD_REQUEST);
            //return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        try {
            MongoUser user = new MongoUser(
                    body.getEmail(),
                    this.bCryptPasswordEncoder.encode(body.getPassword()),
                    body.getName(),
                    body.getHeight(),
                    body.getBirthday()
            );

            userRepository.save(user);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Testing the test 1");
        }
    }

    public ResponseEntity<Jwt> renewToken() {
        String token = request.getHeader(HEADER_STRING);

        if (token == null) {
            return new ResponseEntity<Jwt>(HttpStatus.UNAUTHORIZED);
        }

        try {
            DecodedJWT decodedJWT = JWT.decode(token.replace(TOKEN_PREFIX, ""));

            if ((decodedJWT.getExpiresAt().getTime() + EXPIRATION_TIME) < new Date(System.currentTimeMillis()).getTime()) {
                return new ResponseEntity<Jwt>(HttpStatus.UNAUTHORIZED);
            }

            MongoUser user = userRepository.findById(decodedJWT.getSubject());

            Jwt newToken = new Jwt(generateJwtToken(
                    user.getId(),
                    user.getRoles().toArray(new String[]{})
            ));

            return new ResponseEntity<>(newToken, HttpStatus.OK);
        } catch (JWTDecodeException e) {
            return new ResponseEntity<Jwt>(HttpStatus.UNAUTHORIZED);
        }
    }

}
