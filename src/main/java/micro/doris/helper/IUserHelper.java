package micro.doris.helper;

import micro.doris.entity.User;
import micro.doris.viewmodel.UserModel;

public interface IUserHelper {
    UserModel setUser(User input);

    User setUser(UserModel input);
}
