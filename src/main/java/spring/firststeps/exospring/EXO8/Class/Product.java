package spring.firststeps.exospring.EXO8.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private int id;
    private String name;
    private double price = -1;
}
