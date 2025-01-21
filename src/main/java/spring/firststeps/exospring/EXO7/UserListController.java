package spring.firststeps.exospring.EXO7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.firststeps.exospring.EXO7.Class.User;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserListController {

    private List<User> userList = new ArrayList<>();
    private int id = 0;

    @PostMapping("")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        id++;
        user.setId(id);
        userList.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur ajouté avec l'ID : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
        for (int i = 0; i < userList.size() ; i++) {
            if(userList.get(i).getId() == id) {
                userList.add(id, user);
                return ResponseEntity.ok().body("Utilisateur mis à jour");
            }
        }
        return ResponseEntity.status(404).body("Utilisateur non trouvé");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        for (int i = 0; i < userList.size() ; i++) {
            if(userList.get(i).getId() == id) {
                userList.remove(id);
                return ResponseEntity.ok().body("Utilisateur supprimé");
            }
        }
        return ResponseEntity.status(404).body("Utilisateur non trouvé");
    }

}
