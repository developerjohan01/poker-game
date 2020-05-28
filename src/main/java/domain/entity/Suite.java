package domain.entity;

public enum Suite {
    SPADES, // Highest rank
    HARTS,
    DIAMONDS,
    CLUBS; // Lowest rank

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
}