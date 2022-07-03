package hillel.homeworks.lesson13.intcollection;

import java.util.List;

public class Service {
    Float calcIntCollAverage(List<Integer> coll) {
        return (float) coll.stream().reduce(0, Integer::sum)  / coll.size();
    }
}
