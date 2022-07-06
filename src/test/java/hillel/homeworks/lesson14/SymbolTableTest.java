package hillel.homeworks.lesson14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableTest {
    @Test
    void getSymbolMatrix() {
        String a[] = SymbolTable.getSymbolMatrix(' ');
        String[] spaceMatrix = {"     ", "     ", "     ", "     ", "     "};
        assertEquals(0, Arrays.compare(a, spaceMatrix, (x, y) -> {if(x.equals(y)) return 0; else return -1;} ));
    }
}