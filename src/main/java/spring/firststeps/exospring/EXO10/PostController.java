package spring.firststeps.exospring.EXO10;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.firststeps.exospring.EXO10.Class.Posts;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private List<Posts> postsList = new ArrayList<>();
    private int id = 0;

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody Posts posts) {
        id++;
        posts.setId(id);
        postsList.add(posts);
        return ResponseEntity.status(HttpStatus.CREATED).body("Article ajouté avec l'ID : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@RequestBody Posts posts, @PathVariable int id) {
        for (int i = 0; i < postsList.size(); i++) {
            if(postsList.get(i).getId() == id) {
                if(posts.getTitle() == null) {
                    posts.setTitle(postsList.get(i).getTitle());
                }
                if(posts.getContent() == null) {
                    posts.setContent(postsList.get(i).getContent());
                }
                postsList.get(i).setTitle(posts.getTitle());
                postsList.get(i).setContent(posts.getContent());
                return ResponseEntity.ok().body("Post mis à jour : " + postsList.get(i).getTitle() + " contenu : " + postsList.get(i).getContent() );
            }
        }
        return ResponseEntity.status(404).body("Post non trouvé");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        for (int i = 0; i < postsList.size(); i++) {
            if(postsList.get(i).getId() == id) {
                postsList.remove(i);
                return ResponseEntity.status(404).body("Post supprimé");
            }
        }
        return ResponseEntity.status(404).body("Post non trouvé");
    }
}
