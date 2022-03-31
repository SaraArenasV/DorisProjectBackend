package micro.doris.services.Impl;

import micro.doris.entity.Category;
import micro.doris.repository.CategoryRepository;
import micro.doris.services.ICategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {


    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
       public Category save(Category request) {

        return categoryRepository.save(request);
    }


}
