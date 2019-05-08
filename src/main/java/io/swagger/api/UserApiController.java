package io.swagger.api;

import io.swagger.database.*;
import io.swagger.model.StepEntry;
import io.swagger.model.UserData;
import io.swagger.model.Weight;
import io.swagger.model.WeightEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-24T07:50:52.967Z[GMT]")
@Controller
public class UserApiController implements UserApi {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StepsRepository stepsRepository;
    @Autowired
    private WeightRepository weightRepository;

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UserData> getCurrentUser() {
        MongoUser user = userRepository.findById(request.getUserPrincipal().getName());
        if(user == null) {
            return new ResponseEntity<UserData>(HttpStatus.UNAUTHORIZED);
        }

        UserData userData = new UserData();

        userData.setName(user.getName());
        userData.setEmail(user.getEmail());
        userData.setBirthday(user.getBirthday());
        userData.setHeight(user.getHeight());

        return new ResponseEntity<UserData>(userData, HttpStatus.OK);
    }

    public ResponseEntity<List<StepEntry>> getStepHistory(@Min(0)@ApiParam(value = "The number of items to skip before starting to collect the result set.", allowableValues = "") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Min(1) @Max(20) @ApiParam(value = "The numbers of items to return.", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        List<MongoSteps> steps = stepsRepository.findByUserOrderByTimestampDesc(request.getUserPrincipal().getName());
        List<StepEntry> outSteps = new ArrayList<>();
        for(MongoSteps step : steps) {
            outSteps.add(step.getStepEntry());
        }
        return new ResponseEntity<List<StepEntry>>(outSteps, HttpStatus.OK);
    }

    public ResponseEntity<List<WeightEntry>> getWeightHistory(@Min(0)@ApiParam(value = "The number of items to skip before starting to collect the result set.", allowableValues = "") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Min(1) @Max(20) @ApiParam(value = "The numbers of items to return.", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        List<MongoWeight> weights = weightRepository.findByUserOrderByTimestampDesc(request.getUserPrincipal().getName());
        List<WeightEntry> outWeight = new ArrayList<>();
        for(MongoWeight step : weights) {
            outWeight.add(step.getWeightEntry());
        }
        return new ResponseEntity<List<WeightEntry>>(outWeight, HttpStatus.OK);
    }

    public ResponseEntity<Void> insertUserData(@ApiParam(value = "The data to insert" ,required=true )  @Valid @RequestBody StepEntry body) {
        MongoSteps mongoSteps = new MongoSteps(request.getUserPrincipal().getName(), body);
        stepsRepository.save(mongoSteps);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
