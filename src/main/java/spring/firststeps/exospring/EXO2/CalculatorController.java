package spring.firststeps.exospring.EXO2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public String addition(@RequestParam(required = false) int a, int b) {
        return "Résultat : " + (a+b);
    }

    @GetMapping("/multiply/{a}/{b}")
    public String multiply(@PathVariable int a, @PathVariable int b) {
        return "Résultat : " + (a*b);
    }

}
