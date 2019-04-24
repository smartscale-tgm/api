package io.swagger.api;

import io.swagger.model.AnonymUserData;

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
public class AdminApiControllerIntegrationTest {

    @Autowired
    private AdminApi api;

    @Test
    public void getUsersTest() throws Exception {
        Integer offset = 56;
        Integer limit = 56;
        ResponseEntity<List<AnonymUserData>> responseEntity = api.getUsers(offset, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
