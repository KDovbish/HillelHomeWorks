package hillel.homeworks.lesson5;

import java.util.Arrays;

public class StudentList {

    private static final int LIST_LENGTH_MAX = 10;

    private Student[] StudentList = new Student[LIST_LENGTH_MAX];
    private int index = 0;


    StudentList() {}

    StudentList(Student[] list) {
        for (Student student: list) {
            add(student);
        }
    }


    /**
     * Получить список студентов
     * @return Ссылка на массив типа Student
     */
    public Student[] getStudentList() {
        return StudentList;
    }

    /**
     * Получить количество студентов в списке
     * @return Количество студентов в списке
     */
    public int getListLength() {
        return index+1;
    }


    /**
     * Добавить студента в список
     * @param student Ссылка на объект типа Student
     */
    public void add(Student student) {
        if (index <= LIST_LENGTH_MAX - 1) {
            StudentList[index] =  student;
            index++ ;
        }
    }

    /**
     * Добавить студента в список
     * @param lastName Фамилия
     * @param firstName Имя
     * @param middleName Отчетство
     * @param birthYear Год рождения
     * @param address Адрес
     * @param telephone Телефон
     */
    public void add(String lastName, String firstName, String middleName,
                int birthYear, String address, String telephone) {
            if (index <= LIST_LENGTH_MAX - 1) {
                StudentList[index] =  new Student(lastName, firstName, middleName, birthYear, address, telephone);
            }
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "StudentList=" + Arrays.toString(StudentList) +
                '}';
    }
}
