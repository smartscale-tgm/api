package io.swagger.api;

import io.swagger.model.StepEntry;
import io.swagger.model.UserData;
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
public class UserApiControllerIntegrationTest {

    @Autowired
    private UserApi api;

    @Test
    public void getCurrentUserTest() throws Exception {
        ResponseEntity<UserData> responseEntity = api.getCurrentUser();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getStepHistoryTest() throws Exception {
        Integer offset = 56;
        Integer limit = 56;
        ResponseEntity<List<StepEntry>> responseEntity = api.getStepHistory(offset, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getWeightHistoryTest() throws Exception {
        Integer offset = 56;
        Integer limit = 56;
        ResponseEntity<List<WeightEntry>> responseEntity = api.getWeightHistory(offset, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void insertUserDataTest() throws Exception {
        StepEntry body = new StepEntry();
        ResponseEntity<Void> responseEntity = api.insertUserData(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
