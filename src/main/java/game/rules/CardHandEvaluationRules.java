package game.rules;

import game.objects.CardHand;

import java.util.List;

public interface CardHandEvaluationRules extends CardHand {
    // Make it possible to set the domain.rules so we could have different domain.rules for different hands/games
    void setRules(List<EvaluationRule> rules);

    String evaluateHand();
}
