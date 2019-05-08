package io.swagger.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.swagger.database.MongoUser;
import io.swagger.database.UserRepository;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

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
        if(body.getEmail() == null || body.getPassword() == null) {
            return new ResponseEntity<Jwt>(HttpStatus.BAD_REQUEST);
        }
        MongoUser user = this.userRepository.findByEmail(body.getEmail().toLowerCase());
        if(!user.getPassword().equals(body.getPassword())) {
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

        if(!EmailValidator.getInstance().isValid(body.getEmail())) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
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
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Jwt> renewToken() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Jwt>(HttpStatus.NOT_IMPLEMENTED);
    }

}
