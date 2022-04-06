package micro.doris.controller;

import micro.doris.helper.IUserHelper;
import micro.doris.viewmodel.ValidationUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import micro.doris.services.IUserService;

import micro.doris.viewmodel.UserModel;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
@Controller

@RequestMapping("${openapi.MicroDoris.base-path:/api/v1/}")
public class UserApiController implements UserApi {


    IUserService service;
    IUserHelper helper;

    public UserApiController(IUserService service, IUserHelper helper) {
        this.service = service;
        this.helper = helper;
    }

    @Override

    public ResponseEntity<ValidationUserResponse> ValidateUser(@RequestBody UserModel request)  {

        return new ResponseEntity<>(service.verifyUser(helper.setUser(request)), HttpStatus.OK);
    }

}
