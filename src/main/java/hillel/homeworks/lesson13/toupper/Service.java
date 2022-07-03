package hillel.homeworks.lesson13.toupper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    List<Pair> getPairCollection(List<String> coll) {
        /*
        Вариант № 1
        В методе map() прохоисходит смена типа элемента потока.
        Соответственно, терминальный метод toList() возвращает список уже нового типа.
        Согласно документации, не дается никаких гарантий о том какая реализация списка будет использована,
        не дается никаких гарантий по изменяемости списке, сериализации и его потоконезависимости.
        Документация рекомендует к использованию метоод toCollection() класса Collectors.
         */
        //return coll.stream().map(e -> new Pair(e, e.toUpperCase())).toList();


        /*
        Вариант № 2
        На выходе имеем список.
        Однако, в отличии от первого варианта, в данном случае мы не имеем однозначно неизменяемого списка.
        Документация говорит об отсутствии гаранитий по типу реализации, изменяемости, сериализации и потоконезависимости
        для данного списка.
        Опять же рекомендуюется использование toCollection() класса Collectors.
         */
        //return coll.stream()
        //        .map(e -> new Pair(e, e.toUpperCase()))
        //        .collect(Collectors.toList());


        /*
        Вариант № 2
        Используется терминальный метод collect().
        На вход подается реализация интерфейса Collector через вызов метода toCollection().
        На вход метода toCollection() подается ссылка на метод без параметров, возвращающий пустую коллекцию заданного типа,
        которая будет наполняться реализацией интерфейса Collector.
         */
        return coll.stream()
                .map(e -> new Pair(e, e.toUpperCase()))
                .collect(Collectors.toCollection( ArrayList<Pair>::new ));
    }
}
