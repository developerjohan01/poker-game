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

    public String result() {
        return "Two pairs";
    }
}
