package micro.doris.services.Impl;

import micro.doris.entity.Product;
import micro.doris.repository.ProductRepository;
import micro.doris.services.IProductService;
import micro.doris.util.CalendarUtil;
import org.springframework.stereotype.Service;

import java.sql.Date;


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


    @Override
    public Product addStock(String sku, Integer cantidad) {

    Product request = new Product();
    request=    repository.findBySku(sku);
         request.setStock(request.getStock()+cantidad);

        request.setIngressdate(Date.valueOf(CalendarUtil.todayString()));
        return repository.save(request);
    }



}
