package hillel.homeworks.lesson9;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        LinkedList9 list1 = DataGenerator1.getList();
        LinkedList9 list2 = DataGenerator2.getList();

        list1.addAll(list2);
        list1.add("Последний");
        System.out.println("Результат удаления: " + list1.delete(2));
        System.out.println("Поиск, Index=3: " + list1.get(3));
        System.out.println("Размер коллекции: " + list1.size());
        for (int i = 0; i <= list1.size() - 1; i++) {
            System.out.println(i + ": " + list1.get(i));
        }
    }


}


