package hillel.homeworks.lesson10;

import java.util.Collection;
import java.util.HashSet;

public class CollectionService {
    /**
     * Удаление дубликатов в любых коллекциях, реализованных на базе интерфейса Collection(java.util)
     * @param coll Коллекция
     * @return Коллекция без дубликатов
     */
    static Collection removeDuplicate(Collection coll) {
        return (new HashSet<>(coll));
    }
}
