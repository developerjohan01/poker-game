package controller;

import controller.Game;
import entity.CardHand;
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
    void getHandOfCardsFromInput() {
        String[] input = {"AS", "10C", "10H", "3D", "3S"};
        CardHand hand = subject.getHandOfCardsFromInput(input);
        assertNotNull(hand);
        assertEquals(5, hand.getNumberOfCards().intValue());
    }

    @Test
    void invalidGetHandOfCardsFromInput() {
        String[] input1 = {"AS", "10C", "10H", "3D"};

        assertThrows(IllegalArgumentException.class, () -> {
            subject.getHandOfCardsFromInput(input1);
        });

        String[] input2 = {"AS", "10C", "10H", "3D", "some-value"};
        assertThrows(IllegalArgumentException.class, () -> {
            subject.getHandOfCardsFromInput(input2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.getHandOfCardsFromInput(null);
        });
    }

    @Test
    void result() {
        String gameResult = subject.result();
        // TODO This will fail as soon as we start getting real results
        assertEquals("Two pairs", gameResult);
    }
}