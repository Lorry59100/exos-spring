package spring.firststeps.exospring.EXO6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.firststeps.exospring.EXO6.Class.Task;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private List<Task> tasks = new ArrayList<>();
    private int id = 1;

    @PostMapping("")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        task.setId(id++);
        tasks.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tâche ajoutée : " + task.getTitle() + " avec l'id : " + task.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.add(id,task);
                return ResponseEntity.ok().body("Tâche mise à jour : " + task.getTitle());
            }
        }
        return ResponseEntity.status(404).body("Tâche non trouvée");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                return ResponseEntity.ok().body("Tâche supprimée");
            }
        }
        return ResponseEntity.status(404).body("Tâche non trouvée");
    }

}
