package fr.gsb.rv.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.gsb.rv.technique.Session;
import fr.gsb.rv.vues.VueAuthentification;
import fr.gsb.rv.vues.VueGSB;

public class ControleurGSB implements ActionListener {
	
	// Vue associée au contrôleur
	private VueGSB vue ;					
	
	public ControleurGSB(VueGSB vue){
		super() ;
		// Mémorise sa vue associée
		this.vue = vue ;
		
		// Se met à l'écoute des items de menu
		this.enregistrerEcouteur();
	}
	
	private void enregistrerEcouteur(){
		// Se met à l'écoute de l'item de menu "Se connecter"
		this.vue.getItemSeConnecter().addActionListener(this) ;
		
		// Se met à l'écoute de l'item de menu "Se déconnecter"
		this.vue.getItemSeDeconnecter().addActionListener(this) ;
		
		// Se met à l'écoute de l'item de menu "Quitter"
		this.vue.getItemQuitter().addActionListener(this) ;
		
		// Se met à l'écoute de l'item de menu "A propos..."
		this.vue.getItemApropos().addActionListener(this) ;
		
		// Se met à l'écoute des items de menus "métiers"
		// - QUESTION 3
		this.vue.getItemVisualiserPraticiens().addActionListener(this);
		this.vue.getItemVisualiserVisiteurs().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Obtient le composant graphique source de l'événement ("clic")
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getItemSeConnecter() ){
			this.seConnecter();
		}
		// Si la source est l'item de menu "Se déconnecter"
		else if( sourceEvenement == this.vue.getItemSeDeconnecter() ){
			this.seDeconnecter();
		}
		// Si la source est l'item de menu "Quitter"
		else if( sourceEvenement == this.vue.getItemQuitter() ){
			this.quitter();
		}
		// Si la source est l'item "À propos", afficher la boîte de dialogue associée
		else if( sourceEvenement == this.vue.getItemApropos() ){
			this.afficherApropos();;
		}
		
		// Si la source est l'item "Lister" du menu "Livreurs", afficher la vue associée
		// - QUESTION 7
		
		else if( sourceEvenement == this.vue.getItemVisualiserPraticiens() ){
			System.out.println( "Controleur GSB -----> Affichage VueListePraticiens" ) ;
			this.vue.changerVue( "ListePraticiens" );;
		}
		
		
		else if( sourceEvenement == this.vue.getItemVisualiserVisiteurs() ){
			System.out.println( "Controleur GSB -----> Affichage VueListeVisiteurs" ) ;
			this.vue.changerVue( "ListeVisiteurs" );;
		}
	
		
	}
	
	private void seConnecter(){
		// Affiche la vue dédiée à la connexion (formulaire de connexion)
		new VueAuthentification(this.vue) ;
	}
	
	private void seDeconnecter(){
		// Demande confirmation à l'utilisateur au moyen d'une boîte de dialogue
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment vous déconnecter ?","Déconnexion",JOptionPane.YES_NO_OPTION) ;
		
		// Si l'utilateur confirme...
		if( reponse == JOptionPane.YES_OPTION ){
				
			// Bascule la barre de menus dans le "Mode Non connecté"
			this.vue.setBarreMenusModeDeconnecte();
			this.vue.changerVue( "Accueil" );;
			Session.fermer();
			JOptionPane.showMessageDialog(null, "Vous êtes maintenant déconnecté.","Déconnexion",JOptionPane.INFORMATION_MESSAGE) ;
		}
		
		//System.out.println( Session.getSession().getLeVisiteur() ) ;
	}
	
	private void quitter(){
		// Demande confirmation à l'utilisateur au moyen d'une boîte de dialogue
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment quitter ?","Quitter",JOptionPane.YES_NO_OPTION) ;
		
		// Si l'utilateur confirme...
		if( reponse == JOptionPane.YES_OPTION ){
			// Met fin à l'application
			System.exit(0) ;
		}
	}
	
	private void afficherApropos(){
		JOptionPane.showMessageDialog(this.vue, "Foody\n2017","À propos...",JOptionPane.INFORMATION_MESSAGE) ;
	}

}