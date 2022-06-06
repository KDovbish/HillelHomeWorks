package hillel.homeworks.lesson5;

public class Main {
    public static void main(String[] args) {

        StudentList studentList = new StudentList(5);

        studentList.add("Иванов", "Иван");
        studentList.add("Петров", "Петр", "Петрович", 1971, "г.Киев, ул.Хрещатик, 22", "050-111-11-11");
        studentList.add("Сидоров", "Сидор", "Сидорович", 1980, "г.Одесса, ул.Дерибасовская, 31", "050-222-22-22", "Психология", 1, "ПС-1А");
        studentList.add("Уваров", "Увар", "Уварович", 2000, "г.Донецк, ул.Челюскинцев, 116", "050-333-33-33");
        studentList.add("Семенов", "Семен", "Семенович");
        studentList.add("Николаев", "Николай", "Николаевич", 1956, "г.Харьков, ул.Космонавтов, 36", "050-444-44-44");
        studentList.add("Константинов", "Константин", "Константинович", 1987, "г.Авдеевка, ул.Заводская, 33", "050-555-55-55", "ВТ", 1, "ВТ-2000Б");
        studentList.add("Олегов", "Олег", "", 0, "", "", "Психология", 1, "");
        studentList.add("Игорев", "Игорь", "Игоревич", 1995, "г.Луганск, ул.Береговая, 12", "050-555-55-55", "ВТ", 1, "ВТ-2000Б");
        studentList.add("Сулейманов", "Сулейман", "Сулейманович", 1988, "г.Суммы, ул.Сумная, 1", "050-666-66-66", "Психология", 1, "ПС-1А");

        //studentList.print();

        StudentListService.query(studentList, StudentListService.queryPattern.FACULTY, "Психология");
        StudentListService.query(studentList, StudentListService.queryPattern.GROUP, "ВТ-2000Б");
        StudentListService.query(studentList, StudentListService.queryPattern.FACULTY_CLASSNUMBER, "ВТ", 1);
        StudentListService.query(studentList, StudentListService.queryPattern.AFTER_BIRTHYEAR, 1987);

    }
}
