package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    CardDeck subject;

    @BeforeEach
    void setUp() {
        subject = new CardDeck();
    }

    @Test
    void getNumberOfCards() {
        assertEquals( 52, subject.getNumberOfCards());
    }

    @Test
    void getCardRankingValue() {
        assertEquals( 0, subject.getCardRankingValue("A").intValue());
        assertEquals( 2, subject.getCardRankingValue("Q").intValue());
        assertEquals( 3, subject.getCardRankingValue("Kn").intValue());
        assertEquals( 4, subject.getCardRankingValue("10").intValue());
    }

    @Disabled
    @Test
    void getCardRankingSymbol() {
    }
}