package hillel.homeworks.lesson13.collfiltering;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    @Test
    void filterCollection() {
        List<String> coll = List.of("aaa", "Bbbb", "cccc", "DD", "eeee");
        List<String> newColl =  new Service().filterCollection(coll);
        assertEquals(2, newColl.size());
        assertTrue(newColl.equals(List.of("cccc", "eeee")));
    }
}