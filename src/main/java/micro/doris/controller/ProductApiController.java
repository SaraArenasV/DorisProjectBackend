package micro.doris.controller;

import micro.doris.entity.Product;
import micro.doris.services.IProductService;
import micro.doris.services.Impl.ProductService;
import micro.doris.viewmodel.ProductModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Validated
@Controller
@RequestMapping("/api")
public class ProductApiController {

	@Autowired
	private IProductService service;

	@GetMapping("/getProduct/{sku}")
	public ResponseEntity<?> findById(@PathVariable(name = "sku") String sku) {
		Product product = service.findProductBySku(sku);
		if (product != null)
			return new ResponseEntity<>(product, HttpStatus.OK);
		else
			return new ResponseEntity<>("El sku no existe", HttpStatus.OK);
	}

	@GetMapping("/getProductByIdList/{id}")
	public ResponseEntity<?> findByIdsl(@PathVariable(name = "id") Integer id) {
		List<Product> product = service.findProductById(id);
		if (product.size() > 0)
			return new ResponseEntity<>(product, HttpStatus.OK);
		else
			return new ResponseEntity<>("Product not have assigned requested category", HttpStatus.OK);
	}

	@PostMapping("/saveProduct")
	public ResponseEntity<?> insert(@RequestBody ProductModel product) {
		Product productNew = service.findProductBySku(product.getSku());
		if (productNew != null) {
			return new ResponseEntity<>("El sku ya existe", HttpStatus.NOT_FOUND.OK);
		} else {
			return new ResponseEntity<>(service.save(product), HttpStatus.OK);
		}

	}

	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestParam String sku, Integer cantidad) {
		return new ResponseEntity<>(service.addStock(sku, cantidad), HttpStatus.OK);
	}

}
