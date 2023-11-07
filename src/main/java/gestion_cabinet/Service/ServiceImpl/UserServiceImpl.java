package gestion_cabinet.Service.ServiceImpl;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.User;
import gestion_cabinet.Repository.UserRepository;
import gestion_cabinet.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //ajouter User
    @Override
    public User ajouterUser(User user) {

        User user1 = userRepository.save(user);
        return user1;
    }
    //get User
    @Override
    public List<User> getAllUser() {
        return (List<User>)
                userRepository.findAll();
    }
    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id).get();
        return user;
    }
    @Override
    public User getUserByLoginPassword(String login , String password ) {
        User user = userRepository.findByLoginAndAndPassword(login,password);
        return user;
    }
    // Update User
    @Override
    public User updateUser (User user, int id) {
        User us = userRepository.findById(id).get();


        if (Objects.nonNull(user.getNom())
                && !"".equalsIgnoreCase(
                user.getNom())) {
            us.setNom(
                    user.getNom());
        }
        if (Objects.nonNull(user.getPrenom())
                && !"".equalsIgnoreCase(
                user.getPrenom())) {
            us.setPrenom(
                    user.getPrenom());
        }

        if (Objects.nonNull(user.getEmail())
                && !"".equalsIgnoreCase(
                user.getEmail())) {
            us.setEmail(
                    user.getEmail());
        }
        if (Objects.nonNull(user.getTel())
                && !"".equalsIgnoreCase(
                user.getTel())) {
            us.setTel(
                    user.getTel());
        }
        if (Objects.nonNull(user.getLogin())
                && !"".equalsIgnoreCase(
                user.getLogin())) {
            us.setLogin(
                    user.getLogin());
        }
        if (Objects.nonNull(user.getPassword())
                && !"".equalsIgnoreCase(
                user.getPassword())) {
            us.setPassword(
                    user.getPassword());
        }
        if (Objects.nonNull(user.getSex())
                && !"".equalsIgnoreCase(
                user.getSex())) {
            us.setSex(
                    us.getSex());
        }
        if (Objects.nonNull(user.getRole())
                && !"".equalsIgnoreCase(
                user.getRole().toString())) {
            us.setRole(
                    us.getRole());
        }



        return userRepository.save(us);

    }
    // Delete User
    @Override
    public void deleteUserById(Integer Id) {
        userRepository.deleteById(Id);
    }








}
