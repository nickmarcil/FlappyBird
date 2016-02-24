package flappybird;


import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class HitBox {
    
     public Point point;
     public int largeur;
     public int hauteur;

    /**
     * constructeur sans paramètre
     */
    public HitBox() {
       
    }

    /**
     * constructeur avec paramètre
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public HitBox(Point p1, int largeur, int hauteur) {
        this.point = p1;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    
    
}
