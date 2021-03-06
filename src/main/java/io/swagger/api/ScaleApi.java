/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.7).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.WeightEntry;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-24T07:50:52.967Z[GMT]")
@Api(value = "scale", description = "the scale API")
public interface ScaleApi {

    @ApiOperation(value = "insert data from scale", nickname = "insertScaleData", notes = "", authorizations = {
        @Authorization(value = "bearerAuth")    }, tags={ "scale", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successsfully inserted data"),
        @ApiResponse(code = 400, message = "Bad request. Parameters not valid."),
        @ApiResponse(code = 401, message = "Authorization information is missing or invalid.") })
    @RequestMapping(value = "/scale/insertData",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> insertScaleData(@ApiParam(value = "The data to insert" ,required=true )  @Valid @RequestBody WeightEntry body);

}
