package controller;

import entity.Card;
import entity.CardHand;

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

    public CardHand getHandOfCardsFromInput(String[] handInput) {
        // Process handInput
        if (handInput != null && handInput.length == 5) {
            CardHand handOfCards = new CardHand();
            // Build the hand of cards
            for (String cardString : handInput) {
                String rankSymbol = cardString.substring(0, cardString.length() - 1);
                String suiteLetter = cardString.substring(cardString.length() - 1);
                handOfCards.addCard(new Card(rankSymbol, suiteLetter));
            }
            return handOfCards;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String result() {
        return "Two pairs";
    }
}
