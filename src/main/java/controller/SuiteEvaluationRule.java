package controller;

import entity.Card;
import entity.CardHand;

import java.util.Iterator;
import java.util.Set;

public class SuiteEvaluationRule implements EvaluationRule {
    @Override
    public String evaluate(CardHand hand) {
        String result = "";
        if (hand.getNumberOfSuite() == 1) {
            // If the number of suites is 1 then it is a flush
            result = "Flush of";
            // Get a card so we can check what Suite
            Set<Card> cards = hand.getCards();
            Iterator iterator = cards.iterator();
            Card card = (Card) iterator.next();
            result += " " + card.getSuite().name();
        }
        return result;
    }
}
