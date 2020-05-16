import entity.Game;

public class StartGame {

    public static void main(String[] args) {
        System.out.println("Staring the Game");
        Game theGame = Game.newInstance();
        System.out.println(theGame.result());
    }
}
