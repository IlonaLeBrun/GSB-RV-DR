package fr.gsb.rv.technique;

import java.sql.*;

public class ConnexionBD {

	private static Connection connexion = null ;
	
	private ConnexionBD(){
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			connexion = (Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/gsb" , "root" , "azerty" ) ;
		}
		catch(Exception e){
			System.out.println( "Technique ConnexionBD -----> Erreur constructeur connexion BD" );
		}
	}

	public static Connection getConnexion() {
		
		if( connexion == null ){
			new ConnexionBD() ;
		}
		
		return connexion;
	}
	
	
	
}
