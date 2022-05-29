package hillel.homeworks.lesson3;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 7. Необходимо вывести на экран таблицу умножения на Х (х любое число в диапазоне 0 .. 10)");

        int y =  new Scanner(System.in).nextInt();
        for (int x = 0; x <= 10; x++) {
            System.out.println(y + " * " + x + " = " + (y * x));
        }
    }
}
