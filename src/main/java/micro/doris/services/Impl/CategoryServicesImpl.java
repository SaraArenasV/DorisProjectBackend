package micro.doris.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import micro.doris.entity.CategoryEntityJpa;
import micro.doris.repository.CategoryRepository;
import micro.doris.services.CategoryServices;
import micro.doris.to.Convert;

@Service
@Transactional
public class CategoryServicesImpl implements CategoryServices {

	@Autowired
	CategoryRepository usersRepositoryJpa;

	Convert converted = new Convert();

	static final String DELETED = "record deleted";
	static final String NOT_DELETED = "record not deleted, record name is :";

	@Override
	public CategoryEntityJpa getRecordByIdJpa(Long id) {
		CategoryEntityJpa res = usersRepositoryJpa.findUsersById(id);
		return res;
	}

	public Convert deleteRecordJpa(Long id) {

		try {
			usersRepositoryJpa.deleteById(id);

			converted.setMessage(DELETED);
			converted.setSuccess(true);
			return converted;

		} catch (RuntimeException e) {
			converted.setMessage(NOT_DELETED);
			converted.setSuccess(false);
			return converted;

		}
	}
}
