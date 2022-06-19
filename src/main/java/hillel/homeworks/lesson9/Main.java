package hillel.homeworks.lesson9;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        LinkedList9 list1 = DataGenerator1.getList();
        LinkedList9 list2 = DataGenerator2.getList();

        list1.addAll(list2);

        list1.clear();

        //System.out.println("Результат поиска: " + list1.contains("0 элемен2т"));

        //System.out.println("Результат удаления: " + list.delete("2 элемент"));

        //System.out.println("Результат удаления: " + list.delete(2));
        //System.out.println("Получить элемент по индексу: " + list.get(5));


        list1.debug();

    }


}


