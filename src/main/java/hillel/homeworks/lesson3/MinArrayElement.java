package hillel.homeworks.lesson3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class MinArrayElement {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 9. Дан массив размерности N, найти наименьший элемент массива и вывести на консоль (массив заполнить случайными числами из диапазона 0 .. 100)");

        int arrLength = new Scanner(System.in).nextInt();
        if (arrLength > 0) {
            int[] arr = initArray(arrLength);
            System.out.println("Исходный массив: \n" + Arrays.toString(arr));
            System.out.println("Минимальное значение в массиве: " + getMinElement(arr));
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
     * Получить значение минимального элемента массива
     * @param arr Аналазируемый массив
     * @return Значение минимального элемента
     */
    static int getMinElement(int[] arr) {
        int minEl=arr[0];
        for (int i = 1; i <= arr.length-1; i++) {
            if (arr[i] < minEl) {
                minEl = arr[i];
            }
        }
        return minEl;
    }

}
