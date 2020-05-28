package domain.entity;

import domain.rules.CardHandEvaluationRules;
import domain.rules.EvaluationRule;
import domain.value.Card;

import java.util.*;

public class PokerCardHand implements CardHand, CardHandEvaluationRules {
    // It is a good idea to initialize the collections with empty Set/Map(s) to avoid constant checks for null
    private Map<Card, Integer> originalHand = new HashMap<>();
    private Map<Rank, Integer> numberOfRanks = new HashMap<Rank, Integer>();
    private Map<Suite, Integer> numberOfSuite = new HashMap<>();

    private List<EvaluationRule> rules = new ArrayList<>();

    @Override
    public void setRules(List<EvaluationRule> rules) {
        this.rules = rules;
    }

    Boolean isFullHand() {
        return originalHand.size() == 5;
    }

    @Override
    public Boolean addCard(Card newCard) {
        Boolean cardAdded = false;
        if (!isFullHand()) {
            Integer howManyOfThisCard = originalHand.get(newCard);
            if (howManyOfThisCard != null && howManyOfThisCard > 0) {
                // @ of the same is not allowed in poker... but if you use 2 decks...
                // originalHand.put(newCard, ++howManyOfThisCard);
            } else {
                cardAdded = originalHand.put(newCard, 1) == null;
            }

            if (cardAdded) {
                Integer howManyRanks = numberOfRanks.get(newCard.getRank());
                if (howManyRanks != null && howManyRanks > 0) {
                    numberOfRanks.put(newCard.getRank(), ++howManyRanks);
                } else {
                    numberOfRanks.put(newCard.getRank(), 1);
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

    @Override
    public Map<Card, Integer> getCards() {
        return  this.originalHand;
    }

    @Override
    public Integer getNumberOfCards() {
        return originalHand.size();
    }

    public Integer getNumberOfRanks() {
        return numberOfRanks.size();
    }

    public Boolean numberOfRanksContains(Integer count) {
        return numberOfRanks.containsValue(count);
    }

    public Integer getNumberOfSuite() {
        return numberOfSuite.size();
    }

    @Override
    public String evaluateHand() {
        String handEvaluated = "";
        for (EvaluationRule rule:
             rules) {
            handEvaluated += rule.evaluate(this);
        }
        return handEvaluated;
    }
}
