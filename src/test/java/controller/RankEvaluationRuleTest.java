package controller;

import entity.CardHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankEvaluationRuleTest {

    EvaluationRule rankRule;
    Game game; // the context in which the hand is used
    CardHand hand;

    @BeforeEach
    void setUp() {
        game = Game.newInstance();
        rankRule = new RankEvaluationRule();
    }

    @Test
    void onePairEvaluate() {
        String[] onePairHand = {"AS", "QC", "10H", "3D", "3S"};
        hand = game.getHandOfCardsFromInput(onePairHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("One pair", evaluation);
    }

    @Test
    void twoPairsEvaluate() {
        String[] twoPairsHand = {"AS", "10C", "10H", "3D", "3S"};
        hand = game.getHandOfCardsFromInput(twoPairsHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Two pairs", evaluation);
    }

    // More tests of more rules
    @Disabled
    @Test
    void threeOfTheSameEvaluate() {
        String[] threeSameHand = {"AS", "10C", "10H", "10D", "3S"};
        hand = game.getHandOfCardsFromInput(threeSameHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Three of the same", evaluation);
    }

}