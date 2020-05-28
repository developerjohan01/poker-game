package domain.rules;

import domain.value.Card;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class TopCardEvaluationRule implements EvaluationRule {
    @Override
    public String evaluate(CardHandEvaluationRules hand) {
        String result = "";
        Set<Card> entries = hand.getCards().keySet();
        final Optional<Card> max = entries.stream().max(Comparator.comparingInt(c -> c.getRank().getValue()));
        if (max.isPresent()) {
            result = "\nThe highest card rank is " + max.get().getRank();
        }
        return result;
    }
}
