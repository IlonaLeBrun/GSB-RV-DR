package fr.gsb.rv.vues;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import fr.gsb.rv.controleurs.ControleurAuthentification;
import fr.gsb.rv.modeles.ModeleGSB;
import fr.gsb.rv.controleurs.ControleurBoutonVoirVisiteur;
import fr.gsb.rv.controleurs.ControleurSelectionMois;

public class VueSelectionMois extends JDialog {

	ControleurSelectionMois controleur ;
	
	private String matriculeVisiteur ;
	
	private JLabel matricule = new JLabel() ;
	private JLabel client = new JLabel() ;
	private JLabel restau = new JLabel() ;
	private JButton bValider = new JButton("Valider") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	
	String mois[] = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novemvre","Décembre"};
	JComboBox listeMois = new JComboBox(mois);
	JComboBox listeAnnees = new JComboBox();
	
	
	
	
	public JComboBox getListeMois() {
		return listeMois;
	}



	public void setListeMois(JComboBox listeMois) {
		this.listeMois = listeMois;
	}



	public JComboBox getListeAnnees() {
		return listeAnnees;
	}



	public void setListeAnnees(JComboBox listeAnnees) {
		this.listeAnnees = listeAnnees;
	}



	public VueSelectionMois(VueGSB vueParente, int row){
		// Appel du constructeur de la super-classe
		//	Troisième argument : true pour indiquer que la boîte de dialogue est modale 
		super(vueParente," Sélectionner le mois et l'année des rapports de visite à visionner ",true) ;
		this.matriculeVisiteur = ModeleGSB.getModele().getVisiteurs().get( row ).getMatricule() ;
		
		
		GregorianCalendar aujourdhui = new GregorianCalendar ();
		int anneeCourante = aujourdhui.get(Calendar.YEAR);
		for(int annee = anneeCourante; annee >= anneeCourante-5; annee --){
			
			this.listeAnnees.addItem(""+ annee);
		}
		
		
		
		// Crée le formulaire de saisie
		this.creerInterfaceUtilisateur() ;
		
		// Redimensionne la boîte de dialogue (dimensions adaptées aux composants qui s'y trouvent)
		this.matricule.setText( ModeleGSB.getModele().getVisiteurs().get(row).getMatricule() + "" );
		this.pack() ;
		
		// Positionne la boîte de dialogue au centre de l'écran
		this.setLocationRelativeTo(null) ;
		
		// Empêche le redimensionnement par l'utilisateur
		this.setResizable(false);
		
		// Crée le controleur associé et lui indique que le vue qui lui
		// est associée est elle-même
		this.controleur = new ControleurSelectionMois(this, this.matriculeVisiteur) ;
		
		// Affiche la boîte de dialogue
		
		this.setVisible(true) ;
		
	}
	

	
	/** Créer l'interface utilisateur
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxMatricule = Box.createHorizontalBox() ;
		Box boxVisiteur = Box.createHorizontalBox() ;
		Box boxSelection = Box.createHorizontalBox() ;
		Box boxAction = Box.createHorizontalBox() ;
		  
		
		boxSelection.add( Box.createHorizontalStrut(60)) ;
		boxSelection.add( new JLabel("Saisir vote date : ")) ;
		boxSelection.add( Box.createHorizontalStrut(60)) ;
		boxSelection.add( Box.createHorizontalStrut(60)) ;
		
		boxAction.add( Box.createHorizontalGlue()) ;
		boxAction.add( this.bValider);
		boxAction.add( Box.createHorizontalStrut(10));
		boxAction.add( this.bAnnuler);
		boxAction.add( Box.createHorizontalGlue()) ;		
	
		
		boxSelection.add( Box.createHorizontalStrut(30)) ;
		boxSelection.add( new JLabel("Mois: ")) ;
		boxSelection.add( Box.createHorizontalStrut(30)) ;
		boxSelection.add( listeMois);
		boxSelection.add( Box.createHorizontalStrut(30)) ;
			
		
		boxSelection.add( Box.createHorizontalStrut(30)) ;
		boxSelection.add( new JLabel("Années: ")) ;
		boxSelection.add( Box.createHorizontalStrut(30)) ; 
		boxSelection.add( Box.createHorizontalStrut(30)) ;
		boxSelection.add( listeAnnees);
		
		
		boxPrincipale.add( Box.createVerticalStrut(30)) ;
		boxPrincipale.add( boxMatricule);
		boxPrincipale.add( Box.createVerticalStrut(30)) ;
		boxPrincipale.add( boxVisiteur);
		boxPrincipale.add( Box.createVerticalStrut(30)) ;
		boxPrincipale.add( boxSelection);
		boxPrincipale.add( Box.createVerticalStrut(30)) ;
		boxPrincipale.add(boxAction);
		boxPrincipale.add( Box.createVerticalStrut(30)) ;
		
		
		conteneur.add(boxPrincipale) ;
		
	}

	public JButton getbValider() {
		return bValider;
	}


	public JButton getbAnnuler() {
		
		return bAnnuler;
	}


	public void initialiser() {
		// TODO Auto-generated method stub
		
	}

}
