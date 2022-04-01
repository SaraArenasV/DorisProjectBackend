package micro.doris.services;

import micro.doris.entity.Product;

public interface IProductService {
    Product save(Product request);

    Product addStock(String sku, Integer cantidad);
}
