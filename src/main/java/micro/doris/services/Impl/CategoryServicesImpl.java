package micro.doris.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import micro.doris.entity.CategoryEntityJpa;
import micro.doris.entity.CategoryRequestEntity;
import micro.doris.repository.CategoryRepository;
import micro.doris.services.CategoryServices;
import micro.doris.to.Convert;

import java.util.Locale;

@Service
@Transactional
public class CategoryServicesImpl implements CategoryServices {

	@Autowired
	CategoryRepository repository;

	Convert converted = new Convert();
	boolean categoryExist;

	static final String DELETED = "record deleted";
	static final String NOT_DELETED = "record not deleted, record name is :";

	@Override
	public CategoryEntityJpa getRecordByNameId(CategoryRequestEntity nameId) {
		CategoryEntityJpa res = repository.findByIdAndName(nameId.getId(), nameId.getName());
		return res;
	}

	public Convert deleteRecordJpa(CategoryRequestEntity nameId) {

		if (validateCategory(nameId) && validateProduct(nameId)) {
			try {
				repository.deleteById(nameId.getId());

				converted.setMessage(DELETED);
				converted.setSuccess(true);

				return converted;

			} catch (RuntimeException e) {
				e.getMessage();
				converted.setMessage(NOT_DELETED);
				converted.setSuccess(false);

				return converted;

			}
		} else
			converted.setMessage(" : Category what you trying to delete not exist ");
		converted.setSuccess(false);
		return converted;

	}

	public boolean validateCategory(CategoryRequestEntity nameId) {
		try {
			if (repository.findByIdAndName(nameId.getId(), nameId.getName()) != null) {
				categoryExist = true;
			} else
				categoryExist = false;

		} catch (RuntimeException e) {
			e.getMessage();
			categoryExist = false;

		}
		return categoryExist;
	}

	public boolean validateProduct(CategoryRequestEntity nameId) {

		if (nameId.getId() <= 10) {
			categoryExist = true;
		} else
			categoryExist = false;
		return categoryExist;
	}



	public CategoryEntityJpa save(CategoryEntityJpa request) {


		return repository.save(request);
	}



}
