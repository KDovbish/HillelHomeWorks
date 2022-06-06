package hillel.homeworks.lesson5;

import java.util.Arrays;

/**
 * Класс для создания списка студентов(экземпляров класса Student)
 * Конструктор по умолчанию создает список из 10 элементов
 * Конструктор с целочисленным параметром задает размер списка
 */
public class StudentList {

    private int genId = 0;              //  Генерация уникального поля id для каждого элемента списка
    private Student[] studentList;      //  Список студентов
    private int studentListIndex = -1;  //  Индекс массива студентов, используемый для добавления в массив очередного элемента


    StudentList() {
        studentList = new Student[10];
    }

    StudentList(int listLength) {
        studentList = new Student[listLength];
    }


    /**
     * Получить количество студентов в списке
     * @return Количество студентов в списке
     */
    public int getListLength() {
        return studentList.length;
    }

    /**
     * Генерация уникального id для документа в списке
     * Сейчас для генерации уникального значения, используется увеличение статической переменной при
     * создании нового экземпляра класса Student. Но, вполне возможно, переделать данный метод для генерации
     * уникального значения каким-либо другим способом.
     * @return уникальный id
     */
    private int generateId() {
        return ++genId;
    }

    /**
     * Добавление студента в список
     * @param lastName Фамилия
     * @param firstName Имя
     * @return Ссылка на созданный в списке объект типа Student либо null
     */
    public Student add(String lastName, String firstName) {
        if (studentListIndex + 1 <= getListLength() - 1) {
            studentList[++studentListIndex] =  new Student(generateId(), lastName, firstName);
            return studentList[studentListIndex];
        } else {
            return null;
        }
    }

    /**
     * Добавление студента в список
     * @param lastName Фамилия
     * @param firstName Имя
     * @param middleName Отчество
     * @return Ссылка на созданный в списке объект типа Student либо null
     */
    public Student add(String lastName, String firstName, String middleName) {
        if (studentListIndex + 1 <= getListLength() - 1) {
            studentList[++studentListIndex] =  new Student(generateId(), lastName, firstName, middleName);
            return studentList[studentListIndex];
        } else {
            return null;
        }
    }

    /**
     * Добавление студента в список
     * @param lastName Фамилия
     * @param firstName Имя
     * @param middleName Отчество
     * @param birthYear Год рождения
     * @param address Адрес
     * @param telephone Телефон
     * @return Ссылка на созданный в списке объект типа Student либо null
     */
    public Student add(String lastName, String firstName, String middleName,
                        int birthYear, String address, String telephone) {
        if (add(lastName, firstName, middleName) != null) {
            studentList[studentListIndex].setBirthYear(birthYear);
            studentList[studentListIndex].setAddress(address);
            studentList[studentListIndex].setTelephone(telephone);
            return studentList[studentListIndex];
        } else {
            return null;
        }
    }

    /**
     * Добавление студента в список
     * @param lastName Фамилия
     * @param firstName Имя
     * @param middleName Отчество
     * @param birthYear Год рождения
     * @param address Адрес
     * @param telephone Телефон
     * @param faculty Факультет
     * @param classNumber Номер курса
     * @param group Группа
     * @return Ссылка на созданный в списке объект типа Student либо null
     */
    public Student add(String lastName, String firstName, String middleName,
                       int birthYear, String address, String telephone,
                       String faculty, int classNumber, String group) {

        if (add(lastName, firstName, middleName, birthYear, address, telephone) != null) {
            studentList[studentListIndex].setFaculty(faculty);
            studentList[studentListIndex].setClassNumber(classNumber);
            studentList[studentListIndex].setGroup(group);
            return studentList[studentListIndex];
        } else {
            return null;
        }
    }

    /**
     * Получить запись в списке с заданным индексом
     * @param index Номер индекса
     * @return Ссылка на объет типа Student
     */
    public Student get(int index) {
        return studentList[index];
    }


    /**
     * Вывести на консоль весь список
     */
    public void print() {
        for (Student stud: studentList) {
            System.out.println(stud);
        }
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "studentList=" + Arrays.toString(studentList) +
                '}';
    }
}
