/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyBird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
//import javafx.scene.layout.HBox;
//import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author chris
 */
public class Fenetre extends javax.swing.JFrame {

    Joueur j1;
    ArrayList<Obstacle> obstacles;
    Timer timer;
    Font fontPoints;
    public static final long secInNanosec = 1000000000L;
    
    /**
     * Time of one millisecond in nanoseconds.
     * 1 millisecond = 1 000 000 nanoseconds
     */
    public static final long milisecInNanosec = 1000000L;
    
    /**
     * FPS - Frames per second
     * How many times per second the game should update?
     */
    private final int GAME_FPS = 60;
    /**
     * Pause between updates. It is in nanoseconds.
     */
    private final long GAME_UPDATE_PERIOD = secInNanosec / GAME_FPS;
    /**
     * Creates new form Fenetre
     */
    private long lastTime;
        
    public Fenetre() {
        initComponents();
        fontPoints = new Font("Osaka", Font.PLAIN, 36);
        timer = new Timer();
        j1 = new Joueur();
        setTitle("Flap flap!");
        setVisible(true);
        obstacles = new ArrayList<Obstacle>();
        obstacles.add(new Obstacle());
               
              //We start game in new thread.
        Thread gameThread = new Thread() {
            @Override
            public void run(){
                jeuRun();
            }
        };
        gameThread.start();
       
        }
        
