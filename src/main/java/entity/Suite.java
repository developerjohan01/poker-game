package entity;

public enum Suite {
    SPADES(3), // Highest rank
    HARTS(2),
    DIAMONDS(1),
    CLUBS(0); // Lowest rank

    private final int value;

    Suite(int value){
        this.value = value;
    }

    public static Suite letterValueOf(String oneLetterSuite) {
        switch (oneLetterSuite.toUpperCase()) {
            case "S": {
                return Suite.SPADES;
            }
            case "H": {
                return Suite.HARTS;
            }
            case "D": {
                return Suite.DIAMONDS;
            }
            case "C": {
                return Suite.CLUBS;
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    public int rankOf() {
        return this.value;
    }
}