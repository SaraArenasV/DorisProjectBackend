package micro.doris.controller;

import javassist.NotFoundException;
import micro.doris.entity.Product;
import micro.doris.helper.IProductHelper;
import micro.doris.services.IProductService;
import micro.doris.services.Impl.ProductService;
import micro.doris.to.Convert;
import micro.doris.viewmodel.CategoryRequest;
import micro.doris.viewmodel.ProductModel;

import java.util.List;

import micro.doris.viewmodel.ProductModelRequesst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "*")
@Validated
@Controller
@RequestMapping("/api")
public class ProductApiController {

	@Autowired
	private IProductService service;

	private IProductHelper helper;

	public ProductApiController(IProductHelper helper) {
		this.helper = helper;
	}

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
	
	// Delete By Id
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<Convert> delete(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(service.deleteProductById(id), HttpStatus.OK);
	}

	@PostMapping("/saveProduct")
	public ResponseEntity<?> insert(@RequestBody ProductModelRequesst product) {
		Product productNew = service.findProductBySku(product.getSku());
		if (productNew != null) {
			return new ResponseEntity<>("El sku ya existe", HttpStatus.NOT_FOUND.OK);
		} else {
			return new ResponseEntity<>(service.save(helper.setProduct(product)), HttpStatus.OK);
		}

	}

	@PostMapping("/addstock")
	public ResponseEntity<Product> addProduct(@RequestBody String sku, Integer cantidad) {
		return new ResponseEntity<>(service.addStock(sku, cantidad), HttpStatus.OK);
	}

	@GetMapping("/getproductlist")
	public ResponseEntity<List<Product>> getListProducts()  {
		return new ResponseEntity<>(service.findAllProduct(), HttpStatus.OK );
	}
}
