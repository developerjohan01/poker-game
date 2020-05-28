package game.objects;

import game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerCardHandTest {

    Game game; // the context in which the hand is used
    PokerCardHand subject;
    String[] twoPairsHand = {"AS", "10C", "10H", "3D", "3S"};
    String[] fourSameHand = {"10S", "10C", "10H", "10D", "3S"};

    @BeforeEach
    void setUp() {
        game = Game.newInstance();
        // TODO set the evaluation domain.rules
        subject = new PokerCardHand();
    }

    @Test
    void addCard() {
        assertEquals(0, subject.getNumberOfCards().intValue());
        subject.addCard(new Card("A", "S")); // 1
        assertEquals(1, subject.getNumberOfCards().intValue());
        subject.addCard(new Card(Rank.A, Suite.SPADES)); // 1 Adding the same twice - should have no effect
        assertEquals(1, subject.getNumberOfCards().intValue());
        subject.addCard(new Card("10", "C")); // 2
        assertEquals(2, subject.getNumberOfCards().intValue());
    }

    @Test
    void getCard() {
        // Only 0 when the hand is empty, before adding cards
        assertEquals(0, subject.getCards().size());
        subject = game.setupGameOfCardsFromInput(twoPairsHand);
        assertEquals(5, subject.getCards().size());
    }

    @Test
    void isFullHand() {
        assertEquals(false, subject.isFullHand());
        subject.addCard(new Card("A", "S")); // 1
        subject.addCard(new Card("10", "C")); // 2
        subject.addCard(new Card("10", "H")); // 3
        subject.addCard(new Card("3", "D")); // 4
        assertEquals(false, subject.isFullHand());
        subject.addCard(new Card("3", "S")); // 5
        assertEquals(true, subject.isFullHand());
    }

    @Test
    void getNumberOfCards() {
        assertEquals(0, subject.getNumberOfCards().intValue());
    }

    @Test
    void getNumberOfRanks() {
        // Only 0 when the hand is empty, before adding cards
        assertEquals(0, subject.getNumberOfRanks().intValue());
        subject = game.setupGameOfCardsFromInput(twoPairsHand);
        assertEquals(3, subject.getNumberOfRanks().intValue());
    }

    @Test
    void numberOfRanksContains() {
        // Only 0 when the hand is empty, before adding cards
        assertFalse(subject.numberOfRanksContains(2));
        subject = game.setupGameOfCardsFromInput(twoPairsHand);
        assertTrue(subject.numberOfRanksContains(2));

        assertFalse(subject.numberOfRanksContains(4));
        subject = game.setupGameOfCardsFromInput(fourSameHand);
        assertTrue(subject.numberOfRanksContains(4));
    }

    @Test
    void getNumberOfSuite() {
        // ONLY 0 when the hand is empty, before adding cards
        assertEquals(0, subject.getNumberOfSuite().intValue());
        subject = game.setupGameOfCardsFromInput(twoPairsHand);
        assertEquals(4, subject.getNumberOfSuite().intValue());
    }

    @Test
    void evaluateHand() {
        assertNotNull(subject.evaluateHand());
        assertTrue(subject.evaluateHand().length() == 0);
        subject = game.setupGameOfCardsFromInput(twoPairsHand);
        assertTrue(subject.evaluateHand().length() > 0);
    }
}