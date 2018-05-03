package fr.gsb.rv.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.rv.modeles.ModeleListePraticien;

public class VueListePraticiens extends JPanel {
	
	private ModeleListePraticien modeleTabPraticiens = new ModeleListePraticien();
	private JTable tabPraticiens ;
	
	public VueListePraticiens(){
		super() ;
		modeleTabPraticiens= new ModeleListePraticien() ;
		this.creerInterfaceUtilisateur() ;
	}
	
	private void creerInterfaceUtilisateur(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Liste des Praticiens" ) ) ;
		
		// - Question 6
		this.tabPraticiens = new JTable( modeleTabPraticiens );
		this.tabPraticiens.setRowHeight( 30 );
		JScrollPane spPraticien = new JScrollPane( this.tabPraticiens );
		spPraticien.setPreferredSize( new Dimension( 1090 , 420 ));
		
		boxTable.add(spPraticien);
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}

	public ModeleListePraticien getModeleTabPraticiens() {
		return modeleTabPraticiens;
	}

	public JTable getTabPraticiens() {
		return tabPraticiens;
	}
	
}