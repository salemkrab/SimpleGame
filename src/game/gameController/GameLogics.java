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
        setRoundNum(1);
    }
    public static void runGame() {
        GameLogics.setOpponent1(GameLogics.createOpponent());
        GameLogics.setOpponent2(GameLogics.createOpponent());

        while(GameLogics.getOpponent1().getPtnVie() > 0 &&
                GameLogics.getOpponent2().getPtnVie() > 0) {

            GameLogics.doAttak();
//            GameLogics.displayOutOfActionPtns();
            GameLogics.checkAndNewRound();
        }
        GameLogics.displayWinner();
    }

    private static void checkAndNewRound() {
        if (GameLogics.getOpponent1().getPointsAction()<=0 && GameLogics.getOpponent2().getPointsAction()<=0){
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.printf("le round n° %d est fini !\nplace au round n° %d!\n",
                    GameLogics.getRoundNum(), GameLogics.getRoundNum() +1);
            System.out.println("----------------------------------------------------------------------------\n");
            GameLogics.getOpponent1().setPointsAction(100);
            GameLogics.getOpponent2().setPointsAction(100);
            GameLogics.setRoundNum(GameLogics.getRoundNum() + 1);
        }
    }

    private static void displayWinner() {
        if (GameLogics.getOpponent1().getPtnVie() <= 0) {
            System.out.println(GameLogics.getOpponent2().getPrenom()+" a gagné. à l'issue de "
                    +GameLogics.getRoundNum()+" rounds!");
        }
        else System.out.println(GameLogics.getOpponent1().getPrenom()+" a gagné. à l'issue de "
                +GameLogics.getRoundNum()+" rounds!");
    }

    private static void doAttak() {
        GameLogics.whoWillPlay();
        Personne op1 = GameLogics.getOpponent1();
        Personne op2 = GameLogics.getOpponent2();
        if(GameLogics.getSelectedOpponent()==1) {
            int healthBefore = op2.getPtnVie();
            op1.attaquer(op2);
            int healthAfter = op2.getPtnVie();
            System.out.println(op1.getPrenom() + " ("+ op1 +") attaque ! il inflige "+ (healthBefore - healthAfter) +
                    " points de dégats à " + op2.getPrenom()+ " ("+ op2 +")");
        }
        else {
            int healthBefore = op1.getPtnVie();
            op2.attaquer(op1);
            int healthAfter = op1.getPtnVie();
            System.out.println(op2.getPrenom() + " ("+ op2 +") attaque ! il inflige "+ (healthBefore - healthAfter) +
                    " points de dégats à " + op1.getPrenom() + " ("+ op1 +")");
        }

        System.out.println(
                op1.getPrenom() + "  >>  " +
                        op1.getPtnVie() + "  ----  " +
                        op2.getPtnVie() +"  <<  " +
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

    private static void whoWillPlay() {
        int rand = Utils.randInt(1, 2);
        if (rand == 1) {
            GameLogics.setSelectedOpponent(1);
        }
        else GameLogics.setSelectedOpponent(2);
    }

    private static Personne createOpponent() {
        int pers = Utils.randInt(1, 3);
        Personne opp=null;
        String fName = Utils.getRandName();
        String lName = Utils.getRandName();
        switch (pers) {
            case 1 -> {
                Arme arme = new Epee("Excalibur");
                opp = new Guerrier(fName, lName, arme);
            }
            case 2 -> {
                opp = new Soigneur(fName, lName);
            }
            case 3 -> {
                opp = new Sorcier(fName, lName);
            }
        }
        return opp;
    }


// -------------------------------------getters & setters----------------------------------------------------
    private static Personne getOpponent1() {
        return GameLogics.opponent1;
    }

    private static void setOpponent1(Personne opponent1) {
        GameLogics.opponent1 = opponent1;
    }

    private static Personne getOpponent2() {
        return GameLogics.opponent2;
    }

    private static void setOpponent2(Personne opponent2) {
        GameLogics.opponent2 = opponent2;
    }

    private static int getSelectedOpponent() {
        return GameLogics.selectedOpponent;
    }

    private static void setSelectedOpponent(int selectedOpponent) {
        GameLogics.selectedOpponent = selectedOpponent;
    }

    private static int getRoundNum() {
        return GameLogics.roundNum;
    }
    private static void setRoundNum(int roundNum) {
        GameLogics.roundNum = roundNum;
    }
}
// -------------------------------------getters & setters----------------------------------------------------
