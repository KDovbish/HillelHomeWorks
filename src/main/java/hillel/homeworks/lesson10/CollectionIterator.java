package hillel.homeworks.lesson10;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Итератор по коллекциям реализаующих интерефес CollectionWithIterator
 * Дефолтный метод forEachRemaining() не переопределялся, из-за того что его дефолтная реализация
 * вполне подходит для данного итератора
 */
class CollectionIterator implements Iterator<String> {

    //  Ссылка на коллекцию, с которой будет работать итератор
    private CollectionWithIterator coll;
    //  Индекс элемента, который должен возвратить итертатор при очередном вызове next()
    private int index = 0;
    //  Флаг, сигнализирующий для метода remove(), вызывался или нет уже метод next()
    private boolean isNextMethodCall = false;

    CollectionIterator(CollectionWithIterator coll) {
        this.coll = coll;
    }

    @Override
    public boolean hasNext() {
        return (index < coll.size());
    }

    @Override
    public String next() {
        String data = coll.get(index++);
        isNextMethodCall = true;
        return data;
    }

    @Override
    public void remove() {
        //  Удаляем элемент только в том случае, если метод next() уже вызывался.
        //  Если метод next() не вызывался после последнего вызова remove() или не вызывался вообще, то ничего не делеам
        if (isNextMethodCall) {
            //  Удаляем последний элемент возвращенный итератором(методом next())
            coll.delete(index - 1);
            isNextMethodCall = false;
        }
    }
}
