
package micro.doris.services.Impl;

import micro.doris.entity.Product;
import micro.doris.repository.ProductRepository;
import micro.doris.services.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product request) {

        return productRepository.save(request);
    }

}
