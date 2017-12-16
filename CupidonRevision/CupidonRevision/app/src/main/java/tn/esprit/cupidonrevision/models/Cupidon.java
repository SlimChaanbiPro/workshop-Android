package tn.esprit.cupidonrevision.models;

/**
 * Created by wael on 16/10/2017.
 */

public class Cupidon {

    String nom_fille;
    String nom_garcon;
    int score;

    public Cupidon() {
    }

    public String getNom_fille() {
        return nom_fille;
    }

    public void setNom_fille(String nom_fille) {
        this.nom_fille = nom_fille;
    }

    public String getNom_garcon() {
        return nom_garcon;
    }

    public void setNom_garcon(String nom_garcon) {
        this.nom_garcon = nom_garcon;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
