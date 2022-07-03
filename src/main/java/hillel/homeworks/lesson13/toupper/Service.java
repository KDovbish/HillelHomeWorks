package hillel.homeworks.lesson13.toupper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    List<Pair> getPairCollection(List<String> coll) {
        return coll.stream()
                .map(e -> new Pair(e, e.toUpperCase()))
                .collect(Collectors.toList());
    }
}
