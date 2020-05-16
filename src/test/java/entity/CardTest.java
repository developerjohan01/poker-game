package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    Card subject;

    @BeforeEach
    void setUp() {
        subject = new Card("A", "H"); // Ace of Harts

    }
    @Test
    void getRankValue() {
        assertEquals(0, subject.getRankValue().intValue());
    }

    @Test
    void getSuite() {
        assertEquals(Suite.HARTS, subject.getSuite());
    }

    @Test
    void testEquals() {
        Card newCard = new Card(0, Suite.HARTS);
        assertEquals(subject, newCard);
    }
}