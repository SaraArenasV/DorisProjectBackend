package micro.doris.helper;

import micro.doris.entity.Product;
import micro.doris.viewmodel.ProductModelRequesst;

public interface IProductHelper {
    ProductModelRequesst setProduct(Product input);

    Product setProduct(ProductModelRequesst input);

}
