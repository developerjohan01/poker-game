package controller;

import entity.CardHandEvaluationRules;

public interface EvaluationRule {
    String evaluate(CardHandEvaluationRules hand);
}
