package spring.firststeps.exospring.EXO10.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Posts {
    private int id;
    private String title;
    private String content;
}
