package micro.doris.services.Impl;

import micro.doris.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import micro.doris.entity.Category;
import micro.doris.viewmodel.CategoryRequest;
import micro.doris.repository.CategoryRepository;
import micro.doris.to.Convert;

@Service
@Transactional
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository repository;

	Convert converted = new Convert();
	boolean categoryExist;

	static final String DELETED = "record deleted";
	static final String NOT_DELETED = "record not deleted, record name is :";

	@Override
	public Category getRecordByNameId(CategoryRequest nameId) {
		Category res = repository.findByIdAndName(nameId.getId(), nameId.getName());
		return res;
	}

	public Convert deleteRecordJpa(CategoryRequest nameId) {

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

	public boolean validateCategory(CategoryRequest nameId) {
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

	public boolean validateProduct(CategoryRequest nameId) {

		if (nameId.getId() <= 10) {
			categoryExist = true;
		} else
			categoryExist = false;
		return categoryExist;
	}



	public Category save(Category request) {


		return repository.save(request);
	}



}
