package hillel.homeworks.lesson22;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @Test
    void add_and_delete(){
        DbService dbService = new DbService("jdbc:mysql://localhost:3306/hw22", "dbadmin", "dbadmin");
        StudentService studentService = new StudentServiceImpl(dbService);
        Student student = studentService.add(new Student(null, "Тестов Т.Т.", 1, 2022));
        System.out.println(student);
        assertNotNull(student.getId());
        assertTrue(studentService.delete(student));
    }

    @Test
    void getAll() throws SQLException{
        DbService dbService = new DbService("jdbc:mysql://localhost:3306/hw22", "dbadmin", "dbadmin");

        //  Получаем количество записей в таблице
        dbService.open();
        ResultSet rs = dbService.select("SELECT COUNT(*) FROM STUDENT");
        rs.next();
        Integer allTableRow = rs.getInt(1);
        dbService.close();

        //  Тестируем метод по запросу всех студентов
        StudentService studentService = new StudentServiceImpl(dbService);
        List<Student> studentList =  studentService.getAll();
        System.out.println(studentList);
        assertEquals(allTableRow, studentList.size());
    }

    @Test
    void getByName() {
        DbService dbService = new DbService("jdbc:mysql://localhost:3306/hw22", "dbadmin", "dbadmin");
        StudentService studentService = new StudentServiceImpl(dbService);

        //  Создаем студента с теоретически невозможным именем
        Student student = studentService.add(new Student(null, "ТестовТестовТестов", 1, 2022));

        //  Проверяем работу метода getByName() для имени только что созданного студента
        List<Student> studentList =  studentService.getByName("ТестовТестовТестов");
        System.out.println(studentList);
        assertNotEquals(0, studentList.size());

        //  Удаляем временного созданного для теста студента
        studentService.delete(student);
    }

    @Test
    void getByIds() {
        DbService dbService = new DbService("jdbc:mysql://localhost:3306/hw22", "dbadmin", "dbadmin");
        StudentService studentService = new StudentServiceImpl(dbService);

        //  Создаем двух студентов
        Student student1 = studentService.add(new Student(null, "ТестовТестовТестов1", 1, 2022));
        Student student2 = studentService.add(new Student(null, "ТестовТестовТестов2", 1, 2022));

        //  Проверяем метод getByIds() для только что созданных двух студентов
        List<Student> studentList = studentService.getByIds(List.of(student1.getId(), student2.getId()));
        System.out.println(studentList);
        assertEquals(2, studentList.size());

        //  Удаляем созданных студентов
        studentService.delete(student1);
        studentService.delete(student2);
    }
}