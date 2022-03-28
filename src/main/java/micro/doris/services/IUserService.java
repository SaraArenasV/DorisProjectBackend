package micro.doris.services;

import micro.doris.entity.User;

public interface IUserService {
    Boolean verifyUser (User request);

    User save(User request);
}
