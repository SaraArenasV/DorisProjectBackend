package micro.doris.services.Impl;

import micro.doris.entity.Product;
import micro.doris.repository.ProductRepository;
import micro.doris.services.IProductService;
import micro.doris.util.CalendarUtil;
import micro.doris.viewmodel.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository repository;

    public Product save(ProductModel productFront){
        Product product = new Product(productFront.getSku(),productFront.getBrand(),productFront.getDescription(),productFront.getStock(),
                productFront.getIngressDate(),productFront.getOutgress(), productFront.getIdCategory());

        return  repository.save(product);
    }

    public Product findProductBySku(String sku){
        return repository.getBySku(sku);
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
