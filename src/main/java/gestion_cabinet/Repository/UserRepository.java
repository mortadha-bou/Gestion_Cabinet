package gestion_cabinet.Repository;

import gestion_cabinet.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLoginAndAndPassword(String Login , String Password);
}
