package entity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {
    private static final int numberOfCards = 52; // 54? no! we ignore the Jokers now
    private Map<String, Integer> cardRankingSymbolValueMap = Stream.of(new Object[][] {
            {"A", 0},
            {"K", 1},
            {"Q", 2},
            {"Kn", 3},
            {"10", 4},
            {"9", 5},
            {"8", 6},
            {"7", 7},
            {"6", 8},
            {"5", 9},
            {"4", 10},
            {"3", 11},
            {"2", 12}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

//    Map<Integer, String> cardValueRankingMap
//            = Stream.of(new Object[][] {
//            {0, "A"},
//            {1, "K"},
//    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));



    public int getNumberOfCards() {
        return CardDeck.numberOfCards;
    }

    public Integer getCardRankingValue(String symbol) {
        return cardRankingSymbolValueMap.get(symbol);
    }

    // TODO do we need this?
    public String getCardRankingSymbol(Integer value) {
//        return cardValueRankingMap.get(value);
        return "A";
    }
}
