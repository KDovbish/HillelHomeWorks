package hillel.homeworks.lesson3;

import java.util.Scanner;

public class Extent {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 5. Даны переменные x и n вычислить x^n");

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        long extentRes=x;
        for (int i = 2; i <= n; i++) {
            extentRes = extentRes * x;
        }
        System.out.println(x + " в степени " + n + ": " + extentRes);
    }
}
