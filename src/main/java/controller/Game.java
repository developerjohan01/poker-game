package controller;

import entity.Card;
import entity.CardHandEvaluationRules;
import entity.PokerCardHand;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // We normally don't have a public constructor when using a static creator/factory method
    private Game() {
        System.out.println("new Game");
    }

    public static Game newInstance() {
        Game instance = new Game();
        System.out.println("Game newInstance");
        return instance;
    }

    private List<EvaluationRule> gameRules = new ArrayList<>();

    private void setupRules(CardHandEvaluationRules hand) {
        gameRules.add(new RankEvaluationRule());
        gameRules.add(new SuiteEvaluationRule());
        hand.setRules(gameRules);
    }

    private PokerCardHand hand;

    public PokerCardHand setupGameOfCardsFromInput(String[] handInput) {
        // Process handInput
        if (handInput != null && handInput.length == 5) {
            PokerCardHand handOfCards = new PokerCardHand();
            // Build the hand of cards
            for (String cardString : handInput) {
                String rankSymbol = cardString.substring(0, cardString.length() - 1);
                String suiteLetter = cardString.substring(cardString.length() - 1);
                handOfCards.addCard(new Card(rankSymbol, suiteLetter));
            }
            this.hand = handOfCards;
            this.setupRules(this.hand);
            return this.hand;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String result() {
        if (this.hand != null) {
            return this.hand.evaluateHand();
        }
        return "Hmmm... Not sure...";
    }
}
