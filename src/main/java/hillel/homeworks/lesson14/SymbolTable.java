package hillel.homeworks.lesson14;

import java.util.HashMap;

/**
 * Класс, описывающий матрицы для отображаения символов из псевдографики.
 * В классе, на базе хэш-таблицы, реализована связка "ascii-код" - "матрица символа"
 */
class SymbolTable {
    static final int SYMBOL_HEIGHT = 5;
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

                   {"@@@  ",
                    "    @",
                    "  @@ ",
                    "    @",
                    "@@@@ "},

                   {"  @ @",
                    " @  @",
                    "@@@@@",
                    "    @",
                    "    @"},

                   {"@@@@@",
                    "@    ",
                    "@@@@@",
                    "    @",
                    "@@@@@"},

                   {"@@@@@",
                    "@    ",
                    "@@@@@",
                    "@   @",
                    "@@@@@"},

                   {"@@@@@",
                    "    @",
                    "   @ ",
                    "  @  ",
                    " @   "},

                   {" @@@ ",
                    "@   @",
                    " @@@ ",
                    "@   @",
                    " @@@ "},

                   {"@@@@@",
                    "@   @",
                    "@@@@@",
                    "    @",
                    "@@@@@"},

                   {"     ",
                    "     ",
                    "     ",
                    "     ",
                    "     "}
    };

    private static HashMap<Character, String[]> table =  new HashMap();

    static {
        table.put('0', matrix[0]);
        table.put('1', matrix[1]);
        table.put('2', matrix[2]);
        table.put('3', matrix[3]);
        table.put('4', matrix[4]);
        table.put('5', matrix[5]);
        table.put('6', matrix[6]);
        table.put('7', matrix[7]);
        table.put('8', matrix[8]);
        table.put('9', matrix[9]);
        table.put(' ', matrix[10]);
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
