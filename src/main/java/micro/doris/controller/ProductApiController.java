package micro.doris.controller;

import micro.doris.services.Impl.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductApiController {

    ProductService service;

    public ProductApiController(ProductService service) {
        this.service = service;
    }

    public ResponseEntity<Boolean> ValidateUser(@RequestBody UserModel request)  {
        Boolean response = (service.save(helper.setUser(request)));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
