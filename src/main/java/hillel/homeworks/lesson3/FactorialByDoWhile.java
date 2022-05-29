package hillel.homeworks.lesson3;

import java.util.Scanner;

public class FactorialByDoWhile {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 4(do-while). Дано число n при помощи цикла do-while посчитать факториал n!");
        long n = new Scanner(System.in).nextLong();
        if (n >= 1) {
            long factorialRes = 1L;
            long i = 1L;
            do {
                factorialRes =  factorialRes * (i++);
            } while (i <= n);
            System.out.println("Факториал: " + factorialRes);
        }

    }
}
