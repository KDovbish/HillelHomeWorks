package hillel.homeworks.lesson3;

import java.util.Arrays;

public class MaxMinArrElementChange {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 11. Поменять наибольший и наименьший элементы массива местами");

        int[] arr = {101, -5, 0, 6, 8, -23, 100};

        int minIndex=getMinElementIndex(arr);
        int minValue=arr[minIndex];
        int maxIndex=getMaxElementIndex(arr);

        System.out.println("Исходный массив: \n" + Arrays.toString(arr));
        System.out.println("Индекс наибольшего элемента: " + maxIndex);
        System.out.println("Индекс наименьшего элемента: " + minIndex);

        arr[minIndex]=arr[maxIndex];
        arr[maxIndex]=minValue;

        System.out.println("Измененный массив: \n" + Arrays.toString(arr));
    }

    /**
     * Получить индекс минимального элемента массива
     * @param arr Входной массив
     * @return индекс минимального элемента
     */
    static int getMinElementIndex(int[] arr) {
        int minIndex=0;
        int minElement = arr[minIndex];
        for (int i = 1; i <= arr.length-1; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    /**
     * Получить индекс максимального элемента массивав
     * @param arr Входной массив
     * @return индекс максимального элемента
     */
    static int getMaxElementIndex(int[] arr) {
        int maxIndex=0;
        int maxElement=arr[maxIndex];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


}
