import game.gameController.GameLogic;

public class Main {
    public static void main(String[] args) {
        GameLogic.setOpponent1(GameLogic.createOpponent());
        GameLogic.setOpponent2(GameLogic.createOpponent());
        GameLogic.runGame();
    }
}