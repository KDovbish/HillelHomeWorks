package hillel.homeworks.lesson13.toupper;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    @Test
    void getPairCollection() {
        List<String> coll = List.of("aaa", "bbb", "ccc");
        List<Pair> newColl = new Service().getPairCollection(coll);
        //  Проверка типа элементов хранящихся в коллекции
        assertTrue(newColl.get(1).getClass().getName().endsWith("Pair"));
        //  Проверка размеров коллекции
        assertEquals(3, newColl.size());
        //  Проверка члена upper
        assertTrue(newColl.get(1).getUpper().equals("BBB"));
    }
}