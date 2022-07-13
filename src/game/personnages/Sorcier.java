package game.personnages;

public class Sorcier extends Personne {
    public Sorcier(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void attaquer(Personne p) {
        p.setPtnVie(p.getPtnVie()-20);
        this.setPointsAction(this.getPointsAction()-40);

    }
}
