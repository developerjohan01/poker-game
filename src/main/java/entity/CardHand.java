package entity;

import controller.EvaluationRule;

import java.util.*;

public class CardHand {
    // It is a good idea to initialize the collections with empty Set/Map(s) to avoid constant checks for null
    private Set<Card> originalHand = new HashSet<>();
    private Map<Integer, Integer> numberOfNumbers = new HashMap<>();
    private Map<Suite, Integer> numberOfSuite = new HashMap<>();

    private List<EvaluationRule> rules = new ArrayList<>();
    // Make it possible to set the rules so we could have different rules for different hands/games
    public void setRules(List<EvaluationRule> rules) {
        this.rules = rules;
    }

    Boolean isFullHand() {
        return originalHand.size() == 5;
    }

    public Boolean addCard(Card newCard) {
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

    public Integer getNumberOfCards() {
        return originalHand.size();
    }

    public Integer getNumberOfNumbers() {
        return numberOfNumbers.size();
    }

    public Integer getNumberOfSuite() {
        return numberOfSuite.size();
    }

    public String evaluateHand() {
        String handEvaluated = "";
        for (EvaluationRule rule:
             rules) {
            rule.evaluate(this);
        }
        return handEvaluated;
    }
}
