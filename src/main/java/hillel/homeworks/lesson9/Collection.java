package hillel.homeworks.lesson9;

public interface Collection {
    boolean add(String str);
    boolean addAll(Collection strColl);
    boolean delete (int index);
    boolean delete (String str);
    String get(int index);
    boolean contains(String str);
    boolean clear();
    int size();
    boolean trim();
}
