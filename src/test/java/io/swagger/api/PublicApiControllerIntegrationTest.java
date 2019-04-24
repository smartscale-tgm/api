package io.swagger.api;

import io.swagger.model.Authenticate;
import io.swagger.model.Jwt;
import io.swagger.model.RegisterData;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicApiControllerIntegrationTest {

    @Autowired
    private PublicApi api;

    @Test
    public void authenticateTest() throws Exception {
        Authenticate body = new Authenticate();
        ResponseEntity<Jwt> responseEntity = api.authenticate(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void publicPingGetTest() throws Exception {
        ResponseEntity<Void> responseEntity = api.publicPingGet();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void registerTest() throws Exception {
        RegisterData body = new RegisterData();
        ResponseEntity<Void> responseEntity = api.register(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void renewTokenTest() throws Exception {
        ResponseEntity<Jwt> responseEntity = api.renewToken();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
