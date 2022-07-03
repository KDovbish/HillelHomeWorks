package hillel.homeworks.lesson13.intcollection;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> coll = DataGenerator.getArrayList();
        System.out.println(coll);
        System.out.println("Среднее значение всех элементов: " + (new Service().calcIntCollAverage(coll)) );
    }

}
