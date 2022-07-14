import game.gameController.GameLogics;

public class Main {
    public static void main(String[] args) {
        GameLogics.setOpponent1(GameLogics.createOpponent());
        GameLogics.setOpponent2(GameLogics.createOpponent());
        GameLogics.runGame();
    }
}