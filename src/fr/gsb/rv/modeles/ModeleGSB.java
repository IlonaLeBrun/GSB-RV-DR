package fr.gsb.rv.modeles;

import java.awt.RadialGradientPaint;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.gsb.rv.entites.Utilisateur;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.ConnexionBD;
import fr.gsb.rv.technique.DateFr;

import fr.gsb.rv.entites.Praticien;
import fr.gsb.rv.entites.RapportVisite;

public class ModeleGSB {

	// Implémentation du DP Singleton (attribut)
	
	private static ModeleGSB modele = null ;
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>() ;
	
	/** Constructeur
	 * 
	 */
	private ModeleGSB(){
		super() ;
		
		//this.peupler() ;
	}
	
	// Implémentation du DP Singleton (méthode)
	
	public static ModeleGSB getModele(){
		if( modele == null ){
			modele = new ModeleGSB() ;
		}
		return modele ;
	}
	
	
	
	public Visiteur seConnecter( String matricule , String mdp ){
		Visiteur unVisiteur = null ;
		
		Connection connexion = ConnexionBD.getConnexion() ;
		String requete = "select VIS_NOM , VIS_PRENOM from VISITEUR"
					+ " where VIS_MATRICULE = ? " 
					+ " and mdp = ?" ;
		
		try {
			PreparedStatement reqPreparee = ( PreparedStatement ) connexion.prepareStatement( requete ) ;
			reqPreparee.setString( 1 ,  matricule ) ;
			reqPreparee.setString( 2 ,  mdp ) ;
			
			ResultSet resultat = reqPreparee.executeQuery( ) ;
			
			if( resultat.next() ){
				String nom = resultat.getString(1) ;
				String prenom = resultat.getString(2) ;
				
				unVisiteur = new Visiteur() ;
				unVisiteur.setMatricule( matricule ) ;
				unVisiteur.setNom( nom ) ;
				unVisiteur.setPrenom( prenom ) ;
			}	
			
		} catch (SQLException e) {
			System.out.println( "Modèle GSB -----> Problème Requête seConnecter " ) ;
		}

		return unVisiteur ;
	}
	
	public List<Praticien> getPraticiens(){
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		
		Connection connexion = ConnexionBD.getConnexion() ;
		String requete = "select PRA_NUM, PRA_NOM , PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_CODE from PRATICIEN";
		
		PreparedStatement reqPreparee;
		try {
			reqPreparee = ( PreparedStatement ) connexion.prepareStatement( requete );
			ResultSet resultat = reqPreparee.executeQuery( ) ;
			
			while( resultat.next() ){
				
				Praticien unPraticien = new Praticien() ;
				unPraticien.setNum( resultat.getInt("PRA_NUM") ) ;
				unPraticien.setNom( resultat.getString("PRA_NOM") ) ;
				unPraticien.setPrenom( resultat.getString("PRA_PRENOM") );
				unPraticien.setAdresse( resultat.getString("PRA_ADRESSE") );
				unPraticien.setCp( resultat.getString("PRA_CP") );
				unPraticien.setVille( resultat.getString("PRA_VILLE") );
				unPraticien.setCoefNot( resultat.getFloat("PRA_COEFNOTORIETE") );
				unPraticien.setCode( resultat.getString("TYP_CODE") );
				
				lesPraticiens.add( unPraticien ) ;				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(Praticien medecin : lesPraticiens){
//			System.out.println( medecin ) ;
//		}
		
		return lesPraticiens ;
	}
	
	
	public List<Visiteur> getVisiteurs(){
		List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;
		
		Connection connexion = ConnexionBD.getConnexion() ;
		String requete = "select VIS_MATRICULE, VIS_NOM , VIS_PRENOM, VIS_CP, VIS_VILLE from VISITEUR";
		
		PreparedStatement reqPreparee;
		try {
			reqPreparee = ( PreparedStatement ) connexion.prepareStatement( requete );
			ResultSet resultat = reqPreparee.executeQuery( ) ;
			
			while( resultat.next() ){
				
				Visiteur unVisiteur = new Visiteur() ;
				unVisiteur.setMatricule( resultat.getString("VIS_MATRICULE") ) ;
				unVisiteur.setNom( resultat.getString("VIS_NOM") ) ;
				unVisiteur.setPrenom( resultat.getString("VIS_PRENOM") );
				unVisiteur.setCodePostal( resultat.getInt("VIS_CP") );
				unVisiteur.setVille( resultat.getString("VIS_VILLE") );

				
				lesVisiteurs.add( unVisiteur ) ;				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(Visiteur visiteur : lesVisiteurs){
//			System.out.println( visiteur ) ;
//		}
		
		return lesVisiteurs ;
	}
	
	
	
	public List<RapportVisite> getRapportsVisite( int mois , int annee , String matriculeVisiteur ){
		
		System.out.println( "Modèle GSB -----> Mois : " + mois + ", Année : " + annee + " et Matricule du visiteur : " + matriculeVisiteur);
		
		List<RapportVisite> lesRv = new ArrayList<RapportVisite>() ;
		
		Connection connexion = ConnexionBD.getConnexion() ;
		String requete = " select RAP_NUM, RAP_BILAN FROM RAPPORT_VISITE "
				+ "where VIS_MATRICULE = ? " 
				+ "and YEAR(RAP_DATEVISITE) = ? " 
				+ "and MONTH(RAP_DATEVISITE) = ? " ;
		
		PreparedStatement reqPreparee;
		try {
			reqPreparee = ( PreparedStatement ) connexion.prepareStatement( requete );
			reqPreparee.setString( 1 ,  matriculeVisiteur ) ;
			reqPreparee.setInt( 2 ,  annee ) ;
			reqPreparee.setInt( 3 ,  mois ) ;
			ResultSet resultat = reqPreparee.executeQuery( ) ;
			
			
			
			while( resultat.next() ){
				
				RapportVisite unRapportVisite = new RapportVisite() ;
				unRapportVisite.setNumero( resultat.getInt("RAP_NUM") ) ;
				unRapportVisite.setBilan( resultat.getString("RAP_BILAN") ) ;
				
				System.out.println( "Modèle GSB -----> un rapport de visite : " + unRapportVisite ) ;
				
				lesRv.add( unRapportVisite ) ;				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(RapportVisite rapportVisite : lesRv){
//			System.out.println( rapportVisite ) ;
//		}
		
		
		return lesRv ;
	}
	


	/** Rechercher un utilisateur
	 * @param login Nom de connexion de l'utilisateur
	 * @param mdp Mot de passe de l'utilisateur
	 * @return L'utilisateur si trouvé, null dans le cas contraire
	 */
	public Utilisateur getUtilisateur(String login, String mdp){
		
		
		Utilisateur utilisateur = null ;
		int i = 0 ;
		while(i < this.utilisateurs.size() && utilisateur == null){
			if( this.utilisateurs.get(i).getLogin().equals(login) &&
					this.utilisateurs.get(i).getMdp().equals(mdp)){
				utilisateur = this.utilisateurs.get(i) ;
			}
			else {
				i = i + 1 ;
			}
		}
		return utilisateur ;
	}


}
