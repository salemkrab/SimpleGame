package game.personnages;

import game.utils.Utils;

public class Soigneur extends Personne {
    public Soigneur(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void attaquer(Personne p) {
        if (this.getPointsAction()>0) {
            int damage = Utils.randInt(5,20);
            p.setPtnVie(p.getPtnVie() - damage);
            this.setPtnVie(this.getPtnVie() + 10);
            if (this.getPtnVie() > 100) this.setPtnVie(100);

            this.setPointsAction(this.getPointsAction() - 30);
        }
    }
}
