package fr.gsb.rv.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.rv.editeurs.EditeurBoutonVoirVisiteur;
import fr.gsb.rv.modeles.ModeleListeVisiteur;
import fr.gsb.rv.technique.RenduCelluleBouttonVisiteur;
import fr.gsb.rv.technique.RenduCelluleVisiteur;

public class VueListeVisiteurs extends JPanel {
	
	private ModeleListeVisiteur modeleTabVisiteurs = new ModeleListeVisiteur();
	private JTable tabVisiteurs ;
	
	public VueListeVisiteurs(){
		super() ;
		modeleTabVisiteurs= new ModeleListeVisiteur() ;
		this.creerInterfaceUtilisateur() ;
	}
	
	private void creerInterfaceUtilisateur(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Liste des Visiteurs" ) ) ;
		
		this.tabVisiteurs = new JTable( modeleTabVisiteurs );
		this.tabVisiteurs.setRowHeight( 30 );
		
		this.tabVisiteurs.setDefaultRenderer(String.class, new RenduCelluleVisiteur());
		this.tabVisiteurs.setDefaultRenderer(String.class, new RenduCelluleVisiteur());
		this.tabVisiteurs.setDefaultRenderer(String.class, new RenduCelluleVisiteur());
		this.tabVisiteurs.setDefaultRenderer(Integer.class, new RenduCelluleVisiteur());
		this.tabVisiteurs.setDefaultRenderer(String.class, new RenduCelluleVisiteur());

		this.tabVisiteurs.getColumn("").setCellRenderer(new RenduCelluleBouttonVisiteur());		
		this.tabVisiteurs.getColumn( "" ).setCellEditor( new EditeurBoutonVoirVisiteur() );
		
		JScrollPane spVisiteurs = new JScrollPane( this.tabVisiteurs );
		spVisiteurs.setPreferredSize( new Dimension( 1090 , 420 ));
		
		boxTable.add(spVisiteurs);
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}

	public ModeleListeVisiteur getModeleTabVisiteurs() {
		return modeleTabVisiteurs;
	}

	public JTable getTabVisiteurs() {
		return tabVisiteurs;
	}

}
