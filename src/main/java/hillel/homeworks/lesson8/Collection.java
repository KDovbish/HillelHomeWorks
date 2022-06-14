package hillel.homeworks.lesson8;

public interface Collection {
    boolean add(String value);
    boolean add(int index, String value);
    boolean delete(String value);
    String get(int index);
    boolean contains(String value);
    boolean equals(Collection str);
    boolean clear();
    int size();
}
