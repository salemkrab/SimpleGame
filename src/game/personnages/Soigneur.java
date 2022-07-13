package game.personnages;

public class Soigneur extends Personne {
    public Soigneur(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void attaquer(Personne p) {
        p.setPtnVie(p.getPtnVie()-10);
        this.setPtnVie(this.getPtnVie()+10);
    }
}
