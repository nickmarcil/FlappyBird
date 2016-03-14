/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyBird;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author chris
 */
public class FlappyBird {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        final JFrame jf = new JFrame("Menu");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(new Dimension(425, 300));
        jf.add(new MenuIntro(jf));
        
        
    }
    
}
