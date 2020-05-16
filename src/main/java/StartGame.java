import entity.CardHand;
import entity.Game;

public class StartGame {

    public static void main(String[] args) {
        System.out.println("Staring the Game");
        Game theGame = Game.newInstance();
        System.out.println("Handle the input");
        CardHand theHand = theGame.getHandOfCardsFromInput(args);
        System.out.println(theGame.result());
    }
}
