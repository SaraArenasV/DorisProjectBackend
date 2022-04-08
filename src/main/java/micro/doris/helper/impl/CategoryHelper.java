package micro.doris.helper.impl;

import micro.doris.entity.Category;
import micro.doris.entity.Product;
import micro.doris.helper.ICategoryHelper;
import micro.doris.repository.CategoryRepository;
import micro.doris.repository.ProductRepository;
import micro.doris.to.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryHelper implements ICategoryHelper {
    @Autowired
    ProductRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<ProductCategory> getProductsWithCategoryName() {

        List<ProductCategory> response = new ArrayList<>();
        try {
            List<Product> allProducts = repository.findAll();
            for (int i = 0; i < allProducts.size(); i++) {

                Product product = allProducts.get(i);
                Integer idCategory = product.getIdcategory();
                Category categoryEntity = categoryRepository.getById(idCategory);
                Boolean validateCategory = validateCategoryEntity(categoryEntity);
                ProductCategory productAndCategory = new ProductCategory();

                try {
                    if (validateCategory) {

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

                        System.out.println("there is no category, empty string is assigned for categoryName, ID category from product is = " + product.getIdcategory());

                        response.add(productAndCategory);
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("there is no category assigned for product with categoryId = " + product.getIdcategory());
                }
            }
        } catch (RuntimeException e) {
            System.out.println("doris have exception " + e.getMessage());
        }
        return response;
    }

    Boolean validateCategoryEntity(Category categoryEntity) {
        Boolean categoryExist;
        try {
            Integer id = categoryEntity.getId();
            String name = categoryEntity.getName();

            if (!id.toString().isEmpty() || !name.isEmpty()) {
                categoryExist = true;
            } else {
                categoryExist = false;
            }
        } catch (RuntimeException e) {
            categoryExist = false;
        }
        return categoryExist;
    }

}
