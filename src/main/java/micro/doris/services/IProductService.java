package micro.doris.services;

import java.util.List;

import micro.doris.entity.Product;
import micro.doris.viewmodel.ProductModel;

public interface IProductService {

	Product save(ProductModel product);

	Product findProductBySku(String sku);
	
	List<Product> findProductById(Integer id);

	Product addStock(String sku, Integer cantidad);

}
