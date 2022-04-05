package micro.doris.services;

import java.util.List;

import micro.doris.entity.Product;
import micro.doris.to.Convert;
import micro.doris.viewmodel.ProductModel;

public interface IProductService {

	Product save(ProductModel product);

	Product findProductBySku(String sku);
	
	Convert deleteProductById (Integer id);
	
	List<Product> findProductById(Integer id);

	Product addStock(String sku, Integer cantidad);

	List<Product> findAllProduct();
}
