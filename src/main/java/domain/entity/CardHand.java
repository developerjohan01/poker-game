package domain.entity;

import domain.value.Card;

import java.util.Map;

public interface CardHand {
    Boolean addCard(Card newCard);

    Map<Card, Integer> getCards();

    Integer getNumberOfCards();
}
