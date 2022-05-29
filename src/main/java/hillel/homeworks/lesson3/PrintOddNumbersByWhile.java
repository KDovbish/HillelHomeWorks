package hillel.homeworks.lesson3;

public class PrintOddNumbersByWhile {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 3(while). При помощи цикла while вывести на экран нечетные числа от 1 до 99.");
        int n = 1;
        while (n <= 99) {
            System.out.print(n + " ");
            n += 2;
        }
    }
}
