package micro.doris.controller;


import micro.doris.entity.Product;
import micro.doris.services.Impl.ProductService;
import micro.doris.viewmodel.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")

public class ProductApiController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct/{sku}")
    public ResponseEntity<?>  findById(@PathVariable(name="sku") String sku) {
        Product product = productService.findProductBySku(sku);
        return  new ResponseEntity<> (product, HttpStatus.OK);
    }

    @PostMapping("/saveProduct")
  public ResponseEntity<?> insert(@RequestBody ProductModel product) {
        Product productNew = productService.findProductBySku(product.getSku());
        if (productNew!=null){
            return new ResponseEntity<>("El sku ya existe", HttpStatus.NOT_FOUND.OK);
        }else {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }

    }


}
