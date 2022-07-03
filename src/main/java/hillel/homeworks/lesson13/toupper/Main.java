package hillel.homeworks.lesson13.toupper;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> coll =  DataGenerator.getArrayList();
        System.out.println(coll);
        System.out.println( new Service().getPairCollection(coll).getClass() ) ;
    }
}
