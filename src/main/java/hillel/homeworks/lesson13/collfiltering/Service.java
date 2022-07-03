package hillel.homeworks.lesson13.collfiltering;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
    List<String> filterCollection(List<String> coll) {
        return coll.stream()
                .filter(e -> e.length() == 4)
                .filter(e -> e.toLowerCase().equals(e))
                .collect(Collectors.toList());
    }
}
