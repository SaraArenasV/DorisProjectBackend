package micro.doris.services.Impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import micro.doris.entity.CategoryEntityJpa;
import micro.doris.repository.CategoryRepository;
import micro.doris.to.Convert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CategoryServiceTests {

	private static final long L1 = 1L;
	private static final long L2 = 2L;

	@Test
	void contextLoads() {
	}

	@Mock
	CategoryRepository usersRepositoryJpa;

	@InjectMocks
	CategoryServicesImpl categoryServiceImpl;


	Convert response = new Convert();

	@Test
	public void mockDeleteRecordJpa() {

		response = categoryServiceImpl.deleteRecordJpa(L1);

		assertEquals(response.getSuccess(), true);

	}

	@Test
	public void mockGetRecordByIdJpa() {
		
		CategoryEntityJpa customer = new CategoryEntityJpa();
		customer.setActive("Y");
		customer.setId(L1);
		customer.setName("Test Forest name");
		
		Mockito.when(usersRepositoryJpa.findUsersById(L2)).thenReturn(customer);
		
		
		CategoryEntityJpa response = categoryServiceImpl.getRecordByIdJpa(L2);

		assertNotNull("The object you enter return null", response.getName());
	}

}
