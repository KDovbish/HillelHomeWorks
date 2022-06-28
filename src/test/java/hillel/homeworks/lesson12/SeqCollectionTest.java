package hillel.homeworks.lesson12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SeqCollectionTest {

    private Collection coll;

    @BeforeAll
    void createCollection() {
        coll = new SeqCollection();
    }

    @BeforeEach
    void clearCollection() {
        coll.clear();
    }

    @Test
    void addByValue() {
        assertTrue(coll.add("000"));
        assertEquals(1, coll.size());
    }

    @Test
    void addByIndex() {
        assertTrue(coll.add(0, "000"));
        assertEquals(1, coll.size());
        assertTrue(coll.add(0, "111"));
        assertEquals(2, coll.size());
        assertTrue(coll.get(0).equals("111"));
    }

    @Test
    void delete() {
        coll.add(0, "000"); coll.add(0, "111");
        assertTrue(coll.delete("111"));
        assertEquals(1, coll.size());
        assertTrue(coll.delete("000"));
        assertEquals(0, coll.size());
        assertFalse(coll.delete("zzz"));
    }

    @Test
    void get() {
        coll.add("000"); coll.add("111"); coll.add("222");
        assertTrue(coll.get(1).equals("111"));
        assertTrue(coll.get(3).equals("UNKNOWN INDEX"));
    }

    @Test
    void contains() {
        coll.add("000"); coll.add("111"); coll.add("222");
        assertTrue(coll.contains("222"));
    }

    @Test
    void testEquals() {
        //  сравнение сама с собою
        coll.add("000"); coll.add("111");
        assertTrue(coll.equals(coll));

        // разница в размерах
        Collection coll2 = new SeqCollection();
        coll2.add("000");
        assertFalse(coll.equals(coll2));

        //  поэлементное сравнение
        coll2.add("111");
        assertTrue(coll.equals(coll2));
    }

    @Test
    void clear() {
        coll.add("000"); coll.add("111");
        coll.clear();
        assertEquals(0, coll.size());
    }

    @Test
    void size() {
        coll.add("000");
        assertEquals(1, coll.size());
        coll.delete("000");
        assertEquals(0, coll.size());
    }
}