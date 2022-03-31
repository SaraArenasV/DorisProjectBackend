package micro.doris.repository;

import micro.doris.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findByIdAndName(Integer id, String Name);
	

}
