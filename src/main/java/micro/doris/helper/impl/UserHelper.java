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
        data.setRut(input.getRut());
        data.setName (input.getName());
        data.setMail(input.getMail());
        data.setActive(input.isActive());
        data.setPassword (input.getPassword());
        return data;
    }

    @Override
    public User setUser(UserModel input) {
        User data = new User();
        data.setRut (input.getRut());
        data.setName(input.getName());
        data.setMail(input.getMail());
        data.setActive(input.isActive());
        data.setPassword (input.getPassword());
        return data;
    }
}
