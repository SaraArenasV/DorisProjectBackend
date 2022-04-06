package micro.doris.controller;

import micro.doris.entity.Category;
import micro.doris.services.ICategoryService;
import micro.doris.services.IProductService;
import micro.doris.to.Convert;
import micro.doris.viewmodel.CategoryRequest;
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

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ProductApiControllerTest {

    static final String OK = "200 OK";
    static final Integer REQUEST_ID = 1;

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
    IProductService service;
    @InjectMocks
    ProductApiController controller;


    @Test
    public void delete() {

        Mockito.when(service.deleteProductById(REQUEST_ID)).thenReturn(convert);
        ResponseEntity<Convert> callResult = controller.delete(REQUEST_ID);
        HttpStatus code = callResult.getStatusCode();
        assertEquals(code.toString(), OK);
    }


}
