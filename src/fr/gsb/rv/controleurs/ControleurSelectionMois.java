package fr.gsb.rv.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGSB;
import fr.gsb.rv.technique.Session;
import fr.gsb.rv.vues.VueGSB;
import fr.gsb.rv.vues.VueListeRV;
import fr.gsb.rv.vues.VueSelectionMois;


public class ControleurSelectionMois implements ActionListener {

	private String matriculeVisiteur ;
	
	private VueSelectionMois vue ;
	
	/** Constructeur
	 * @param vue Vue associée
	 */
	public ControleurSelectionMois(VueSelectionMois vue, String matriculeVisiteur){
		super() ;
		
		this.vue = vue ;
		this.matriculeVisiteur = matriculeVisiteur ;
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		
		this.vue.getbAnnuler().addActionListener( this );
		this.vue.getbValider().addActionListener( this );

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getbAnnuler() ){
			this.vue.dispose() ;
		}
		else if( sourceEvenement == this.vue.getbValider() ){
			System.out.println( "Controleur GSB -----> Affichage VueListeRV");
			int annee = Integer.parseInt( this.vue.getListeAnnees().getSelectedItem().toString() ) ;
			//System.out.println( "Controleur GSB -----> getbValider Année :" + annee );
			int mois = this.vue.getListeMois().getSelectedIndex() + 1 ;
			//System.out.println( Controleur GSB -----> getbValider Mois :" + mois );
			new VueListeRV(null, annee, mois, matriculeVisiteur );
			
		}
	
	}

}