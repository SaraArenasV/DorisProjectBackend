package micro.doris.controller;



import micro.doris.entity.Product;
import micro.doris.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Controller
@RequestMapping("/api")

public class ProductApiController {

    @Autowired
    IProductService service;

    // save
    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody Product request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.OK);
    }


    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestParam String sku, Integer cantidad) {
        return new ResponseEntity<>(service.addStock(sku,cantidad), HttpStatus.OK);
    }

}
