package game.rules;

import game.objects.PokerCardHand;

public class RankEvaluationRule implements EvaluationRule {
    @Override
    public String evaluate(CardHandEvaluationRules hand) {
        String result = "";
        if (!(hand instanceof PokerCardHand)) {
            return result;
        }
        PokerCardHand pokerHand = (PokerCardHand) hand;
        switch (pokerHand.getNumberOfRanks()) {
            case 1 :
                // 5 of the same NOTE we dont support Jokers at the moment so we cant get this
                result = "5 of the same";
                break;
            case 2 :
                // 4 of the same (4+1) or full house (3+2)
                result = "Four of the same";
                if (pokerHand.numberOfRanksContains(3)) {
                    result = "Full house";
                }
                break;
            case 3 :
                // 2 pairs (2+2+1) or 3 of the same (3+1+1)
                result = "Two pairs";
                if (pokerHand.numberOfRanksContains(3)) {
                    result = "Three of the same";
                }
                break;
            case 4 :
                // It is a pair (2+1+1+1)
                result = "One pair";
                break;
            default:
                // (1+1+1+1+1) TODO Check sequence / straight
        }
        return result;
    }
}
