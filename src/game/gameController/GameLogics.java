package game.gameController;

import game.armes.Arme;
import game.armes.Epee;
import game.personnages.Guerrier;
import game.personnages.Personne;
import game.personnages.Soigneur;
import game.personnages.Sorcier;
import game.utils.Utils;

public class GameLogics {
    private static Personne opponent1;
    private static Personne opponent2;
    private static int selectedOpponent;
    private static int roundNum;


    static {
        selectedOpponent = 0;
        opponent1 = null;
        opponent2 = null;
        roundNum = 1;
    }
    public static void runGame() {
        while(GameLogics.getOpponent1().getPtnVie() > 0 &&
                GameLogics.getOpponent2().getPtnVie() > 0) {

            GameLogics.doAttak();
            GameLogics.displayOutOfActionPtns();
            GameLogics.checkAndNewRound();
        }
        GameLogics.displayWinner();
    }

    private static void checkAndNewRound() {
        if (GameLogics.getOpponent1().getPointsAction()<=0 && GameLogics.getOpponent2().getPointsAction()<=0){
            System.out.printf("le round n° %d est fini !\nplace au round n° %d!\n", roundNum, roundNum +1);
            GameLogics.getOpponent1().setPointsAction(100);
            GameLogics.getOpponent2().setPointsAction(100);
            roundNum++;
        }
    }

    private static void displayWinner() {
        if (GameLogics.getOpponent1().getPtnVie() <= 0) {
            System.out.println(GameLogics.getOpponent2().getPrenom()+" a gagné.");
        }
        else System.out.println(GameLogics.getOpponent1().getPrenom()+" a gagné.");
    }

    private static void doAttak() {
        Personne p1 = whoWillPlay();
        if(GameLogics.getSelectedOpponent()==1) {
            int healthBefore = GameLogics.getOpponent2().getPtnVie();
            p1.attaquer(GameLogics.getOpponent2());
            int healthAfter = GameLogics.getOpponent2().getPtnVie();
            System.out.println(p1.getPrenom() + "  attaque ! il inflige "+ (healthBefore - healthAfter) +
                    " points de dégats à " + GameLogics.getOpponent2().getPrenom());
        }
        else {
            int healthBefore = GameLogics.getOpponent1().getPtnVie();
            p1.attaquer(GameLogics.getOpponent1());
            int healthAfter = GameLogics.getOpponent1().getPtnVie();
            System.out.println(GameLogics.getOpponent2().getPrenom() + "  attaque ! il inflige "+ (healthBefore - healthAfter) +
                    " points de dégats à " + GameLogics.getOpponent1().getPrenom());
        }

        System.out.println(
                GameLogics.getOpponent1().getPrenom() + "  >>  " +
                        GameLogics.getOpponent1().getPtnVie() + "  ----  " +
                        GameLogics.getOpponent2().getPtnVie() +"  <<  " +
                        GameLogics.getOpponent2().getPrenom() +  "\n" );
    }

    private static void displayOutOfActionPtns() {
        if (GameLogics.getOpponent1().getPointsAction() <= 0) {
            System.out.println(GameLogics.getOpponent1().getPrenom() +
                    " est à cours de points d'action, il subit les attaques de "
            +GameLogics.getOpponent2().getPrenom() + " !");
        }
        if (GameLogics.getOpponent2().getPointsAction() <= 0) {
            System.out.println(GameLogics.getOpponent2().getPrenom() +
                    " est à cours de points d'action, il subit les attaques de "
                    +GameLogics.getOpponent1().getPrenom() + " !");
        }
    }

    static Personne whoWillPlay() {
        int rand = Utils.randInt(1, 2);
        if (rand == 1) {
            GameLogics.setSelectedOpponent(1);
            return GameLogics.getOpponent1();
        }
        GameLogics.setSelectedOpponent(2);
        return GameLogics.getOpponent2();
    }

    public static Personne createOpponent() {
        int pers = Utils.randInt(1, 3);
        Personne opp1=null;
        switch (pers) {
            case 1 -> {
                Arme arme = new Epee("Excalibur");
                opp1 = new Guerrier("warriorLname", "warriorFname", arme);
            }
            case 2 -> {
                opp1 = new Soigneur("healerLname", "healerFname");
            }
            case 3 -> {
                opp1 = new Sorcier("witchLname", "witchFname");
            }
        }
        return opp1;
    }


    static Personne getOpponent1() {
        return GameLogics.opponent1;
    }

    public static void setOpponent1(Personne opponent1) {
        GameLogics.opponent1 = opponent1;
    }

    static Personne getOpponent2() {
        return GameLogics.opponent2;
    }

    public static void setOpponent2(Personne opponent2) {
        GameLogics.opponent2 = opponent2;
    }

    private static int getSelectedOpponent() {
        return selectedOpponent;
    }

    private static void setSelectedOpponent(int selectedOpponent) {
        GameLogics.selectedOpponent = selectedOpponent;
    }
}
