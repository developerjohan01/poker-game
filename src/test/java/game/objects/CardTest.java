package game.objects;

import game.objects.Card;
import game.objects.Rank;
import game.objects.Suite;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(Rank.A, subject.getRank());
    }

    @Test
    void getSuite() {
        Assertions.assertEquals(Suite.HARTS, subject.getSuite());
    }

    @Test
    void testEquals() {
        Card newCard = new Card(Rank.A, Suite.HARTS);
        assertEquals(subject, newCard);
    }
}