package hillel.homeworks.lesson3;

public class PrintOddArray {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 8. Создайте массив, содержащий 10 первых нечетных чисел. Выведете элементы массива на консоль в одну строку, разделяя запятой.");
        int[] a = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        for (int i = 0; i <= a.length-1; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
