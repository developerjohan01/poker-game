import domain.Game;

public class StartGame {

    public static void main(String[] args) {
        System.out.println("Staring the Game");
        Game theGame = Game.newInstance();
        theGame.setupGameOfCardsFromInput(args);
        System.out.println("The result");
        System.out.println(theGame.result());
    }
}
