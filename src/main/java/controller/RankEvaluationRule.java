package controller;

import entity.CardHand;

public class RankEvaluationRule implements EvaluationRule {
    @Override
    public String evaluate(CardHand hand) {
        String result = "";
        switch (hand.getNumberOfNumbers()) {
            case 1 :
                // 5 of the same NOTE we dont support Jokers at the moment so we cant get this
                result = "5 of the same";
                break;
            case 2 :
                // 4 of the same (4+1) or full house (3+2)
                break;
            case 3 :
                // 2 pairs (2+2+1) or 3 of the same (3+1+1)
                // TODO lets assume that tis is ALWAYS 2 pairs then the first test passes
                result = "Two pairs";
                // TODO then we need to fix the next test which checks for 3 of the same
                // result = "Three of the same";
                break;
            case 4 :
                // It is a pair (2+1+1+1)
                result = "One pair";
                // Get the cards so we can check what pair...
                // Set<Card> cards = hand.getCards();
                break;
            default:
                // (1+1+1+1+1) Check sequence / straight
        }
        return result;
    }
}
