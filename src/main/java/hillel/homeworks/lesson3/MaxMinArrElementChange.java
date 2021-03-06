package hillel.homeworks.lesson3;

import java.util.Arrays;

public class MaxMinArrElementChange {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 11. Поменять наибольший и наименьший элементы массива местами");

        int[] arr = {101, -5, 0, 6, 8, -23, 100};

        //  Определение индекса минимального и максимального элемента массива
        int minIndex = 0; int minElement = arr[minIndex];
        int maxIndex = 0; int maxElement=arr[maxIndex];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                minIndex = i;
            }
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                maxIndex = i;
            }
        }

        System.out.println("Исходный массив: \n" + Arrays.toString(arr));
        System.out.println("Индекс наибольшего элемента: " + maxIndex);
        System.out.println("Индекс наименьшего элемента: " + minIndex);

        //  Необходимо сохранить перед заменой во временной переменной либо минмальный либо максимальный элемент
        int minValue=arr[minIndex];
        //  Change
        arr[minIndex]=arr[maxIndex];
        arr[maxIndex]=minValue;

        System.out.println("Измененный массив: \n" + Arrays.toString(arr));
    }
}
