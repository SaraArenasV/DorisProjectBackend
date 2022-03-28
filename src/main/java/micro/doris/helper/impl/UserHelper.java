package micro.doris.helper.impl;

import micro.doris.entity.User;
import micro.doris.helper.IUserHelper;
import micro.doris.viewmodel.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserHelper implements IUserHelper {

    @Override
    public UserModel setUser(User input) {
        UserModel data = new UserModel();
        data.setId(input.getId());
        data.setUser (input.getUser());
        data.setPassword (input.getPassword());
        return data;
    }

    @Override
    public User setUser(UserModel input) {
        User data = new User();
        data.setId(input.getId());
        data.setUser (input.getUser());
        data.setPassword (input.getPassword());
        return data;
    }
}
