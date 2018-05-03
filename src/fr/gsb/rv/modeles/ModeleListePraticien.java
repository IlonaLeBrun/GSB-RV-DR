package fr.gsb.rv.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.rv.entites.Livreur;
import fr.gsb.rv.entites.Praticien;

public class ModeleListePraticien extends AbstractTableModel {
	
	private List<Praticien> lesPraticiens = ModeleGSB.getModele().getPraticiens() ;
	private final String[] entetes = { "Nom" , "Ville" } ;

	public ModeleListePraticien() {
		super();
	}

	@Override
	public int getRowCount() {
		// - Question 5
		return lesPraticiens.size();
		
	}

	@Override
	public int getColumnCount() {
		//  - Question 5
		return entetes.length ;
	}
	
	@Override
	public String getColumnName(int column) {
		//  - Question 5
		return entetes[ column ] ;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// - Question 5
		switch( columnIndex ){
			case 0 : 
				return String.class;
			case 1 :
				return String.class;
			case 2 :
				return Integer.class;
			default:
				return Object.class;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//  - Question 5
		switch( columnIndex ){
		case 0 : 
			return lesPraticiens.get(rowIndex).getNom();
		case 1 :
			return lesPraticiens.get(rowIndex).getVille();
		default:
			return null;
		}
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

	public List<Praticien>  getLesPraticiens() {
		return lesPraticiens;
	}

	public void setLesPraticiens(List<Praticien>  lesLivreurs) {
		this.lesPraticiens = lesPraticiens;
	}

	public String[] getEntetes() {
		return entetes;
	}

}
