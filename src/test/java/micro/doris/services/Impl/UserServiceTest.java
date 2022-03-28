package micro.doris.services.Impl;

import micro.doris.entity.User;
import micro.doris.repository.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UsersRepository repository;
    @InjectMocks
    private UserService userService;

    @Test
    public void test_save_repository() {
        User userlogin =  new User();

        userlogin.setRut("123456789");
        userlogin.setPassword("1234");
        userlogin.setMail("ifyumx@gmail.com");
//        userlogin.setActive(true);
        repository.save(userlogin);

        Assertions.assertThat(userlogin.getRut()).isEqualTo("123456789");
        Assertions.assertThat(userlogin.getPassword()).isEqualTo("1234");
        Assertions.assertThat(userlogin.getMail()).isEqualTo("ifyumx@gmail.com");
//        Assertions.assertThat(repository.findUsersByRutAndPassword("123456789","1234")).isEqualTo("ifyumx@gmail.com") ;
//        Assert.assertTrue(userlogin.isActive());
    }


}
