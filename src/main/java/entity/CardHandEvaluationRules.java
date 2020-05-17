package entity;

import controller.EvaluationRule;

import java.util.List;

public interface CardHandEvaluationRules extends CardHand {
    // Make it possible to set the rules so we could have different rules for different hands/games
    void setRules(List<EvaluationRule> rules);

    String evaluateHand();
}
