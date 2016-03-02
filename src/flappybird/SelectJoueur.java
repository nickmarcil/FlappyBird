/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyBird;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nick
 */
public class SelectJoueur {
    
    public void ajouterJoueur(String nom, int score) throws Exception
    {
        int nbJoueur = getNbJoueur() + 1;
        Connection con;
        DatabaseTools databaseTools = new DatabaseTools();
        //Statement stmt = null;
        
        con = databaseTools.createConnection();
        try 
        {
            //stmt = con.createStatement();
            String oneRequete = "INSERT INTO `joueur` (`joueur_id`, `joueur_nom`, `joueur_score`) VALUES ('" + nbJoueur + "', '" + nom + "', '" + score + "')";
            databaseTools.executeSQL(con, oneRequete);
            
        } catch (Exception e) {
            System.err.println("Erreur dans ajouterJoueur");
        }
    }
    
    public int getNbJoueur() throws SQLException
    {
        int nbJoueur = 0;
        
         /* Sending the message to the trace */
        System.err.println("***** BEGIN getNbJoueur()");

        Connection con;
        Statement stmt = null;
        ResultSet rs = null;

        DatabaseTools databaseTools = new DatabaseTools();
        con = databaseTools.createConnection();

        try {
            stmt = con.createStatement();
            String sqlString = "SELECT COUNT(*) FROM joueur;";
            rs = stmt.executeQuery(sqlString);

            rs.next();
            nbJoueur = rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("***** Database error at getNbJoueur: "
                    + e.getMessage());
        } //End catch
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        /* Sending the messago to the trace */
        System.err.println("***** END getNbJoueur()");
        return nbJoueur;
    }
    
    public ArrayList getTop10Joueur() throws Exception {

        System.err.println("***** BEGIN getTop10Joueur()");
        Connection con;
        JoueurBD joueur;
        ArrayList<JoueurBD> top10Joueur = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        DatabaseTools databaseTools = new DatabaseTools();
        con = databaseTools.createConnection();
        try {
            stmt = con.createStatement();
            String oneRequete = "SELECT * FROM joueur ORDER BY -joueur_score LIMIT 10;";
            rs = stmt.executeQuery(oneRequete);
            while (rs.next()) {
                joueur = new JoueurBD();
                joueur.setJoueur_id(rs.getInt("joueur_id"));
                joueur.setJoueur_nom(rs.getString("joueur_nom"));
                joueur.setJoueur_score(rs.getInt("joueur_score"));
                // Adding a Prof to the ArrayList
                top10Joueur.add(joueur);
            }// End while
        } // End try // End try
        catch (SQLException e) {
            System.err.println("***** Database error at getTop10Joueur :"
                    + e.getMessage());
        } // End catch
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }// end finally
        System.err.println("***** END getTop10Joueur()");
        return top10Joueur;
    }// end getTop10Joueur()
}
