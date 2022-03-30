package micro.doris.repository;

import micro.doris.entity.CategoryEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntityJpa, Integer> {

	public CategoryEntityJpa findUsersById(Long id);

	void deleteById(Long id);

}
