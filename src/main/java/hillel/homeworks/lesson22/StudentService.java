package hillel.homeworks.lesson22;

import java.util.List;

public interface StudentService {

    Student add(Student entry);
    boolean delete(Student entry);
    List<Student> getAll();
    List<Student> getByName(String name);
    List<Student> getByIds(List<Integer> ids);

}
