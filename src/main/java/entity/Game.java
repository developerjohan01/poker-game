package entity;

public class Game {
    // TODO change accessor
    // We normally don't have a public constructor when using a static creator/factory method
    public Game() {
        System.out.println("new Game");
    }

    public static Game newInstance() {
        Game instance = new Game();
        System.out.println("Game newInstance");
        return instance;
    }

    public CardHand getHandOfCardsFromInput(String[] input) {
        // TODO Process input
        // TODO We can (should) do error checking here too: is the input valid?@
        // TODO at the moment we are going to ignore the input and use a fixed input the we know should work
        String[] fixedInput = {"AS", "10C", "10H", "3D", "3S"};
        // TODO build the hand of cards
        CardHand handOfCards = null;
        return  handOfCards;
    }

    public String result() {
        return "Two pairs";
    }
}
