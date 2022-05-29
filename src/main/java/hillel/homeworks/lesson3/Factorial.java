package hillel.homeworks.lesson3;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        System.out.println("Урок 3. ДЗ 2. Дано число n при помощи цикла for посчитать факториал n!");

        int n = new Scanner(System.in).nextInt();
        if (n >= 1) {
            int factorialRes = 1;
            for (int i = 2; i <= n; i++) {
                factorialRes = factorialRes * i;
            }
            System.out.println("Факториал: " + factorialRes);
        }

    }
}
