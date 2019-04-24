package io.swagger.api;

import io.swagger.model.WeightEntry;

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
public class ScaleApiControllerIntegrationTest {

    @Autowired
    private ScaleApi api;

    @Test
    public void insertScaleDataTest() throws Exception {
        WeightEntry body = new WeightEntry();
        ResponseEntity<Void> responseEntity = api.insertScaleData(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
