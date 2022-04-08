package micro.doris.services.Impl;


import micro.doris.entity.User;
import micro.doris.repository.UsersRepository;
import micro.doris.services.IUserService;
import micro.doris.viewmodel.ValidationUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UsersRepository usersRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public ValidationUserResponse verifyUser(User request) {
        ValidationUserResponse response = new ValidationUserResponse();
      User userResponse = new User();
      userResponse = usersRepository.findUsersByRutAndPassword(request.getRut(), request.getPassword());

        if (userResponse != null){
       response.setValid(true);
       response.setUsername(userResponse.getUsername());
   }

        return response;
    }

    @Override
    public User save(User request) {

        return usersRepository.save(request);
    }
}
