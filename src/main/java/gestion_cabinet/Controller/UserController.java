package gestion_cabinet.Controller;

import gestion_cabinet.Dto.AuthentificationDTO;
import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.User;
import gestion_cabinet.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path="/users")
public class UserController {

    @Autowired
public UserService userService;
    //ajouter user
    @PostMapping("")
    ResponseEntity <User> ajouterUser(@RequestBody User user){
        User U=userService.ajouterUser(user);
        return new ResponseEntity<>(U,HttpStatus.OK);
    }

    //get User
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers()
    {
        List<User> userList= userService.getAllUser();
        return new ResponseEntity<>(userList,
                HttpStatus.OK);
    }
    //get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id)
    {
        User user= userService.getUserById(id);
        return new ResponseEntity<>(user,
                HttpStatus.OK);
    }
    //get user by id
    @PostMapping("/auth")
    public ResponseEntity<User> getUserByLoginPassword(@RequestBody AuthentificationDTO authentificationDTO)
    {
        User user= userService.getUserByLoginPassword(authentificationDTO.getLogin(),authentificationDTO.getPassword());
        return new ResponseEntity<>(user,
                HttpStatus.OK);
    }
    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable("id") int id)
    {
        User U= userService.updateUser(user, id);
        return new ResponseEntity<>(U,
                HttpStatus.OK);
    }
    // Delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer Id)
    {
        userService.deleteUserById(Id);
        return new ResponseEntity<>("Deleted Successfully",
                HttpStatus.OK);

    }

}
