package micro.doris.services;

import micro.doris.entity.Category;
import micro.doris.viewmodel.CategoryRequest;
import micro.doris.to.Convert;

public interface ICategoryService {

	Category getRecordByNameId(CategoryRequest nameId);

	Convert deleteRecordJpa(CategoryRequest nameId);

	Category save(Category request);
}
