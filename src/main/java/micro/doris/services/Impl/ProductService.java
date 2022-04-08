package micro.doris.services.Impl;

import micro.doris.entity.Category;
import micro.doris.entity.Product;
import micro.doris.repository.CategoryRepository;
import micro.doris.repository.ProductRepository;
import micro.doris.services.IProductService;
import micro.doris.to.Convert;
import micro.doris.to.ProductCategory;
import micro.doris.util.CalendarUtil;
import micro.doris.viewmodel.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    Convert converted = new Convert();

    static final String DELETED = "record deleted";
    static final String NOT_DELETED = "Record not deleted, please look at log :";

    public Product save(ProductModel productFront) {
        Product product = new Product(productFront.getSku(), productFront.getBrand(), productFront.getDescription(),
                productFront.getStock(),Date.valueOf(CalendarUtil.todayString()) , productFront.getOutgress(),
                productFront.getIdCategory());


        return repository.save(product);
    }

    public Product findProductBySku(String sku) {
        return repository.getBySku(sku);
    }

    @Override
    public Product addStock(String sku, Integer cantidad) {

        Product request = new Product();
        request = repository.findBySku(sku);
        request.setStock(request.getStock() + cantidad);

        request.setIngressdate(Date.valueOf(CalendarUtil.todayString()));
        return repository.save(request);
    }

    @Override
    public List<Product> findProductById(Integer id) {
        return repository.findByIdcategory(id);
    }

    @Override
    public Convert deleteProductById(Integer id) {
        try {
            Optional<Product> products = repository.findById(id);
            products.get().getId();
            repository.deleteById(id);

            converted.setMessage(DELETED);
            converted.setSuccess(true);
            return converted;
        } catch (RuntimeException e) {
            converted.setMessage(NOT_DELETED);
            converted.setSuccess(false);

        }
        return converted;
    }


    @Override
    public List<Product> findAllProduct() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findAllProductCategory() {
        List<ProductCategory> response = new ArrayList<>();
        try {
            List<Product> allProducts = findAllProduct();
            for (int i = 0; i < allProducts.size(); i++) {
                Product product = allProducts.get(i);
                Integer idCategory = product.getIdcategory();
                      Category categoryEntity = categoryRepository.getById(idCategory);
				ProductCategory productAndCategory = new ProductCategory();
                try {

                    if (categoryEntity != null && categoryEntity.getId() != null) {

                        productAndCategory.setId(product.getId());
                        productAndCategory.setIdcategory(product.getIdcategory());
                        productAndCategory.setCategoryName(categoryEntity.getName());
                        productAndCategory.setBrand(product.getBrand());
                        productAndCategory.setDescription(product.getDescription());
                        productAndCategory.setStock(product.getStock());
                        productAndCategory.setIngressdate(product.getIngressdate());
                        productAndCategory.setOutgress(product.getOutgress());
                        productAndCategory.setActive(product.getActive());
                        productAndCategory.setSku(product.getSku());

                        response.add(productAndCategory);
                    } else {

                        System.out.println("there is no category");
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());


					productAndCategory.setId(product.getId());
					productAndCategory.setIdcategory(product.getIdcategory());
					productAndCategory.setCategoryName(" ");
					productAndCategory.setBrand(product.getBrand());
					productAndCategory.setDescription(product.getDescription());
					productAndCategory.setStock(product.getStock());
					productAndCategory.setIngressdate(product.getIngressdate());
					productAndCategory.setOutgress(product.getOutgress());
					productAndCategory.setActive(product.getActive());
					productAndCategory.setSku(product.getSku());
					System.out.println("there is no category assigned for product with categoryId = " + product.getIdcategory());
					response.add(productAndCategory);

                }
            }
        } catch (RuntimeException e) {
            System.out.println("doris have exception " + e.getMessage());
        }
        return response;
    }
}
