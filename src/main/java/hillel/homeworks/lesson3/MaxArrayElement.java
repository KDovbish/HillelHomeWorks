package hillel.homeworks.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MaxArrayElement {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 10. Дан массив размерности N, найти наибольший элемент массива и вывести на консоль (массив заполнить случайными числами из диапазона 0 .. 100)");

        int arrLength = new Scanner(System.in).nextInt();
        if (arrLength > 0) {
            int[] arr = initArray(arrLength);
            System.out.println("Исходный массив: \n" + Arrays.toString(arr));
            System.out.println("Максимальное значение в массиве: " + getMaxElement(arr));
        }
    }

    /**
     * Создать массив заданной длины и инициализировать его случайными значениями в диапазане от 0 до 100
     * @param arrLength Длина требуемого массива
     * @return Инициализированный массив
     */
    static int[] initArray(int arrLength) {
        int[] tempArr =  new int[arrLength];
        Random randGenerator = new Random();
        for (int i = 0; i <= tempArr.length-1; i++) {
            tempArr[i] = randGenerator.nextInt(101);
        }
        return tempArr;
    }


    /**
     * Получить значение максимального элемента массива
     * @param arr Аналазируемый массив
     * @return Значение минимального элемента
     */
    static int getMaxElement(int[] arr) {
        int maxEl=arr[0];
        for (int i = 1; i <= arr.length-1; i++) {
            if (arr[i] > maxEl) {
                maxEl = arr[i];
            }
        }
        return maxEl;
    }
}
