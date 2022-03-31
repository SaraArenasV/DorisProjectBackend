package micro.doris.services.Impl;

import micro.doris.entity.Product;
import micro.doris.entity.User;
import micro.doris.repository.ProductRepository;
import micro.doris.services.IProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product request) {

        return repository.save(request);
    }
}
