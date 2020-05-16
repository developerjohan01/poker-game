package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardHandTest {

    CardHand subject;
    String[] testHand = {"AS", "10C", "10H", "3D", "3S"};

    @BeforeEach
    void setUp() {
        subject = new CardHand();
    }

    @Test
    void isFullHand() {
        assertEquals(false, subject.isFullHand());
        subject.addCard(new Card("A", "S")); // 1
        subject.addCard(new Card(0, Suite.SPADES)); // 1 Adding the same twice - should have no effect
        subject.addCard(new Card("10", "C")); // 2
        subject.addCard(new Card("10", "H")); // 3
        subject.addCard(new Card("3", "D")); // 4
        assertEquals(false, subject.isFullHand());
        subject.addCard(new Card("3", "S")); // 5
        assertEquals(true, subject.isFullHand());
    }

    @Test
    void addCard() {
        fail("todo");
    }

    @Test
    void getNumberOfCards() {
        fail("todo");
    }

    @Test
    void getNumberOfNumbers() {
        fail("todo");
    }

    @Test
    void getNumberOfSuite() {
        fail("todo");
    }
}