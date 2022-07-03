package hillel.homeworks.lesson13.intcollection;

import java.util.List;

public class Service {
    /*
    Параметром функции должен быть именно интерфейс.
    Неважно, какую коллекцию мы передаем - ArrayList или LinkedList. Главное - это целочисленная коллекция
    Функция в любом случае должна посчитать среднее
     */
    Float calcIntCollAverage(List<Integer> coll) {
        return (float) coll.stream().reduce(0, Integer::sum)  / coll.size();
    }
}
