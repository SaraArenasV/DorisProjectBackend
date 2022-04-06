package micro.doris.helper.impl;

import micro.doris.entity.Product;
import micro.doris.entity.User;
import micro.doris.helper.IProductHelper;
import micro.doris.viewmodel.ProductModelRequesst;
import micro.doris.viewmodel.UserModel;
import org.springframework.stereotype.Service;

@Service
public class ProductHelper implements IProductHelper {

    @Override
    public ProductModelRequesst setProduct(Product input) {
        ProductModelRequesst data = new ProductModelRequesst();
        data.setBrand(input.getBrand());
        data.setDescription(input.getDescription());
        data.setIdCategory(input.getIdcategory());
        data.setSku(input.getSku());
        data.setStock (input.getStock());
        return data;
    }

    @Override
    public Product setProduct(ProductModelRequesst input) {
        Product data = new Product();
        data.setBrand(input.getBrand());
        data.setDescription(input.getDescription());
        data.setIdcategory(input.getIdCategory());
        data.setSku(input.getSku());
        data.setStock (input.getStock());
        return data;
    }
}
