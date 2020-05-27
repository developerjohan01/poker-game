package entity;

public enum Rank {
    A(14),
    K(13),
    Q(12),
    Kn(11),
    Ten(10),
    Nine(9),
    Eight(8),
    Seven(7),
    Six(6),
    Five(5),
    Four(4),
    Three(3),
    Two(2);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public static Rank letterValueOf(String letterRank) {
        switch (letterRank.toUpperCase()) {
            case "ACE": // Not needed at the moment
            case "A": {
                return Rank.A;
            }
            case "K": {
                return Rank.K;
            }
            case "Q": {
                return Rank.Q;
            }
            case "KN": {
                return Rank.Kn;
            }
            case "10": {
                return Rank.Ten;
            }
            case "9": {
                return Rank.Nine;
            }
            case "8": {
                return Rank.Eight;
            }
            case "7": {
                return Rank.Seven;
            }
            case "6": {
                return Rank.Six;
            }
            case "5": {
                return Rank.Five;
            }
            case "4": {
                return Rank.Four;
            }
            case "3": {
                return Rank.Three;
            }
            case "2": {
                return Rank.Two;
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }
}
