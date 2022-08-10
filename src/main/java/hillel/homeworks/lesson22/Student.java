package hillel.homeworks.lesson22;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private Integer id;
    private String fio;
    private int groupId;
    private int year;
}
