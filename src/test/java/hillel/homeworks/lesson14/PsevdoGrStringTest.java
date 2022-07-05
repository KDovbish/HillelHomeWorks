package hillel.homeworks.lesson14;

import static org.junit.jupiter.api.Assertions.*;

class PsevdoGrStringTest {

    @org.junit.jupiter.api.Test
    void verify() {
        String[] args = {"0", "1.2", "2", "3"};
        PsevdoGrString s = new PsevdoGrString();
        assertTrue(s.verify(args));
    }
}