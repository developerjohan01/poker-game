package controller;

import entity.PokerCardHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuiteEvaluationRuleTest {

    EvaluationRule rankRule;
    Game game; // the context in which the hand is used
    PokerCardHand hand;
    String[] mixedSuiteHand = {"AS", "10C", "10H", "3D", "3S"};
    String[] sameSuiteHand = {"AS", "10S", "9S", "3S", "2S"};

    @BeforeEach
    void setUp() {
        game = Game.newInstance();
        rankRule = new SuiteEvaluationRule();
    }

    @Test
    void mixedSuiteEvaluate() {
        hand = game.setupGameOfCardsFromInput(mixedSuiteHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("", evaluation);
    }

    @Test
    void sameSuiteEvaluate() {
        hand = game.setupGameOfCardsFromInput(sameSuiteHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Flush of SPADES", evaluation);
    }

}