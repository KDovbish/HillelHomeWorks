package hillel.homeworks.lesson10;

import java.util.Iterator;
import hillel.homeworks.lesson8.Collection;

/**
 * Интерфейс, расширяющий интерефес Collection(из ДЗ8).
 * Добавлен метод получения итератора и удаления элемента по индексу.
 */
public interface CollectionWithIterator extends Collection {
    Iterator<String> iterator();
    void delete(int index);
}
