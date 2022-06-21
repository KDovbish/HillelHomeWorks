package hillel.homeworks.lesson10;

import java.util.Iterator;
import hillel.homeworks.lesson8.SeqCollection;

/**
 * Класс наследующий функционал класса последовательной коллекции(ДЗ8) и дополнительно реализующий интерфейс
 * последовательной коллекции с итератором
 */
public class SeqCollectionWithIterator extends SeqCollection implements CollectionWithIterator {

    public SeqCollectionWithIterator() {
        super();
    }
    public SeqCollectionWithIterator(int size) {
        super(size);
    }

    @Override
    public Iterator<String> iterator() {
        return new CollectionIterator(this);
    }

    @Override
    public void delete(int index) {
        deleteDataByIndex(index);
    }
}
