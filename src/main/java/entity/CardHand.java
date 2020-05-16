package entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CardHand {
    Set<Card> originalHand = new HashSet<>();
    Map<Integer, Integer> numberOfNumbers = new HashMap<>();
    Map<Integer, Integer> numberOfSuite = new HashMap<>();

    Boolean isFullHand() {
        return originalHand.size() == 5;
    }

    Boolean addCard(Card newCard) {
        Boolean cardAdded = false;
        if (!isFullHand()) {
            cardAdded = originalHand.add(newCard);
            if (cardAdded) {
                // numberOfNumbers.
            }
        }
        return cardAdded;
    }

    Integer getNumberOfCards() {
        return originalHand.size();
    }

    Integer getNumberOfNumbers() {
        return numberOfNumbers.size();
    }

    Integer getNumberOfSuite() {
        return numberOfSuite.size();
    }
}
