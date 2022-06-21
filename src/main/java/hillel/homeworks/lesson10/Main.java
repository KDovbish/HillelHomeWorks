package hillel.homeworks.lesson10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //  *** УСТРАНЕНИЕ ДУБЛИКАТОВ В КОЛЛЕКЦИИ
        //  Используется ArrayList в качестве коллекции
        List<String> a = DataGeneratorArrayList.getArrayList();
        System.out.println(a);
        System.out.println(CollectionService.removeDuplicate(a));

        //  Используется LinkedList в качестве коллекции
        List<String> ll = DataGeneratorLinkedList.getLinkedList();
        System.out.println(ll);
        System.out.println(CollectionService.removeDuplicate(ll));

        System.out.println();

        //  *** ИТЕРАТОР
        SeqCollectionWithIterator coll = DataGeneratorSecCollection.getSeqCollection();
        Iterator<String> itr = coll.iterator();

        itr.next();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();

        itr = coll.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println();

        //  *** КОРНИ КВАДРАТНОГО УРАВНЕНИЯ
        QuadEquation qe =  new QuadEquation(5, 2, -3);
        ArrayList<Double> roots = qe.getRoots();
        System.out.println("Дискриминант: " + qe.getDiscriminant());
        if (roots.size() == 0) {
            System.out.println("Корни не найдены");
        } else {
            for (Double v: roots) {
                System.out.println(v);
            }
        }

    }
}
