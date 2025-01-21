package spring.firststeps.exospring.EXO3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    HashMap<Integer, String> userList = new HashMap<Integer, String>();
    public UserController() {
        userList.put(1, "Alice");
        userList.put(2, "Jean");
        userList.put(3, "Jacques");
        userList.put(4, "Rousseau");
    }

    @GetMapping("/user/{id}")
    public String getSingleUser(@PathVariable int id) {
        return "Utilisateur :" + userList.get(id);
    }

    @GetMapping("/user/all")
    public String getUserList() {
        return "Liste des utlisateurs :" + userList;
    }

}
