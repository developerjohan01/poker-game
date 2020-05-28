package domain.rules;

import domain.entity.CardHand;
import domain.rules.EvaluationRule;

import java.util.List;

public interface CardHandEvaluationRules extends CardHand {
    // Make it possible to set the domain.rules so we could have different domain.rules for different hands/games
    void setRules(List<EvaluationRule> rules);

    String evaluateHand();
}
