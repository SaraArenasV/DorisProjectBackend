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

import micro.doris.entity.Category;
import micro.doris.viewmodel.CategoryRequest;
import micro.doris.services.ICategoryService;
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
	ICategoryService categoryService;
	@InjectMocks
	CategoryController controller;
	
	@Test
	public void mockDeleteCategoryByIdJpa() {
		CategoryRequest request = new CategoryRequest();
		request.setId(1);

		Mockito.when(categoryService.deleteRecordJpa(request)).thenReturn(convert);
		ResponseEntity<Convert> callResult = controller.delete(request);
		HttpStatus code = callResult.getStatusCode();
		assertEquals(code.toString(), OK);
	}


	@Test
	public void mockFindByNameIdJpa() {
		CategoryRequest req = new CategoryRequest();
		req.setId(1);

		Category customer = new Category();
		customer.setId(1);
		customer.setActive("Y");
		customer.setName("wood");

		Mockito.when(categoryService.getRecordByNameId(req)).thenReturn(customer);
		ResponseEntity<Category> callResult = controller.findByNameId(req);
		HttpStatus code = callResult.getStatusCode();
		Integer id = callResult.getBody().getId();

		assertEquals(id.toString(), ID);
		assertEquals(code.toString(), OK);
	}
	

}
