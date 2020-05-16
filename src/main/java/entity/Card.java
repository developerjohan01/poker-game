package entity;

import java.util.Objects;

public class Card {
    private Integer rankValue;
    private Suite suite;
    static CardDeck belongsToDeckOfCards = new CardDeck();

    public Card(Integer rankValue, Suite suite) {
        this.rankValue = rankValue;
        this.suite = suite;
    }

    public Card(String rank, String suite) {
        this.rankValue = belongsToDeckOfCards.getCardRankingValue(rank);
        this.suite = Suite.letterValueOf(suite);
    }


    public Integer getRankValue() {
        return rankValue;
    }

    public Suite getSuite() {
        return suite;
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
        return rankValue.equals(card.rankValue) &&
                suite == card.suite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankValue, suite);
    }
}