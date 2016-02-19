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
    
     public Point p1, p2;

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
    public HitBox(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    
}
