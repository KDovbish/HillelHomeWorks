package hillel.homeworks.lesson14;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс, реализующий методы для отображения(мэпинга) массива строковых цифр в список матриц символов в псевдографике
 */
@NoArgsConstructor
@Getter
public class PsevdoGrString {

    //  Список ссылок на матрицы символов(массивы строк)
    //  Заполняется методом add(), после прохождения проверки verifyInput()
    private List<String[]> matrixList;

    /**
     * Проверка массива строк на наличие только строковых представлений цифр
     * @param a Массив строк
     * @return Проверка пройдена/не пройдена
     */
    boolean verifyInput(String[] a) {
        if (a.length == 0 ) return false;
        if (Arrays.stream(a).anyMatch(e -> e.length() != 1)) return false;
        try{
            for (String e: a) Integer.parseInt(e);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    /**
     * Добавить в объект строки с цифрами, которые необходимо преобразовать в псевдографическую строку
     * @param a Массив строк с цифрами
     */
    void add(String[] a) {
        //  Разбавляем цифры проблеми
        List<String> symbolList = new ArrayList<>();
        for (int i = 0; i <= a.length - 2; i ++) {
            symbolList.add(a[i]);
            symbolList.add(" ");
        }
        symbolList.add(a[a.length - 1]);

        //  Получаем список с матрицами символов
        matrixList = symbolList.stream()
                .map(e -> e.charAt(0))
                .map(e -> SymbolTable.getSymbolMatrix(e))
                .toList();
    }


    /**
     * Есть несколько матриц символов в списке. Каждая матрица - набор строк.
     * Метод отдает из всех матриц, строки с заданным индексом.
     * @param index Номер строки
     * @return Список строк
     */
    List<String> getMatrixLineList(int index) {
        return matrixList.stream()
                .map(e -> e[index])
                .toList();
    }

}
