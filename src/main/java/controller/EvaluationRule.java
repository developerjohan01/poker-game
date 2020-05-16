package controller;

import entity.CardHand;

public interface EvaluationRule {
    String evaluate(CardHand hand);
}
