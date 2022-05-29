package hillel.homeworks.lesson3;

import java.util.Scanner;

public class FactorialByWhile {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 3(while). Дано число n при помощи цикла while посчитать факториал n!");
        long n = new Scanner(System.in).nextLong();
        if (n >= 1) {
            long factorialRes = 1L;
            long i = 2L;
            while (i <= n) {
                factorialRes =  factorialRes * (i++);
            }
            System.out.println("Факториал: " + factorialRes);
        }
    }
}
