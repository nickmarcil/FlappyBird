/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyBird;

/**
 *
 * @author Nick
 */
public class JoueurBD {
    int joueur_id;
    String joueur_nom;
    int joueur_score;

    public int getJoueur_id() {
        return joueur_id;
    }

    public String getJoueur_nom() {
        return joueur_nom;
    }

    public int getJoueur_score() {
        return joueur_score;
    }

    public void setJoueur_id(int joueur_id) {
        this.joueur_id = joueur_id;
    }

    public void setJoueur_nom(String joueur_nom) {
        this.joueur_nom = joueur_nom;
    }

    public void setJoueur_score(int joueur_score) {
        this.joueur_score = joueur_score;
    }
    
    
}
