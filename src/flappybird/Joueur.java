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
public class Joueur {
    
    HitBox hb;
    Point position;

    /**
     * constructeur sans paramètre
     */
    public Joueur() {
        hb = new HitBox(new Point(0,0), new Point(20,20)); 
        position = new Point(50,50);
    }
    
    
}
