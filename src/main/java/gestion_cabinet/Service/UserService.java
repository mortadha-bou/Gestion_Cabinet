package gestion_cabinet.Service;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.User;

import java.util.List;

public interface UserService {
    //ajouter user
    User ajouterUser(User user);

    // get User
    List<User> getAllUser();

    //get user by id
    User getUserById(int id);
    //get user by login and password
    User getUserByLoginPassword(String login,String password);

    // Update User
    User updateUser (User user, int id);

    // Delete User
    void deleteUserById(Integer Id);

}
