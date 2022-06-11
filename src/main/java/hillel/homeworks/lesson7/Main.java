package hillel.homeworks.lesson7;

public class Main {
    public static void main(String[] args) {

        SeqCollection coll = new SeqCollection(5);

        coll.add(1, "Оля");                                  // Изменение элемента на индексе 1
        coll.add(4, "Последний элемент исходной коллекции"); // Изменение элемента на индексе 4
        coll.add("Вася");   // 6-й элемент коллекции
        coll.add(null);     // 7-й элемент коллекции
        coll.add("Сеня");   // 8-й элемент коллекции
        coll.add("Коля");   // 9-й элемент коллекции

        System.out.println("Исходная коллекция + добавленные элементы:");
        for (int i = 0; i <= 9; i++) {
            System.out.println(i + ": " + coll.get(i));
        }

        coll.delete("Сеня");

        System.out.println("\nПосле удаления элемента на индексе 7:");
        for (int i = 0; i <= 9; i++) {
            System.out.println(i + ": " + coll.get(i));
        }

        //coll.debug();

    }
}

