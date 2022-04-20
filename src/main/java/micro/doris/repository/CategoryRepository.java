package micro.doris.repository;

import micro.doris.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findByIdAndName(Integer id, String Name);
	public Category findByName (String name);
	public List<Category> findByActive(String active);

}
