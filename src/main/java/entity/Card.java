package entity;

import java.util.Objects;

public class Card {
    Integer rank;
    Suite suite;
    static CardDeck belongsToDeckOfCards = new CardDeck();

    public Card(Integer rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Card(String rank, String suite) {
        this.rank = belongsToDeckOfCards.getCardRankingValue(rank);
        this.suite = Suite.letterValueOf(suite);
    }

    // If we want to change the Deck Of Cards OR the Game - this might change the RankingValue
    public static void setBelongsToDeckOfCards(CardDeck belongsToDeckOfCards) {
        Card.belongsToDeckOfCards = belongsToDeckOfCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank.equals(card.rank) &&
                suite == card.suite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suite);
    }
}