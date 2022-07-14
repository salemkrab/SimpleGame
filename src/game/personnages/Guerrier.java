package game.personnages;

import game.armes.Arme;
import game.utils.Utils;

public class Guerrier extends Personne {
    private Arme arme;
    public Guerrier(String nom, String prenom, Arme arme) {
        super(nom, prenom);
        this.setArme(arme);
    }

    @Override
    public void attaquer(Personne p) {
        if (this.getPointsAction()>0) {
//            int degats = this.getArme().getDegats();
            int damage = Utils.randInt(5,20);
            p.setPtnVie(p.getPtnVie() - damage);

            this.setPointsAction(this.getPointsAction() - 20);
        }
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }
}
