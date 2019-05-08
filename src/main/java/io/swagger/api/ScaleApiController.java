package io.swagger.api;

import io.swagger.database.MongoSteps;
import io.swagger.database.MongoWeight;
import io.swagger.database.WeightRepository;
import io.swagger.model.WeightEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ScaleApiController implements ScaleApi {

    @Autowired
    private WeightRepository weightRepository;

    private static final Logger log = LoggerFactory.getLogger(ScaleApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ScaleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> insertScaleData(@ApiParam(value = "The data to insert" ,required=true )  @Valid @RequestBody WeightEntry body) {
        MongoWeight mongoWeight = new MongoWeight(request.getUserPrincipal().getName(), body);
        weightRepository.save(mongoWeight);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
