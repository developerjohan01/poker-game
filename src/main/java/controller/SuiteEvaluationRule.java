package controller;

import entity.Card;
import entity.CardHandEvaluationRules;
import entity.PokerCardHand;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SuiteEvaluationRule implements EvaluationRule {
    @Override
    public String evaluate(CardHandEvaluationRules hand) {
        String result = "";
        if (!(hand instanceof PokerCardHand)) {
            return result;
        }
        PokerCardHand pokerHand = (PokerCardHand) hand;
        if (pokerHand.getNumberOfSuite() == 1) {
            // If the number of suites is 1 then it is a flush
            result = "Flush of";
            // Get any card so we can check what Suite
            Map<Card, Integer> cards = pokerHand.getCards();
            Iterator iterator = cards.entrySet().iterator();
            Map.Entry<Card, Integer> entry = (Map.Entry) iterator.next();
            result += " " + entry.getKey().getSuite().name();
        }
        return result;
    }
}
