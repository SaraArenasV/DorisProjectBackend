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

import java.util.Date;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

   @Mock
   ProductRepository productDao;
    @InjectMocks
    ProductService productService;


    @Test
    public void testSave() {

        Date date = new Date();
        Product product =  new Product("001","122","Harina",12,date,date,1);
        Mockito.when(productDao.save(product)).thenReturn(product);
        Product productSave= productDao.save(product);
        assertEquals(productSave.getSku(),"001" );

    }
}
