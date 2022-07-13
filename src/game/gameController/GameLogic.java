package game.gameController;

import game.armes.Arme;
import game.armes.Epee;
import game.personnages.Guerrier;
import game.personnages.Personne;
import game.personnages.Soigneur;
import game.personnages.Sorcier;
import game.utils.Utils;

public class GameLogic {
    private static Personne opponent1;
    private static Personne opponent2;
    private static int selectedOpponent;


    static {
        selectedOpponent = 0;
        opponent1 = null;
        opponent2 = null;
    }
    public static void runGame() {
        while(GameLogic.getOpponent1().getPtnVie() > 0 &&
                GameLogic.getOpponent2().getPtnVie() > 0) {

            Personne p1 = whoWillPlay();
            if(GameLogic.getSelectedOpponent()==1) {
                p1.attaquer(GameLogic.getOpponent2());
                System.out.println(p1.getPrenom() + "  attaque !");
            }
            else {
                p1.attaquer(GameLogic.getOpponent1());
                System.out.println(GameLogic.getOpponent2().getPrenom() + "  attaque !");
            }

            System.out.println(
                    GameLogic.getOpponent1().getPrenom() + "  >>  " +
                            GameLogic.getOpponent1().getPtnVie() + "  ----  " +
                            GameLogic.getOpponent2().getPtnVie() +"  <<  " +
                            GameLogic.getOpponent2().getPrenom() +  "\n" );
        }

        if (GameLogic.getOpponent1().getPtnVie() <= 0) {
            System.out.println(GameLogic.getOpponent2().getPrenom()+" a gagné.");
        }
        else System.out.println(GameLogic.getOpponent1().getPrenom()+" a gagné.");
    }

    static Personne whoWillPlay() {
        int rand = Utils.randInt(1, 2);
        if (rand == 1) {
            GameLogic.setSelectedOpponent(1);
            return GameLogic.getOpponent1();
        }
        GameLogic.setSelectedOpponent(2);
        return GameLogic.getOpponent2();
    }

    public static Personne createOpponent() {
        int pers = Utils.randInt(1, 3);
        Personne opp1=null;
        switch (pers) {
            case 1 -> {
                Arme arme = new Epee("Escalibur");
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
        return GameLogic.opponent1;
    }

    public static void setOpponent1(Personne opponent1) {
        GameLogic.opponent1 = opponent1;
    }

    static Personne getOpponent2() {
        return GameLogic.opponent2;
    }

    public static void setOpponent2(Personne opponent2) {
        GameLogic.opponent2 = opponent2;
    }

    private static int getSelectedOpponent() {
        return selectedOpponent;
    }

    private static void setSelectedOpponent(int selectedOpponent) {
        GameLogic.selectedOpponent = selectedOpponent;
    }
}
