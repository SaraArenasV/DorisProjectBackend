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

import java.sql.Date;
import java.util.Calendar;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

   @Mock
   ProductRepository productDao;
    @InjectMocks
    ProductService productService;

    long miliseconds = System.currentTimeMillis();
    Date date = new Date(miliseconds);

    @Test
    public void testGet(){
        Product product =  new Product("l9383","122","Harina",12,date,date,1);
        Mockito.when(productDao.getBySku("l9383")).thenReturn(product);
        Product productSave = productService.findProductBySku("l9383");
        assertEquals(productSave.getSku(),"l9383" );

    }

    @Test
    public void testSave() {

        Product product =  new Product("001","122","Harina",12,  date,  date,1);
        Mockito.when(productDao.save(product)).thenReturn(product);
        Product productSave= productDao.save(product);
        assertEquals(productSave.getSku(),"001" );

    }
}
