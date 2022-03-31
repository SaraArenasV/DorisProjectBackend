package micro.doris.controller;

import micro.doris.entity.Category;
import micro.doris.entity.Product;
import micro.doris.services.Impl.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@Controller
@RequestMapping("/api")
public class ProductApiController {

    ProductService service;

    public ProductApiController(ProductService service) {
        this.service = service;
    }

    // save
    @PostMapping("/Product")
    public ResponseEntity<Product> save(@RequestBody Product request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.OK);
    }
}
