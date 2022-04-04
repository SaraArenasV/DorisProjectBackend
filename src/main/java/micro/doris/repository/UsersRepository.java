package micro.doris.repository;


import micro.doris.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Integer>{
    public User findUsersByRutAndPassword(String rut, String password);
}
