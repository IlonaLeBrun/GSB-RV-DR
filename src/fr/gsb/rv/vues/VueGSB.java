package fr.gsb.rv.vues;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import fr.gsb.rv.controleurs.ControleurGSB;

public class VueGSB extends JFrame {

	// Contrôleur associé à la vue
	private ControleurGSB controleur ;					
	
	// Les différents menus
	private JMenu menuFichier = new JMenu("Fichier") ;	
	private JMenu menuAide = new JMenu("Aide") ;
	
	private JMenu menuPraticiens = new JMenu("Praticien hesitant") ;
	private JMenu menuVisiteurs = new JMenu("Visiteurs") ;
	
	// Les items du menu
	private JMenuItem itemSeConnecter = new JMenuItem("Se connecter") ;			
	private JMenuItem itemSeDeconnecter = new JMenuItem("Se déconnecter") ;
	private JMenuItem itemQuitter = new JMenuItem("Quitter") ;

	private JMenuItem itemVisualiserPraticiens = new JMenuItem("Lister") ;
	private JMenuItem itemVisualiserVisiteurs = new JMenuItem("Lister") ;

	private JMenuItem itemApropos = new JMenuItem("À Propos...") ;
	
	// Les vues
	private CardLayout clVues = new CardLayout(0,0) ;
	private VueAccueil vueAccueil = new VueAccueil() ;
	private VueListePraticiens vueListePraticiens = new VueListePraticiens() ;
	private VueListeVisiteurs vueListeVisiteurs = new VueListeVisiteurs() ;

	
	
	public VueGSB(){
		super() ;
		
		// Donne un titre à la fenêtre
		this.setTitle("GSB") ;
		
		// Définit le largeur et la hauteur de la fenêtre
		this.setSize(1300,500) ;
		
		// Positionne la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null) ;
		
		// Empêche l'utilisateur de fermer la fenêtre à l'aide de la croix
		// qui se trouve en haut à droite
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		// Empêche le redimensionnement par l'utilisateur
		this.setResizable(false);
		
		// Crée la barre de menus
		this.creerBarreMenus();
		
		// Bascule la barre de menus dans le "Mode non connecte"
		this.setBarreMenusModeDeconnecte();
		
		
		// Mise en place des vues (implémenter le gestionnaire d'agencement des vues)
		//- QUESTION 1
		
		Container conteneur = this.getContentPane();
		conteneur.setLayout( clVues );
		
		conteneur.add( this.vueAccueil , "Accueil" );
		conteneur.add( this.vueListePraticiens , "ListePraticiens" );
		conteneur.add( this.vueListeVisiteurs , "ListeVisiteurs" );
		
		clVues.show( conteneur , "Accueil" );
		
		
		// Afficher la vue accueil
		// L'INSTRUCTION CI-DESSOUS ET À DÉCOMMENTER UNE FOIS LE GESTIONNAIRE D'AGENCEMENT IMPLÉMENTÉ
		//this.clVues.show(conteneur,"Accueil") ;
		
		// Crée le controleur associé et lui indique que le vue qui lui
		// est associée est elle-même
		this.controleur = new ControleurGSB(this) ;
		
		// Affiche la fenêtre
		this.setVisible(true) ;
	}
	
	private void creerBarreMenus(){
		
		// Crée une barre de menu vide
		JMenuBar barreMenus = new JMenuBar() ;
		
		// Ajoute les items de menu dans leur menu respectif
		this.menuFichier.add(this.itemSeConnecter) ;
		this.menuFichier.add(this.itemSeDeconnecter) ;
		this.menuFichier.add( new JSeparator() ) ;
		this.menuFichier.add(this.itemQuitter) ;
		
		this.menuPraticiens.add( this.itemVisualiserPraticiens ) ;
		this.menuVisiteurs.add( this.itemVisualiserVisiteurs ) ;
		//this.menuRestaurants.add( this.itemVisualiserRestaurants ) ;
		
		this.menuAide.add(this.itemApropos) ;
		
		// Ajoute les menus dans la barre de menu
		barreMenus.add(menuFichier) ;
		
		barreMenus.add(menuPraticiens) ;
		barreMenus.add(menuVisiteurs) ;
//		barreMenus.add(menuRestaurants) ;
		
		barreMenus.add(menuAide) ;
		
		// Ajoute la barre de menus à la fenêtre
		this.setJMenuBar(barreMenus) ;
	}
	
	public void setBarreMenusModeConnecte(){
		// Désactive l'item de menu "Se connecter"
		this.itemSeConnecter.setEnabled(false) ;
		
		// Active l'item de menu "Se déconnecter"
		this.itemSeDeconnecter.setEnabled(true) ;
		
		
		// Active les menus "métiers"
		this.menuPraticiens.setEnabled(true) ;
		this.menuVisiteurs.setEnabled(true) ;

	}
	
	public void setBarreMenusModeDeconnecte(){
		
		// Active l'item de menu "Se connecter"
		this.itemSeConnecter.setEnabled(true) ;
		
		// Désactive l'item de menu "Se déconnecter"
		this.itemSeDeconnecter.setEnabled(false) ;
		
		// Désactive les menus "métiers"
		this.menuPraticiens.setEnabled(false) ;
		this.menuVisiteurs.setEnabled(false) ;

		
	}
	
	public void changerVue(String nomVue){
		// - QUESTION 2
		Container conteneur = this.getContentPane();
		clVues.show( conteneur , nomVue );
	}

	public ControleurGSB getControleur() {
		return controleur;
	}

	public JMenuItem getItemSeConnecter() {
		return itemSeConnecter;
	}

	public JMenuItem getItemSeDeconnecter() {
		return itemSeDeconnecter;
	}

	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	public JMenuItem getItemApropos() {
		return itemApropos;
	}

	public VueAccueil getVueAccueil() {
		return vueAccueil;
	}

	public VueListePraticiens getVueListePraticiens() {
		return vueListePraticiens;
	}

	public JMenuItem getItemVisualiserVisiteurs() {
		return itemVisualiserVisiteurs;
	}

	public void setItemVisualiserVisiteurs(JMenuItem itemVisualiserVisiteurs) {
		this.itemVisualiserVisiteurs = itemVisualiserVisiteurs;
	}
	
	public JMenuItem getItemVisualiserPraticiens() {
		return itemVisualiserPraticiens;
	}

	public void setItemVisualiserPraticiens(JMenuItem itemVisualiserPraticiens) {
		this.itemVisualiserPraticiens = itemVisualiserPraticiens;
	}

	public CardLayout getClVues() {
		return clVues;
	}

	
	
}
