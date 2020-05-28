package game.objects;

import java.util.Objects;

public class Card {
    private Rank rank;
    private Suite suite;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Card(String rank, String suite) {
        this.rank = Rank.letterValueOf(rank);
        this.suite = Suite.letterValueOf(suite);
    }


    public Rank getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
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