package micro.doris.services.Impl;


import micro.doris.entity.User;
import micro.doris.repository.UsersRepository;
import micro.doris.services.IUserService;
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
    public Boolean verifyUser(User request) {
        Boolean response = false;

   if (usersRepository.findUsersByUserAndPassword(request.getRut(), request.getPassword()) !=null){
       response = true;
   }

        return response;
    }

    @Override
    public User save(User request) {

        return usersRepository.save(request);
    }
}
