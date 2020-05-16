package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game subject;

    @BeforeEach
    void setUp() {
        subject = new Game();
    }

    @Test
    void newInstance() {
        Game instance = Game.newInstance();
        assertNotNull(instance);
    }

    @Test
    void result() {
        String gameResult = subject.result();
        // TODO This will fail as soon as we start getting real results
        assertEquals("Two pairs", gameResult);
    }
}