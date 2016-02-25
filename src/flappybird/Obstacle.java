/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Obstacle {
    ArrayList<HitBox> hb;
    

    /**
     * constructeur sans paramètre
     */
    public Obstacle() {
       hb =  new ArrayList<HitBox>();
       hb.add(new HitBox(new Point(1300, 0), 100, 180));
       hb.add(new HitBox(new Point(1300, 370), 100, 180));
    }
}
