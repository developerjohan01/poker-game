package entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CardHand {
    // It is a good idea to initialize the collections with empty Set/Map(s) to avoid constant checks for null
    private Set<Card> originalHand = new HashSet<>();
    private Map<Integer, Integer> numberOfNumbers = new HashMap<>();
    private Map<Suite, Integer> numberOfSuite = new HashMap<>();

    Boolean isFullHand() {
        return originalHand.size() == 5;
    }

    Boolean addCard(Card newCard) {
        Boolean cardAdded = false;
        if (!isFullHand()) {
            cardAdded = originalHand.add(newCard);
            if (cardAdded) {
                Integer howManyNumbers = numberOfNumbers.get(newCard.getRankValue());
                if (howManyNumbers != null && howManyNumbers > 0) {
                    numberOfNumbers.put(newCard.getRankValue(), ++howManyNumbers);
                } else {
                    numberOfNumbers.put(newCard.getRankValue(), 1);
                }
                Integer howManySuites = numberOfSuite.get(newCard.getSuite());
                if (howManySuites != null && howManySuites > 0) {
                    numberOfSuite.put(newCard.getSuite(), ++howManySuites);
                } else {
                    numberOfSuite.put(newCard.getSuite(), 1);
                }
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
