package hillel.homeworks.lesson16;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void generateRandomResult() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 100; i++)
         list.add(Game.generateRandomResult());

        assertEquals(0, list.stream()
                .filter(e -> !(e >=1 && e <= 3))
                .count());
    }

    @Test
    void getGameResult() {
        assertEquals(Game.DRAW, Game.getGameResult(Game.STONE, Game.STONE));
        assertEquals(Game.DRAW, Game.getGameResult(Game.SCISSORS, Game.SCISSORS));
        assertEquals(Game.DRAW, Game.getGameResult(Game.PAPER, Game.PAPER));

        assertEquals(Game.PLAYER1, Game.getGameResult(Game.STONE, Game.SCISSORS));
        assertEquals(Game.PLAYER1, Game.getGameResult(Game.SCISSORS, Game.PAPER));
        assertEquals(Game.PLAYER1, Game.getGameResult(Game.PAPER, Game.STONE));

        assertEquals(Game.PLAYER2, Game.getGameResult(Game.SCISSORS, Game.STONE));
        assertEquals(Game.PLAYER2, Game.getGameResult(Game.PAPER, Game.SCISSORS));
        assertEquals(Game.PLAYER2, Game.getGameResult(Game.STONE, Game.PAPER));
    }
}