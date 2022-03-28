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
        userlogin.setId(1);
        userlogin.setRut("test_junit");
        userlogin.setPassword("1234");

        repository.save(userlogin);
        Assertions.assertThat(userlogin.getId()).isGreaterThan(0);
    }


    @Test
    public void optein_false_for_default() {
        User user = new User();
        user.setRut("test");
        user.setPassword("123");
        Assert.assertFalse(userService.verifyUser(user));

    }

}
