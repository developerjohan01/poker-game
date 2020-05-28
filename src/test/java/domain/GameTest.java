package domain;

import domain.entity.CardHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game subject;

    @BeforeEach
    void setUp() {
        subject = Game.newInstance();
    }

    @Test
    void newInstance() {
        Game instance = Game.newInstance();
        assertNotNull(instance);
    }

    @Test
    void setupGameOfCardsFromInput() {
        String[] input = {"AS", "10C", "10H", "3D", "3S"};
        CardHand hand = subject.setupGameOfCardsFromInput(input);
        assertNotNull(hand);
        assertEquals(5, hand.getNumberOfCards().intValue());
    }

    @Test
    void invalidSetupGameOfCardsFromInput() {
        String[] input1 = {"AS", "10C", "10H", "3D"};

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setupGameOfCardsFromInput(input1);
        });

        String[] input2 = {"AS", "10C", "10H", "3D", "some-domain.value"};
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setupGameOfCardsFromInput(input2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setupGameOfCardsFromInput(null);
        });
    }

    @Test
    void result() {
        String[] input = {"AS", "10C", "10H", "3D", "3S"};
        CardHand hand = subject.setupGameOfCardsFromInput(input);
        String gameResult = subject.result();
        assertEquals("Two pairs", gameResult);
    }
}