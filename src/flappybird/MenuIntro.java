/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import sun.java2d.d3d.D3DRenderQueue;

/**
 *
 * @author Nick
 */
public class MenuIntro extends javax.swing.JPanel {
    /**
     * Creates new form MenuIntro
     */
    ImageIcon img;
    
    BufferedImage image;
    BufferedImage imageOiseau;
    int birdX = 0;
    int birdY = 0;
    int rotation = 0;
    
    public MenuIntro(final JFrame jf) throws IOException {
        initComponents();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Rotation information
                rotation += 4;
                if (rotation > 360)
                    rotation = 0;
                repaint();
            }
        },16, 16);
        image = ImageIO.read(new File("src/images/background.jpg"));
        imageOiseau = ImageIO.read(new File("src/images/bird.gif"));
        jf.add(this);
        jf.setVisible(true);
        
        lblCommencer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jf.setVisible(false);
            }
            

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCommencer = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tiger Rag LET", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Flappy bird");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jLabel2.setText("Afficher les scores");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jLabel3.setText("Quitter");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        lblCommencer.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        lblCommencer.setText("Commencer une partie");
        lblCommencer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCommencerMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCommencerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCommencer)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(1, 1, 1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel3)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblCommencer)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
 
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void lblCommencerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCommencerMousePressed
        Fenetre f = new Fenetre();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblCommencerMousePressed

    private void lblCommencerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCommencerMouseEntered
        birdX = 20;
        birdY = 80;
    }//GEN-LAST:event_lblCommencerMouseEntered

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        birdX = 60;
        birdY = 145;
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        birdX = 120;
        birdY = 210;
    }//GEN-LAST:event_jLabel3MouseEntered

    public void paintComponent(Graphics g){
        double rotationRequired = Math.toRadians (rotation);
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, imageOiseau.getWidth()/2, imageOiseau.getHeight()/2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        // Drawing the rotated image at the required drawing locations
          g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
          g.drawImage(op.filter(imageOiseau, null), birdX, birdY,50,50, null);

      }

      public void paint (Graphics g){
        Graphics g2;            //dessiner dans un autre graphique pour éviter que ca flash
        Dimension d = getSize();//
        Image offImage;
        
        offImage = createImage(d.width, d.height);
        g2=offImage.getGraphics();
        
        
        super.paint(g2);
        g.drawImage(offImage,0 ,0, this);
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCommencer;
    // End of variables declaration//GEN-END:variables
}
