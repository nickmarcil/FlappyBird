/*
 *   Classe pour acceder la base de donn�es
 *   Auteur : Domingo Palao
 *   Cr�ation : Fevrier 2013
 *   
 *   Historique de modifications
 *   Date	  Personne       Modification
 *    
 */
package flappyBird;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseTools {
	private String url;
	private String username;
	private String password;
	private String driver;

	/*
	 * Constructeur par default
	 */
	public DatabaseTools() {

		/* Initialisation des variables d'environnement */
		this.url = "jdbc:mysql://127.0.0.1:3306/flappybird";
		this.username = "root";
		this.password = "";
		this.driver = "com.mysql.jdbc.Driver";
	}

	/*
	 * Constructeur avec parametres
	 */
	public DatabaseTools(String url, 
			             String username, 
			             String password,
			             String driver) {

		/* Initialisation des variables d'environnement */
		this.url = url;
		this.username = username;
		this.password = password;
		this.driver = driver;
	}

	/*
	 * Cette methode nous permet de creer une connexion a la base de donnees
	 */
	public Connection createConnection() {
		Connection con = null;
		System.err.println("***** BEGIN createConnection()");
		try {
			/* Instantiation du driver de la base de donn�es */
			Class.forName(driver).newInstance();
			/* La connection avec username et password */
			con = DriverManager.getConnection(this.url, this.username,
					this.password);
		} catch (Exception e) {
			System.err
					.println("Erreur dans createConnection " + e.getMessage());
			System.err.println("url = " + url + " username = " + username
					+ " password = " + password);
		}
		System.err.println("***** END createConnection()");
		return con;
	}

	public boolean executeSQL(Connection con, String sqlString)
			throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		boolean executeOk = false;

		System.err.println("***** BEGIN executeSQL()");
		try {
			// Connect to the database
			stmt = con.createStatement();
			// Creating the SQL string
			stmt.execute(sqlString);
			executeOk = true;
		} catch (Exception e) {
			System.err.println("***** Database error at executeSQL() : "
					+ e.getMessage());
		} finally { // Clossing all the connections
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		/* Sending the messago to the trace */
		System.err.println("***** END executeSQL()");
		return executeOk;
	}// fin executeSQL
}// fin de la classe