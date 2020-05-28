package domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuiteTest {

    @Test
    void letterValueOf() {
        assertEquals(Suite.letterValueOf("S"), Suite.SPADES);
        assertEquals(Suite.letterValueOf("H"), Suite.HARTS);
        assertEquals(Suite.letterValueOf("D"), Suite.DIAMONDS);
        assertEquals(Suite.letterValueOf("C"), Suite.CLUBS);
    }

    @Test
    void invalidLetterValueOf() {
        assertThrows(IllegalArgumentException.class, () -> { Suite.letterValueOf("B"); });
    }


    @Test
    void valueOf() {
        assertEquals(Suite.valueOf("DIAMONDS"), Suite.DIAMONDS);
    }
}