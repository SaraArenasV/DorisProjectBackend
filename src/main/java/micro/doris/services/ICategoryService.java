package micro.doris.services;

import micro.doris.entity.Category;
import micro.doris.viewmodel.CategoryRequest;
import micro.doris.to.Convert;

import java.util.List;

public interface ICategoryService {

	Category getRecordByNameId(CategoryRequest nameId);

	Convert deleteRecordJpa(CategoryRequest nameId);

	Category save(Category request);

	List<Category> findAll();
}
