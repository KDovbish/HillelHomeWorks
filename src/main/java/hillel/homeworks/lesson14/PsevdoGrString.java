package hillel.homeworks.lesson14;

import java.util.Arrays;
import java.util.List;

/**
 * Класс, реализующий методы для вывода на консоль строки символов в псевдографике
 */
public class PsevdoGrString {

    private List<String[]> matrixList;


    /**
     * Конструктор
     * @param symbolList массив строк
     */
    PsevdoGrString(List<String> symbolList) {
        matrixList = symbolList.stream()
                .map(e -> e.charAt(0))
                .map(e -> SymbolTable.getSymbolMatrix(e))
                .toList();
    }

    PsevdoGrString(String[] a) {
        if (verify(a)) {


        }
    }


    /**
     * Проверка массива строк на наличие только строковых представлений цифр
     * @param a массив строк
     * @return массив строк содержит только строковые представления цифр
     */
    boolean verify(String[] a) {
        if (Arrays.stream(a).allMatch(e -> e.length() == 1)) {
            try{
                for (String e: a) Integer.parseInt(e);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Отдать список, содержащий строки заданного индекса по матрицам всех символов
     * которые требуется вывести на экран
     * @param index
     * @return
     */
    List<String> getMatrixLineList(int index) {
        return matrixList.stream()
                .map(e -> e[index])
                .toList();
    }

}
