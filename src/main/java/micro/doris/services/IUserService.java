package micro.doris.services;

import micro.doris.entity.User;
import micro.doris.viewmodel.ValidationUserResponse;

public interface IUserService {
    ValidationUserResponse verifyUser (User request);

    User save(User request);
}
