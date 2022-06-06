package hillel.homeworks.lesson5;

public class StudentListService {

    //  Виды возможных запросов к массиву объектов, описывающего список студентов
    static enum queryPattern {FACULTY, FACULTY_CLASSNUMBER, AFTER_BIRTHYEAR, GROUP}

    /**
     * В качестве запроса к списку студентов передается строковая переменная
     * @param studentList Список студентов
     * @param qp Тип запроса, который нужно сделать к массиву
     * @param s Ключ запроса
     */
    static void query(StudentList studentList, queryPattern qp, String s) {
        Student student;
        switch (qp) {
            case FACULTY:
                System.out.println("\nФакультет: " + s);
                for (int i = 0; i <= studentList.getListLength() - 1; i++) {
                    if ((student = studentList.get(i)) != null) {
                        if (student.getFaculty().equals(s)) {
                            System.out.println(student);
                        }
                    }
                }
                break;
            case GROUP:
                System.out.println("\nГруппа: " + s);
                for (int i = 0; i <= studentList.getListLength() - 1; i++) {
                    if ((student = studentList.get(i)) != null) {
                        if (student.getGroup().equals(s)) {
                            System.out.println(student);
                        }
                    }
                }
                break;
        }
    }

    /**
     * В качестве запроса к списку студентов передается строковая переменная и целое значение
     * @param studentList Список студентов
     * @param qp Тип запроса, который нужно сделать к массиву
     * @param s Ключ запроса 1(строковый)
     * @param n Ключ запроса 2(целочисленное)
     */
    static void query(StudentList studentList, queryPattern qp, String s, int n) {
        Student student;
        switch (qp) {
            case FACULTY_CLASSNUMBER:
                System.out.println("\nФакультет: " + s + "  Курс: " + n);
                for (int i = 0; i <= studentList.getListLength() - 1 ; i++) {
                    if ((student = studentList.get(i)) != null) {
                        if (student.getFaculty().equals(s) && student.getClassNumber() == n) {
                            System.out.println(student);
                        }
                    }
                }
                break;
        }
    }

    /**
     * В качестве запроса к списку студентов передается целое значение
     * @param studentList Список студентов
     * @param qp Тип запроса, который нужно сделать к массиву
     * @param n Ключ запроса
     */
    static void query(StudentList studentList, queryPattern qp, int n) {
        Student student;
        switch (qp) {
            case AFTER_BIRTHYEAR:
                System.out.println("\nГод рождения(запрос Больше): " + n);
                for (int i = 0; i <= studentList.getListLength() - 1; i++) {
                    if ((student = studentList.get(i)) != null) {
                        if (student.getBirthYear() > n ) {
                            System.out.println(student);
                        }
                    }
                }
                break;
        }
    }

}
