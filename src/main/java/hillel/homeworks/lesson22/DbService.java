package hillel.homeworks.lesson22;

import java.sql.*;

public class DbService {

    private String jdbcURL;
    private String user;
    private String password;

    private Connection conn;


    DbService(String jdbcURL, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {}

        this.jdbcURL = jdbcURL;
        this.user = user;
        this.password = password;
    }

    /**
     * Открыть соединение к базе
     */
    void open() {
        try {
            if (conn == null || (conn != null && conn.isClosed())) {
                conn = DriverManager.getConnection(jdbcURL, user, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Закрыть соединение к базе
     */
    void close() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получить текущий статус соединения, инициируемого методом open()
     * @return true(отктыто)/false(закрыто)
     */
    boolean isOpen() {
        try {
            return (conn != null && conn.isClosed() == false);
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Выборка данных
     * @param query Запрос SELECT
     * @return Набор данных(ResultSet) или null
     * Метод работает только через соединение, которое открывается объектом DbService с помощью метода open(). Это связано с тем,
     * что клиенту необходимо анализировать возвращаемый методом объект ResultSet. А для этого, объект ResultSet не должен быть закрыт, что возможно только
     * при открытом соединении.
     * Если соединение не открыто методом open() перед выполнением метода select(), то метод select() вернет null.
     * Клиент должен либо убедиться что подобное соединение откыто - метод isOpen(), либо явно открыть его - метод open() - перед
     * выполнением метода select().
     */
    ResultSet select(String query) {
        try {
            if (conn != null) return conn.createStatement().executeQuery(query);
                else return null;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Произвести добавление новой записи в таблицу и отдать значение первичного ключа новой записи
     * @param query запрос INSERT
     * @return значение первичного ключа
     * При отсутствии соединения через метод open(), создается(и закрывается тут же в методе) временное соединение для выполнения запроса к базе.
     */
    Integer insert(String query) throws SQLException {
            //  Открываем новое соединение к базе, если еще такового еще не было создано методам open()
            Connection localConn;
            boolean needCloseConnection;
            if (isOpen()) {
                localConn = conn;
                needCloseConnection = false;
            } else {
                localConn = DriverManager.getConnection(jdbcURL, user, password);
                needCloseConnection = true;
            }

            //  Выполняем добавление записи
            Statement statement = localConn.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            //  Получаем значение первичного ключа для новой записи
            ResultSet rs = statement.getGeneratedKeys();
            rs.first();
            Integer pkValue = rs.getInt(1);

            //  Принудительно закрываем уже ненужные ресурсы
            rs.close();
            statement.close();
            if (needCloseConnection) localConn.close();

            //  Возврат значения первичного ключа для добавленной записи
            return pkValue;
    }

    /**
     * Удалить запись из таблицы
     * @param query Запрос DELETE
     * @return true/false успешно или нет удаление
     * При отсутствии соединения через метод open(), создается(и закрывается тут же в методе) временное соединение для выполнения запроса к базе.
     */
    boolean delete(String query) {
        try {
            //  Открываем новое соединение к базе, если еще такового еще не было создано методам open()
            Connection localConn;
            boolean needCloseConnection;
            if (isOpen()) {
                localConn = conn;
                needCloseConnection = false;
            } else {
                localConn = DriverManager.getConnection(jdbcURL, user, password);
                needCloseConnection = true;
            }

            Statement statement = localConn.createStatement();
            //  Выполняем удаление записи
            statement.executeUpdate(query);

            //  Принудительно закрываем уже ненужные ресурсы
            statement.close();
            if (needCloseConnection) localConn.close();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
