package fr.gsb.rv.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import fr.gsb.rv.vues.VueListeRV;



public class ControleurListeRV implements ActionListener {

	
	private VueListeRV vue ;
	
	/** Constructeur
	 * @param vueRapportVisite Vue associée
	 */
	public ControleurListeRV(VueListeRV vueRapportVisite){
		super() ;
		
		this.vue = vueRapportVisite ;
		this.enregistrerEcouteur() ;
	}

	public void actionPerformed1(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
//	 */
	private void enregistrerEcouteur(){
		
		this.vue.getbAnnuler().addActionListener( this );
		this.vue.getbValider().addActionListener( this );

	}

	public void actionPerformed11(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getbAnnuler() ){
			this.vue.dispose() ;
		}
		else if( sourceEvenement == this.vue.getbValider() ){
			System.out.println( "Controleur ListeRV -----> Affichage des rapports de visite" ) ;
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getbAnnuler() ){
			System.out.println( "Controleur ListeRV -----> Bouton Annuler actionné" );
			this.vue.dispose() ;
		}
		else if( sourceEvenement == this.vue.getbValider() ){
			System.out.println( "Controleur ListeRV -----> Bouton Valider actionné"  );

		}

	}
}