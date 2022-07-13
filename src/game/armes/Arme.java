package game.armes;

public abstract class Arme {
    private String nomArme;
    private int degats;

    public Arme(String nomArme, int degats) {
        this.setNomArme(nomArme);
        this.setDegats(degats);
    }

    public String getNomArme() {
        return nomArme;
    }
    public void setNomArme(String nomArme) {
        this.nomArme = nomArme;
    }
    public int getDegats() {
        return degats;
    }
    public void setDegats(int degats) {
        this.degats = degats;
    }
}