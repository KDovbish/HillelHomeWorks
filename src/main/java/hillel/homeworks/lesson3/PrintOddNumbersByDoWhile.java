package hillel.homeworks.lesson3;

public class PrintOddNumbersByDoWhile {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 4(do-while). При помощи цикла do-while вывести на экран нечетные числа от 1 до 99.");
        int n = 1;
        do {
            System.out.print(n + " ");
            n += 2;
        } while (n<=99);
    }
}
