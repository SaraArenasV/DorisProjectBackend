package micro.doris.services.Impl;


import micro.doris.entity.Product;
import micro.doris.repository.ProductRepository;
import micro.doris.services.IProductService;
import micro.doris.viewmodel.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(ProductModel productFront){
        Product product = new Product(productFront.getSku(),productFront.getBrand(),productFront.getDescription(),productFront.getStock(),
                productFront.getIngressDate(),productFront.getOutgress(), productFront.getIdCategory());

        return  productRepository.save(product);
    }

    public Product findProductBySku(String sku){
        return productRepository.getBySku(sku);
    }
}
