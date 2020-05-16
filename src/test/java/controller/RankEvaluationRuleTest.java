package controller;

import entity.CardHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankEvaluationRuleTest {

    EvaluationRule rankRule;
    Game game; // the context in which the hand is used
    CardHand hand;
    String[] testHand = {"AS", "10C", "10H", "3D", "3S"};

    @BeforeEach
    void setUp() {
        game = Game.newInstance();
        hand = game.getHandOfCardsFromInput(testHand);
        rankRule = new RankEvaluationRule();
    }

    @Test
    void evaluate() {
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Two pairs", evaluation);
    }
}