package fr.gsb.rv.vues;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

import fr.gsb.rv.controleurs.ControleurAuthentification;
import fr.gsb.rv.modeles.ModeleGSB;
import fr.gsb.rv.modeles.ModeleListePraticien;
import fr.gsb.rv.modeles.ModeleListeRV;
import fr.gsb.rv.controleurs.ControleurBoutonVoirVisiteur;
import fr.gsb.rv.controleurs.ControleurListeRV;
import fr.gsb.rv.controleurs.ControleurSelectionMois;

public class VueListeRV extends JDialog {

	ControleurListeRV controleur ;
	
	private JButton bValider = new JButton("Valider") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	private String matriculeVisiteur ;
	private int annee  ;
	private int mois ;
	private ModeleListeRV modeleTabRv = new ModeleListeRV(annee, annee, matriculeVisiteur);
	private JTable tabRv ;

	private Object bConnecter;
	
	
	public VueListeRV(VueGSB vueParente, int annee, int mois, String matriculeVisiteur){
		// Appel du constructeur de la super-classe
		//	Troisième argument : true pour indiquer que la boîte de dialogue est modale 
		super(vueParente," Consulter la liste des rapports de visite ",true) ;
		this.annee = annee ;
		this.mois = mois ;
		this.matriculeVisiteur = matriculeVisiteur ;
		modeleTabRv= new ModeleListeRV(mois, annee, matriculeVisiteur) ;
		this.creerInterfaceUtilisateur() ;

		
		System.out.println(  "VueListeRV -----> Mois choisi : " + mois + ", Année choisie : " + annee + " et Matricule du visiteur : " + matriculeVisiteur );
	

		// Crée le formulaire de saisie
		this.creerInterfaceUtilisateur() ;
		
		// Redimensionne la boîte de dialogue (dimensions adaptées aux composants qui s'y trouvent)
		//this.matricule.setText( ModeleGSB.getModele().getVisiteurs().get(row).getMatricule() + "" );
		this.pack() ;
		
		// Positionne la boîte de dialogue au centre de l'écran
		this.setLocationRelativeTo(null) ;
		
		// Empêche le redimensionnement par l'utilisateur
		this.setResizable(false);
		
		// Crée le controleur associé et lui indique que le vue qui lui est associée est elle-même
		this.controleur = new ControleurListeRV(this) ;
		
		// Affiche la boîte de dialogue
		
		this.setVisible(true) ;
		
	}


	/** Créer l'interface utilisateur
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createVerticalBox() ;
		Box boxRV = Box.createHorizontalBox() ;
		Box boxAction = Box.createHorizontalBox() ;
		

		boxEtiquette.add( Box.createHorizontalStrut(60)) ;
		boxEtiquette.add( new JLabel("Liste des Rapports de Visite ")) ;
		boxEtiquette.add( Box.createHorizontalStrut(60)) ;
		
		this.tabRv = new JTable( modeleTabRv );
		this.tabRv.setRowHeight( 30 );
		JScrollPane spPraticien = new JScrollPane( this.tabRv );
		spPraticien.setPreferredSize( new Dimension( 1090 , 420 ));
		
		boxRV.add(spPraticien);
	
		
		this.add( boxPrincipale ) ;
		
		boxAction.add( Box.createHorizontalGlue()) ;
		boxAction.add(this.bValider);
		boxAction.add(Box.createHorizontalStrut(10));
		boxAction.add(this.bAnnuler);
		boxAction.add( Box.createHorizontalGlue()) ;
		
		boxPrincipale.add(boxRV);
		boxPrincipale.add( Box.createVerticalStrut(30)) ;
		boxPrincipale.add(boxAction);
		boxPrincipale.add( Box.createVerticalStrut(30)) ;
		
		
		conteneur.add(boxPrincipale) ;
		
		Dimension dimensionBouton = this.bValider.getPreferredSize() ;
		
		this.bAnnuler.setPreferredSize(dimensionBouton) ;
		this.bAnnuler.setMaximumSize(dimensionBouton) ;
		this.bAnnuler.setMinimumSize(dimensionBouton) ;
		
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
		
	}

	public JButton getbValider() {
		return bValider;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}

}
