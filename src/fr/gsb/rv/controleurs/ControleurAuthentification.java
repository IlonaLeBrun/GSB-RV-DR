package fr.gsb.rv.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.gsb.rv.entites.Utilisateur;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGSB;
import fr.gsb.rv.technique.Session;
import fr.gsb.rv.vues.VueAuthentification;
import fr.gsb.rv.vues.VueGSB;

public class ControleurAuthentification implements ActionListener {

	
	private VueAuthentification vue ;
	
	/** Constructeur
	 * @param vue Vue associée
	 */
	public ControleurAuthentification(VueAuthentification vue){
		super() ;
		
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		
		// VOTRE CODE : 
		// Enregistrer l'écouteur du bouton "Se connecter"
		// Enregistrer l'écoureur du bouton "Annuler"
		
		this.vue.getbConnecter().addActionListener( this );
		this.vue.getbAnnuler().addActionListener( this ) ;
	}

	
	// VOTRE CODE :
	// Méthode de traitement des événements
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getbConnecter() ){
			
			String login = this.vue.getTfLogin().getText() ;
			String mdp = new String(this.vue.getPfMdp().getPassword()) ;
			
			
			Visiteur unVisiteur = ModeleGSB.getModele().seConnecter(login, mdp) ;
			
		
			if( unVisiteur != null ){
				JOptionPane.showMessageDialog(this.vue, "Connexion réussie.","Authentification",JOptionPane.INFORMATION_MESSAGE) ;
				System.out.println( "Controleur Authentification -----> Connexion Ok : " + unVisiteur ) ;
				Session.ouvrir( unVisiteur );
				this.vue.dispose() ;
				VueGSB vueParente = (VueGSB) this.vue.getParent() ;
				vueParente.setBarreMenusModeConnecte() ;
				
			}
			else {
				JOptionPane.showMessageDialog(this.vue, "Connexion refusée.","Authentification",JOptionPane.ERROR_MESSAGE) ;
				System.out.println( "Controleur Authentification -----> Connexion Nok " ) ;
				this.vue.initialiser() ;
			}
			
		}
			
		else if( sourceEvenement == this.vue.getbAnnuler() ){
			this.vue.dispose() ;
		}
		
	}
	
}