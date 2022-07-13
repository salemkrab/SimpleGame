package game.personnages;

public abstract class Personne{
    private String nom;
    private String prenom;
    private int pointsAction;
    private int pointsVie;

    protected Personne(String nom, String prenom) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setPointsAction(100);
        this.setPtnVie(100);
    }

    // ---------------------------------------- Setters & getters -----------------
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getPointsAction() {
        return pointsAction;
    }

    public void setPointsAction(int mana) {
        this.pointsAction = mana;
    }

    public int getPtnVie() {
        return pointsVie;
    }

    public void setPtnVie(int ptnVie) {
        this.pointsVie = ptnVie;
    }

    // ---------------------------------------- Setters & getters -----------------


    public abstract void attaquer(Personne p);

}
