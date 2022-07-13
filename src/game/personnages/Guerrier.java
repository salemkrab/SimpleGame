package game.personnages;

import game.armes.Arme;

public class Guerrier extends Personne {
    private Arme arme;
    public Guerrier(String nom, String prenom, Arme arme) {
        super(nom, prenom);
        this.setArme(arme);
    }

    @Override
    public void attaquer(Personne p) {
        int degats = this.arme.getDegats();
        p.setPtnVie(p.getPtnVie()-degats);
        this.setPointsAction(this.getPointsAction()-40);
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }
}
