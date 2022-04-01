package micro.doris.repository;

import micro.doris.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product getBySku(String sku);

	List<Product> findByIdcategory(Integer id);

	public Product findBySku(String sku);

}
