package hillel.homeworks.lesson14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PsevdoGrStringTest {
    @Test
    void verifyInput() {
        String[] args = {"0", "1", "2", "3"};
        PsevdoGrString s = new PsevdoGrString();
        assertTrue(s.verifyInput(args));
    }

    @Test
    void add() {
        String[] args = {"0", "1", "2", "3"};
        PsevdoGrString s = new PsevdoGrString();
        s.add(args);
        List<String[]> list = s.getMatrixList();
        assertEquals(7, list.size());   // 4 символа + 3 пробела между ними
    }

    @Test
    void getMatrixLineList() {
        String[] args = {"0", "1", "2", "3"};
        String[] firstIndexString = {"@   @", "     ", " @@  ", "     ", "@   @", "     ", "    @"};

        PsevdoGrString s = new PsevdoGrString();
        s.add(args);
        List<String> list = s.getMatrixLineList(1);
        assertTrue( list.equals(Arrays.stream(firstIndexString).toList()) );
    }
}