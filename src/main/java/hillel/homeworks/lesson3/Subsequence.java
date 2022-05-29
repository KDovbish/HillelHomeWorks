package hillel.homeworks.lesson3;

public class Subsequence {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 6. Вывести 10 первых чисел последовательности 0, -5,-10,-15..");
        int n = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print( n + " ");
            n -= 5;
        }

    }
}
