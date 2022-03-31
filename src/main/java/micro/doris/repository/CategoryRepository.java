package micro.doris.repository;

import micro.doris.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    public Category findByIdAndName(Integer id, String name);
}
