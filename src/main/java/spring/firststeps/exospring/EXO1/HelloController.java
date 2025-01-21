package spring.firststeps.exospring.EXO1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        if(name != null) return "Bonjour " + name;
        return name;
    }
}
