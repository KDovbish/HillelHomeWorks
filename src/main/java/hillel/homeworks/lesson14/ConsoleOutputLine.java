package hillel.homeworks.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс, реализующий методы для вывода на консоль строки символов в псевдографике
 */
public class ConsoleOutputLine {

    private List<String[]> matrixList;


    /**
     * Конструктор
     * @param symbolList массив строк
     */
    ConsoleOutputLine(List<String> symbolList) {
        matrixList = symbolList.stream()
                .map(e -> e.charAt(0))
                .map(e -> SymbolTable.getSymbolMatrix(e))
                .toList();
    }

    ConsoleOutputLine(String[] a) {
        if (verify(a)) {


        }
    }


    /**
     * Проверка массива строк на наличие только строковых представлений цифр
     * @param a массив строк
     * @return массив строк содержит только строковые представления цифр
     */
    boolean verify(String[] a) {
        try{
            for (String s: a) {
                if (s.length() == 1) Integer.parseInt(s)
                        else return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
