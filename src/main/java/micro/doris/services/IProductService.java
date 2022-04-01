package micro.doris.services;


import micro.doris.entity.Product;
import micro.doris.viewmodel.ProductModel;

public interface IProductService {

   Product save(ProductModel product);

   Product findProductBySku(String sku);

    Product addStock(String sku, Integer cantidad);

}
