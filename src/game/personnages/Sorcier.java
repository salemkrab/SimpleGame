package game.personnages;

import game.utils.Utils;

public class Sorcier extends Personne {
    public Sorcier(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void attaquer(Personne p) {
        if (this.getPointsAction()>0) {
            int damage = Utils.randInt(5,20);
            p.setPtnVie(p.getPtnVie() - damage);
            this.setPointsAction(this.getPointsAction() - 40);
        }
    }
    @Override
    public String toString(){

        return "Sorcier";
    }
}
