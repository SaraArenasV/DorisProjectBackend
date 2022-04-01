package micro.doris.controller;



import micro.doris.entity.Product;
import micro.doris.services.IProductService;
import micro.doris.services.Impl.ProductService;
import micro.doris.viewmodel.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/api")

public class ProductApiController {

    @Autowired
    private IProductService service;


    @GetMapping("/getProductBySku/{sku}")
    public ResponseEntity<?>  findBySku(@PathVariable(name="sku") String sku) {
        Product product = service.findProductBySku(sku);
        if (product!=null)
        return  new ResponseEntity<> (product, HttpStatus.OK);
        else
            return new ResponseEntity<>("El sku no existe", HttpStatus.OK);
    }

    @PostMapping("/saveProduct")
  public ResponseEntity<?> insert(@RequestBody ProductModel product) {
        Product productNew = service.findProductBySku(product.getSku());
        if (productNew!=null){
            return new ResponseEntity<>("El sku ya existe", HttpStatus.NOT_FOUND.OK);
        }else {
            return new ResponseEntity<>(service.save(product), HttpStatus.OK);
        }

    }
//

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestParam String sku, Integer cantidad) {
        return new ResponseEntity<>(service.addStock(sku,cantidad), HttpStatus.OK);
    }


}
