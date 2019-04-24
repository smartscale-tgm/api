package io.swagger.api;

import io.swagger.model.StepEntry;
import io.swagger.model.UserData;
import io.swagger.model.WeightEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-24T07:50:52.967Z[GMT]")
@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UserData> getCurrentUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<UserData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<StepEntry>> getStepHistory(@Min(0)@ApiParam(value = "The number of items to skip before starting to collect the result set.", allowableValues = "") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Min(1) @Max(20) @ApiParam(value = "The numbers of items to return.", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<StepEntry>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<WeightEntry>> getWeightHistory(@Min(0)@ApiParam(value = "The number of items to skip before starting to collect the result set.", allowableValues = "") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Min(1) @Max(20) @ApiParam(value = "The numbers of items to return.", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<WeightEntry>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> insertUserData(@ApiParam(value = "The data to insert" ,required=true )  @Valid @RequestBody StepEntry body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
