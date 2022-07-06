package hillel.homeworks.lesson14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //  Создается объект, отображающий(мэпинг) массив строковых цифр в матрицы соответствующих псевдографических символов
        PsevdoGrString line = new PsevdoGrString();
        //  Проверяется допустимость строк с цифрами, передаваемая в объект
        if (line.verifyInput(args)) {

            //  Строки с цифрами передаются в объект
            line.add(args);

            //  Из каждой матрицы берется очередная строка и выводиться на консоль
            for (int row = 0; row <= SymbolTable.SYMBOL_HEIGHT - 1; row++) {
                line.getMatrixLineList(row).stream().forEach(System.out::print);
                System.out.println();
            }

        } else {
            System.out.println("Ошибка в параметрах модуля!");
        }

    }
}
