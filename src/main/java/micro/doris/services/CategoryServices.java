package micro.doris.services;

import micro.doris.entity.CategoryEntityJpa;
import micro.doris.to.Convert;

public interface CategoryServices {

	CategoryEntityJpa getRecordByIdJpa(Long id);

	Convert deleteRecordJpa(Long id);

}