    public void jeuRun(){
        
        // This variables are used for calculating the time that defines for how long we should put threat to sleep to meet the GAME_FPS.
        long beginTime, timeTaken, timeLeft;
        
         while(true)
        {
<<<<<<< HEAD
           
=======
>>>>>>> parent of e2ee1a5... Delete joueur + clique
            beginTime = System.nanoTime();
            //lastTime = System.nanoTime();
             for(Obstacle ob : obstacles){
                for (HitBox hb : ob.hb) {
                    hb.point.x -= 5;
                }
            }

            j1.velocity += 1;
            j1.hb.point.y += 0.75 * j1.velocity;

            j1.compteur++;
            if (j1.compteur == 80) {
                obstacles.add(new Obstacle());
                j1.compteur = 0;
            }
            if (obstacles.get(0).hb.get(0).point.x < -100) {
                j1.points++;
                obstacles.remove(0);
            }

            if (collision()) {
                dispose();
                timer.cancel();
                SelectJoueur sj = new SelectJoueur();
                try {
                    if (sj.entreeTop10(j1.points)) {
                        JFrame newJf = new JFrame("Top score!");
                        newJf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        newJf.setSize(400, 300);
                        try {
                            newJf.add(new NewScore(newJf, j1.points));
                            newJf.setVisible(true);
                        } catch (Exception ex) {
                            Logger.getLogger(MenuIntro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JFrame nouveauJf = new JFrame("Scores");
                        nouveauJf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        nouveauJf.setSize(475, 600);
                        try {
                            nouveauJf.add(new MenuScore(nouveauJf));
                        } catch (IOException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        nouveauJf.setVisible(true);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            repaint();
            // Here we calculate the time that defines for how long we should put threat to sleep to meet the GAME_FPS.
            timeTaken = System.nanoTime() - beginTime;
            timeLeft = (GAME_UPDATE_PERIOD - timeTaken) / milisecInNanosec; // In milliseconds
            // If the time is less than 10 milliseconds, then we will put thread to sleep for 10 millisecond so that some other thread can do some work.
            if (timeLeft < 10) 
                timeLeft = 10; //set a minimum
            try {
                 //Provides the necessary delay and also yields control so that other thread can do work.
                 Thread.sleep(timeLeft);
            } catch (InterruptedException ex) {
                System.out.println("pas de pause");
            }
        }
    }
//        timer.schedule(new TimerTask() {
//        @Override
//        public void run() {
//          // Your database code here
//          
//          for(Obstacle ob : obstacles){
//            for (HitBox hb : ob.hb){
//                hb.point.x -=7;
//            }
//        }
//          
//          j1.velocity += 1;
//           j1.hb.point.y += 0.75 * j1.velocity;
//           
//            repaint();
//            j1.compteur ++;
//            if (j1.compteur == 80){
//               obstacles.add(new Obstacle());
//               j1.compteur = 0;
//            }
//            if(obstacles.get(0).hb.get(0).point.x < -100){
//                j1.points ++;
//                obstacles.remove(0);
//            }
//            
//            if (collision()){
//                dispose();
//                timer.cancel();
//                SelectJoueur sj = new SelectJoueur();
//              try {
//                if (sj.entreeTop10(j1.points))
//                {
//                    JFrame newJf = new JFrame("Top score!");
//                    newJf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    newJf.setSize(400, 300);
//                    try {
//                        newJf.add(new NewScore(newJf, j1.points));
//                        newJf.setVisible(true);
//                    } catch (Exception ex) {
//                        Logger.getLogger(MenuIntro.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                else
//                {
//                    JFrame nouveauJf = new JFrame("Scores");
//                    nouveauJf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    nouveauJf.setSize(475, 600);
//                  try {
//                      nouveauJf.add(new MenuScore(nouveauJf));
//                  } catch (IOException ex) {
//                      Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
//                  }
//                  nouveauJf.setVisible(true);
//                    }
//                  } catch (Exception ex) {
//                      Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
//                  }
//            }
//          }
//        
//      }, 16,16);

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauJeu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        panneauJeu.setPreferredSize(new java.awt.Dimension(1200, 720));
        panneauJeu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panneauJeuMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panneauJeuLayout = new javax.swing.GroupLayout(panneauJeu);
        panneauJeu.setLayout(panneauJeuLayout);
        panneauJeuLayout.setHorizontalGroup(
            panneauJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1162, Short.MAX_VALUE)
        );
        panneauJeuLayout.setVerticalGroup(
            panneauJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panneauJeu, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panneauJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panneauJeuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panneauJeuMousePressed

        // TODO add your handling code here:
        j1.velocity -= 22;
        if (j1.velocity < -12){
            j1.velocity = -12;
        }
        else if(j1.velocity > 39){
            j1.velocity = 40;
        }
      
    }//GEN-LAST:event_panneauJeuMousePressed

    @Override
    public void paint (Graphics g){

        Graphics g2;            //dessiner dans un autre graphique pour éviter que ca flash
        Dimension d = getSize();//
        Image offImage; 
        
        offImage = createImage(d.width, d.height);
        g2=offImage.getGraphics();
        
        super.paint(g2);
        g2.setColor(Color.green);
        //dessin du sol
        g2.fillRect(panneauJeu.getX(), panneauJeu.getHeight()-50, panneauJeu.getWidth() , panneauJeu.getHeight()-50);
        //dessin du joueur
        g2.fillRect(j1.position.x + j1.hb.point.x, j1.position.y + j1.hb.point.y, j1.hb.largeur, j1.hb.hauteur);
        //dessin d'un obstacle
        g2.setColor(Color.red);
        for(Obstacle ob : obstacles){
            for (HitBox hb : ob.hb){
                g2.fillRect(hb.point.x, hb.point.y, hb.largeur, hb.hauteur);
            }
        }
        g2.setFont(fontPoints);
        g2.setColor(Color.black);
        g2.drawString("Points :" + j1.points, 500, 80);
        
        g.drawImage(offImage,0 ,0, this);
    }
    
    public boolean collision(){       

        for (int i = 0; i < obstacles.get(0).hb.size(); i++){
            if(j1.hb.point.x + j1.hb.largeur > obstacles.get(0).hb.get(i).point.x){
                if(j1.hb.point.y < obstacles.get(0).hb.get(i).point.y + obstacles.get(0).hb.get(i).hauteur &&
                   j1.hb.point.y + j1.hb.hauteur > obstacles.get(0).hb.get(i).point.y){
                      return true;
                }
            }
            
        }
        if(j1.hb.point.y + j1.hb.hauteur > panneauJeu.getHeight()-50){
            return true;
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panneauJeu;
    // End of variables declaration//GEN-END:variables
}