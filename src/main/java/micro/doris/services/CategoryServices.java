package micro.doris.services;

import micro.doris.entity.CategoryEntityJpa;
import micro.doris.entity.CategoryRequestEntity;
import micro.doris.to.Convert;

public interface CategoryServices {

	CategoryEntityJpa getRecordByNameId(CategoryRequestEntity nameId);

	Convert deleteRecordJpa(CategoryRequestEntity nameId);

}
