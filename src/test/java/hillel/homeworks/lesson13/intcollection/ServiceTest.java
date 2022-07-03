package hillel.homeworks.lesson13.intcollection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void calcIntCollAverage() {
        List<Integer> coll = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(4.5f, (new Service().calcIntCollAverage(coll)));
    }
}