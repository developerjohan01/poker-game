package game.rules;

import game.Game;
import game.objects.PokerCardHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankEvaluationRuleTest {

    EvaluationRule rankRule;
    Game game; // the context in which the hand is used
    PokerCardHand hand;

    @BeforeEach
    void setUp() {
        game = Game.newInstance();
        rankRule = new RankEvaluationRule();
    }

    @Test
    void onePairEvaluate() {
        String[] onePairHand = {"AS", "QC", "10H", "3D", "3S"};
        hand = game.setupGameOfCardsFromInput(onePairHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("One pair", evaluation);
    }

    @Test
    void twoPairsEvaluate() {
        String[] twoPairsHand = {"AS", "10C", "10H", "3D", "3S"};
        hand = game.setupGameOfCardsFromInput(twoPairsHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Two pairs", evaluation);
    }

    @Test
    void threeOfTheSameEvaluate() {
        String[] threeSameHand = {"AS", "10C", "10H", "10D", "3S"};
        hand = game.setupGameOfCardsFromInput(threeSameHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Three of the same", evaluation);
    }

    @Test
    void fourOfTheSameEvaluate() {
        String[] fourSameHand = {"10S", "10C", "10H", "10D", "3S"};
        hand = game.setupGameOfCardsFromInput(fourSameHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Four of the same", evaluation);
    }

    @Test
    void fullHouseOfTheSameEvaluate() {
        String[] fullHouseHand = {"10S", "10C", "10H", "3D", "3S"};
        hand = game.setupGameOfCardsFromInput(fullHouseHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("Full house", evaluation);
    }

    @Test
    void allDifferentEvaluate() {
        String[] allDifferentHand = {"2S", "3C", "4H", "6D", "KnS"};
        hand = game.setupGameOfCardsFromInput(allDifferentHand);
        String evaluation = rankRule.evaluate(hand);
        assertEquals("", evaluation);
    }

}