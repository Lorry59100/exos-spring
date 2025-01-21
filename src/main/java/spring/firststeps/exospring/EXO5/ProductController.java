package spring.firststeps.exospring.EXO5;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class ProductController {

    HashMap<Integer, String> productList = new HashMap<Integer, String>();
    public ProductController() {
        productList.put(1, "Gamecube");
        productList.put(2, "Dreamcast");
        productList.put(3, "PS3");
        productList.put(4, "PS4");
    }


    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable int id) {
        return "Produit : " + productList.get(id);
    }

    @GetMapping("/add")
    public String addUser(@RequestParam String name) {
        productList.put(productList.size()+1,name);
        return name;
    }

    @GetMapping("/all")
    public HashMap<Integer, String> getProducts() {
        return productList;
    }
}
