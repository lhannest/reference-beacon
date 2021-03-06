package bio.knowledge.server.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bio.knowledge.server.model.ServerSummary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-04T11:27:59.578-07:00")

@Api(value = "types", description = "the types API")
public interface TypesApi {

    @ApiOperation(value = "", notes = "Get a list of types and # of instances in the knowledge source, and a link to the API call for the list of equivalent terminology ", response = ServerSummary.class, responseContainer = "List", tags={ "summary", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response with types and frequency returned ", response = ServerSummary.class) })
    @RequestMapping(value = "/types",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ServerSummary>> linkedTypes();

}
