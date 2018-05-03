package fr.gsb.rv.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.rv.entites.RapportVisite;

public class ModeleListeRV extends AbstractTableModel {

	private List<RapportVisite> lesRapportsVisite ;
	private final String[] entetes = { "Numero de rapport" , "Bilan" } ;
	
	
	public ModeleListeRV(int mois, int annee, String matriculeVisiteur ) {
		super();
		lesRapportsVisite = ModeleGSB.getModele().getRapportsVisite(mois, annee, matriculeVisiteur);
	}


	public List<RapportVisite> getLesRapportsVisite() {
		return lesRapportsVisite;
	}


	public void setLesRapportsVisite(List<RapportVisite> lesRapportsVisite) {
		this.lesRapportsVisite = lesRapportsVisite;
	}


	public String[] getEntetes() {
		return entetes;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesRapportsVisite.size();
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length ;
	}

	@Override
	public String getColumnName(int column) {
		return entetes[ column ] ;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch( columnIndex ){
		case 0 : 
			return lesRapportsVisite.get(rowIndex).getNumero();
		case 1 :
			return lesRapportsVisite.get(rowIndex).getBilan();
		default:
			return null;
		}
	}
}
