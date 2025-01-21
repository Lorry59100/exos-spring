package spring.firststeps.exospring.EXO8;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.firststeps.exospring.EXO8.Class.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductListController {

    private List<Product> productList = new ArrayList<>();
    private int id = 0;

    @PostMapping("")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        id++;
        product.setId(id);
        productList.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produit ajouté avec l'ID : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        for (int i = 0; i < productList.size() ; i++) {
            if(productList.get(i).getId() == id) {
                if (product.getName() == null) {
                    product.setName(productList.get(i).getName());
                }
                if (product.getPrice() == -1) {
                    product.setPrice(productList.get(i).getPrice());
                }
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                return ResponseEntity.ok().body("Produit mis à jour : " + productList.get(i).getId() + " " + productList.get(i).getName() + " " + productList.get(i).getPrice());
            }
        }
        return ResponseEntity.status(404).body("Produit non trouvé");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        for (int i = 0; i < productList.size() ; i++) {
            if(productList.get(i).getId() == id) {
                productList.remove(i);
                return ResponseEntity.ok().body("Produit supprimé");
            }
        }
        return ResponseEntity.status(404).body("Produit non trouvé");
    }
}
