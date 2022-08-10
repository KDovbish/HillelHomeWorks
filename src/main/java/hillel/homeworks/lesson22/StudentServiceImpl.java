package hillel.homeworks.lesson22;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService{

    private DbService dbService;

    StudentServiceImpl(DbService dbService){
        this.dbService = dbService;
    }


    /**
     * Получить содержимое таблицы Студентов
     * @return Список типа ArrayList с объектами типа Student
     */
    public List<Student> getAll() {
        try {
            List<Student> studentList = new ArrayList<>();

            //  Т.к. метод DbService.select() возвращает ResultSet, нельзя чтобы этот объект Resultset был закрыт,
            //  т.к. все его записи нужно еще отобразить в список List<Student>. А объект будет закрыт, как только будет
            //  закрыто соединение, его породившее. Вследствии этого, открываем и закрываем соединение здесь, на этом уровне, явно.

            //  Запоминаем текущий статус(открыто/закрыто) соединения в объекте DbService
            boolean connectionStatusSave = dbService.isOpen();
            dbService.open();
            ResultSet resultSet = dbService.select("SELECT * FROM student");
            while (resultSet.next()) {
                studentList.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }
            //  Закрываем соединение только в том случае, если оно было закрыто изначально
            if (connectionStatusSave == false) dbService.close();
            return studentList;
        } catch (SQLException e) {
            return null;
        }
    }


    /**
     * Получить список студентов по имени
     * @param name Подстрока ФИО по которой должна идти выборка
     * @return Список типа ArrayList с объектами типа Student
     */
    public List<Student> getByName(String name) {
        try {
            List<Student> studentList = new ArrayList<>();
            boolean connectionStatusSave = dbService.isOpen();
            dbService.open();
            ResultSet resultSet = dbService.select("SELECT * FROM student WHERE fio LIKE '%" + name + "%'");
            while (resultSet.next()) {
                studentList.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }
            if (connectionStatusSave == false) dbService.close();
            return studentList;
        } catch (SQLException e) {
            return null;
        }
    }


    /**
     * Получить список студентов по списку Id
     * @param ids Список Id
     * @return Список типа ArrayList с объектами типа Student
     */
    public List<Student> getByIds(List<Integer> ids) {

        try {
            List<Student> studentList = new ArrayList<>();
            boolean connectionStatusSave = dbService.isOpen();
            dbService.open();

            //  Собираем список идентификаторов студентов в строку для WHERE id IN ...
            String strListId = String.join(
                    ",",
                    ids.stream().map(e -> e.toString()).toList()
            );

            ResultSet resultSet = dbService.select("SELECT * FROM student WHERE id IN (" + strListId + ")");
            while (resultSet.next()) {
                studentList.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }

            if (connectionStatusSave == false) dbService.close();
            return studentList;
        } catch (SQLException e) {
            return null;
        }
    }


    /**
     * Добавление записи по новому студенту
     * @param entry Объект класса Student, описывающий студента
     * @return В случае успешного добавления в базу, возвращает исходный объект с заполненным уникальным идентификатором студента
     * В случае неудачи - null
     */
    @Override
    public Student add(Student entry) {
        try {
            String query = String.format("INSERT INTO student VALUES (null, '%s', %s, %s)",
                    entry.getFio(), entry.getGroupId(), entry.getYear());
            Integer id = dbService.insert(query);
            entry.setId(id);
            return entry;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Удаление записи в таблице Студентов
     * @param entry Объект типа Student
     * @return true/false успешно или нет удаление
     */
    @Override
    public boolean delete(Student entry) {
        String query = "delete from student where id = " + entry.getId();
        return dbService.delete(query);
    }
}
