package hillel.homeworks.lesson1;

public class PrintOddNumbers {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 1. При помощи цикла for вывести на экран нечетные числа от 1 до 99.");
        for (int i=1; i<=99; i+=2) {
            System.out.print(i + " ");
        }
    }
}
