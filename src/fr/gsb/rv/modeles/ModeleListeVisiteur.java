package fr.gsb.rv.modeles;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import fr.gsb.rv.entites.Visiteur;

public class ModeleListeVisiteur extends AbstractTableModel {

	private List<Visiteur> lesVisiteurs = ModeleGSB.getModele().getVisiteurs() ;
	private final String[] entetes = { "Matricule", "Nom" ,"Prénom" , "Ville" , "Code Postal", "" } ;

	public ModeleListeVisiteur() {
		super();
	}

	@Override
	public int getRowCount() {
		// - Question 5
		return lesVisiteurs.size();
		
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
				return String.class;
			case 3 :
				return String.class;
			case 4 :
				return Integer.class;
			case 5 :
				return String.class;
			default:
				return Object.class;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//  - Question 5
		switch( columnIndex ){
		case 0 : 
			return lesVisiteurs.get(rowIndex).getMatricule();
		case 1 : 
			return lesVisiteurs.get(rowIndex).getNom();
		case 2 : 
			return lesVisiteurs.get(rowIndex).getPrenom();
		case 3 :
			return lesVisiteurs.get(rowIndex).getVille();
		case 4 :
			return lesVisiteurs.get(rowIndex).getCodePostal();
		case 5 : 
			return "Voir";
		default:
			return null;
		}
	}
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if( columnIndex == 5 ){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

	public List<Visiteur>  getLesVisiteurs() {
		return lesVisiteurs;
	}

	public void setLesVisiteurs( List<Visiteur> lesVisiteurs ) {
		this.lesVisiteurs = lesVisiteurs;
	}

	public String[] getEntetes() {
		return entetes;
	}
	
}
