package domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void letterValueOf() {
        assertEquals( Rank.A, Rank.letterValueOf("A"));
        assertEquals( Rank.A, Rank.letterValueOf("Ace"));
        assertEquals( Rank.Three, Rank.letterValueOf("3"));
    }

    @Test
    void values() {
        assertEquals( 13, Rank.values().length);
    }

    @Test
    void valueOf() {
        assertEquals( Rank.Eight, Rank.valueOf("Eight"));
    }

    @Test
    void valueValueOf() {
        assertTrue( Rank.valueOf("Eight").getValue() > Rank.valueOf("Two").getValue());
        assertTrue( Rank.K.getValue() > Rank.Q.getValue());
    }

}