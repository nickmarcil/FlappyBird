/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 *
 * @author chris
 */
public class FlappyBird {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        final JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(new Dimension(425, 300));
        jf.add(new MenuIntro(jf));
        
        
    }
    
}
