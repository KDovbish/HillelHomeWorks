package hillel.homeworks.lesson14;

import java.util.HashMap;

/**
 * Класс, описывающий матрицы для отображаения символов на экран.
 * В классе, на базе хэш-таблицы, реализована связка "ascii-код" - "матрица символа"
 */
class SymbolTable {
    private static final String[][] matrix = {
                                        {"@@@@@",
                                         "@   @",
                                         "@   @",
                                         "@   @",
                                         "@@@@@"},
                                        {"  @  ",
                                         " @@  ",
                                         "@ @  ",
                                         "  @  ",
                                         "@@@@@"},
                                        {"  @ @",
                                         "@   @",
                                         "   @ ",
                                         " @   ",
                                         "@@@@@"},
                                        {"     ",
                                         "     ",
                                         "     ",
                                         "     ",
                                         "     "},
    };

    private static HashMap<Character, String[]> table =  new HashMap();

    static {
        table.put('0', matrix[0]);
        table.put('1', matrix[1]);
        table.put('2', matrix[2]);

        table.put(' ', matrix[3]);
    }

    /**
     * Получить ссылку на матрицу символа
     * @param code код символа
     * @return массив стрингов; каждый стринг - одна строка матрицы.
     */
    public static String[] getSymbolMatrix(Character code) {
        return table.get(code);
    }
}
