package hillel.homeworks.lesson8;

public class DataGenerator2 {
    public static SeqCollection getCollection() {
        SeqCollection coll = new SeqCollection();

        coll.add("0");
        coll.add("1");
        coll.add("2");
        coll.add("3");
        coll.add(null);
        coll.add("5");

        return coll;
    }
}
