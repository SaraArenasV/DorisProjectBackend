package micro.doris.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import micro.doris.entity.CategoryEntityJpa;
import micro.doris.services.CategoryServices;
import micro.doris.to.Convert;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CategoryControllerTest {

	static final String OK = "200 OK";
	static final String ID = "1";

	@Test
	void contextLoads() {
	}

	Map<String, String> body = new HashMap<>();
	Convert convert = new Convert();

	@Before
	public void createMock() {
		convert.setMessage("performed correct");
		convert.setSuccess(true);

	}

	@Mock
	CategoryServices categoryService;
	@InjectMocks
	CategoryController controller;

	@Test
	public void mockDeleteCategoryByIdJpa() {


		Mockito.when(categoryService.deleteRecordJpa(1L)).thenReturn(convert);
		ResponseEntity<Convert> callResult = controller.deleteJpa(1L);
		HttpStatus code = callResult.getStatusCode();
		assertEquals(code.toString(), OK);
	}

	@Test
	public void mockFindByID() {

		CategoryEntityJpa customer = new CategoryEntityJpa();
		customer.setId(1L);
		customer.setActive("Y");
		customer.setName("wood");

		Mockito.when(categoryService.getRecordByIdJpa(1L)).thenReturn(customer);
		ResponseEntity<CategoryEntityJpa> callResult = controller.findByIdJpa(1L);
		HttpStatus code = callResult.getStatusCode();
		Long id = callResult.getBody().getId();

		assertEquals(id.toString(), ID);
		assertEquals(code.toString(), OK);
	}

}
