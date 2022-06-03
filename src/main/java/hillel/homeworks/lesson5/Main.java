/*
 *  Версия 1
 */
package hillel.homeworks.lesson5;

public class Main {

    //  Виды возможных запросов к массиву объектов, описывающего список студентов
    private enum queryPattern {FACULTY, FACULTY_CLASSNUMBER, AFTER_BIRTHYEAR, GROUP}

    public static void main(String[] args) {

        Student[] student =  new Student[10];

        student[0] = new Student("Иванов", "Иван");
        student[1] = new Student("Петров", "Петр", "Петрович", 1971, "г.Киев, ул.Хрещатик, 22", "050-111-11-11");
        student[2] = new Student("Сидоров", "Сидор", "Сидорович", 1980, "г.Одесса, ул.Дерибасовская, 31", "050-222-22-22", "Психология", 1, "ПС-1А");

        student[3] = new Student("Уваров", "Увар", "Уварович", 1971, "г.Донецк, ул.Челюскинцев, 116", "050-333-33-33");
        student[3].setBirthYear(2000);

        student[4] = new Student("Семенов", "Семен");
        student[4].setMiddleName("Семенович");

        student[5] = new Student("Николаев", "Николай", "Николаевич", 1956, "г.Харьков, ул.Космонавтов, 36", "050-444-44-44");

        student[6] = new Student("Константинов", "Константин", "Константинович", 1987, "г.Авдеевка, ул.Заводская, 33", "050-555-55-55");
        student[6].setFaculty("ВТ");
        student[6].setClassNumber(1);
        student[6].setGroup("ВТ-2000Б");

        student[7] = new Student("Олегов", "Олег");
        student[7].setFaculty("Психология");
        student[7].setClassNumber(1);

        student[8] = new Student("Игорев", "Игорь", "Игоревич", 1995, "г.Луганск, ул.Береговая, 12", "050-555-55-55");
        student[8].setFaculty("ВТ");
        student[8].setClassNumber(1);
        student[8].setGroup("ВТ-2000Б");

        student[9] = new Student("Сулейманов", "Сулейман", "Сулейманович", 1988, "г.Суммы, ул.Сумная, 1", "050-666-66-66", "Психология", 1, "ПС-1А");

        query(student, queryPattern.FACULTY, "Психология");
        query(student, queryPattern.GROUP, "ВТ-2000Б");
        query(student, queryPattern.FACULTY_CLASSNUMBER , "ВТ", 1);
        query(student, queryPattern.AFTER_BIRTHYEAR , 1987);
    }

    /**
     * В качестве запроса к массиву объектов типа Student передается строковая переменная
     * @param studentList Массив студентов
     * @param qp Тип запроса, который нужно сделать к массиву
     * @param s Ключ запроса
     */
    static void query(Student[] studentList, queryPattern qp, String s) {
        switch (qp) {
            case FACULTY:
                System.out.println("\nФакультет: " + s);
                for (Student student: studentList) {
                    if (student.getFaculty().equals(s)) {
                        System.out.println(student);
                    }
                }
                break;
            case GROUP:
                System.out.println("\nГруппа: " + s);
                for (Student student: studentList) {
                    if (student.getGroup().equals(s)) {
                        System.out.println(student);
                    }
                }
                break;
        }
    }


    /**
     * В качестве запроса к массиву объектов типа Student передается строковая переменная и целое значение
     * @param studentList Массив студентов
     * @param qp Тип запроса, который нужно сделать к массиву
     * @param s Ключ запроса 1(строковый)
     * @param n Ключ запроса 2(целочисленное)
     */
    static void query(Student[] studentList, queryPattern qp, String s, int n) {
        switch (qp) {
            case FACULTY_CLASSNUMBER:
                System.out.println("\nФакультет: " + s + "  Курс: " + n);
                for (Student student: studentList) {
                    if (student.getFaculty().equals(s) && student.getClassNumber() == n) {
                        System.out.println(student);
                    }
                }
                break;
        }
    }

    /**
     * В качестве запроса к массиву объектов типа Student передается целое значение
     * @param studentList Массив студентов
     * @param qp Тип запроса, который нужно сделать к массиву
     * @param n Ключ запроса
     */
    static void query(Student[] studentList, queryPattern qp, int n) {
        switch (qp) {
            case AFTER_BIRTHYEAR:
                System.out.println("\nГод рождения(запрос Больше): " + n);
                for (Student student: studentList) {
                    if (student.getBirthYear() > n ) {
                        System.out.println(student);
                    }
                }
                break;
        }
    }

}
