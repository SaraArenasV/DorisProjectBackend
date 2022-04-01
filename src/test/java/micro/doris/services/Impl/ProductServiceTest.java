package micro.doris.services.Impl;



import micro.doris.entity.Product;
import micro.doris.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.sql.Date;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

   @Mock
   ProductRepository productDao;
    @InjectMocks
    ProductService productService;



}
