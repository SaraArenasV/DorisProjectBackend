package micro.doris.services.Impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import micro.doris.entity.Category;
import micro.doris.viewmodel.CategoryRequest;
import micro.doris.repository.CategoryRepository;
import micro.doris.to.Convert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CategoryServiceTests {

	@Test
	void contextLoads() {
	}

	@Mock
	CategoryRepository usersRepositoryJpa;

	@InjectMocks
	CategoryServicesImpl categoryServiceImpl;

	Convert response = new Convert();

	@Test
	public void mockDeleteRecordJpaValidation() {

		CategoryRequest request = new CategoryRequest();
		request.setId(5);

		response = categoryServiceImpl.deleteRecordJpa(request);

		assertEquals(response.getSuccess(), false);

	}

	@Test
	public void mockGetRecordByIdJpa() {
		CategoryRequest req = new CategoryRequest();
		req.setId(1);
		req.setName("wood");

		Category customer = new Category();
		customer.setActive("Y");
		customer.setId(1);
		customer.setName("Test Forest name");

		Mockito.when(usersRepositoryJpa.findByIdAndName(req.getId(), req.getName())).thenReturn(customer);

		Category response = categoryServiceImpl.getRecordByNameId(req);

		assertNotNull("The object you enter return null", response.getName());
	}

}
