package hillel.homeworks.lesson8;

public class Main {

    public static void main(String[] args) {

        SeqCollection coll1 = DataGenerator1.getCollection();
        SeqCollection coll2 = DataGenerator2.getCollection();

        System.out.println("Размер коллекции 1: " + coll1.size());
        System.out.println("Размер коллекции 2: " + coll2.size());
        System.out.println("Проверка на эквивалентность: " + coll2.equals(coll1));
        coll1.add("111");
        coll1.add("222");
        coll1.add("333");
        System.out.println("Размер коллекции 1: " + coll1.size());
        System.out.println("Размер коллекции 2: " + coll2.size());
        System.out.println("Проверка на эквивалентность: " + coll2.equals(coll1));

        for (int i = 0; i <= coll1.size() - 1; i++) {
            System.out.println(i + ": " + coll1.get(i));
        }
    }
}

