package micro.doris.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import micro.doris.viewmodel.ValidationUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import micro.doris.viewmodel.UserModel;

@CrossOrigin(origins = "*")
@Validated
@Api(value = "UserApi", description = "the User API")
public interface UserApi {


    @ApiOperation(value = "permite validar login usuario", nickname = "userValidation", notes = "TRUE = SUCCES \n FALSE = REJECT", tags={ "user-api-controller", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "válido"),
            @ApiResponse(code = 400, message = "Petición incorrecta"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/userValidation",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ValidationUserResponse> ValidateUser(@RequestBody UserModel request);


}
