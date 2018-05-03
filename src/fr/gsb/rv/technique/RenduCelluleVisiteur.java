package fr.gsb.rv.technique;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import fr.gsb.rv.modeles.ModeleGSB;

public class RenduCelluleVisiteur extends DefaultTableCellRenderer {
	
	public RenduCelluleVisiteur(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		DefaultTableCellRenderer composant = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		//composant.setBackground(new Color(200,80,70));
		
		if(column == 0){
			composant.setHorizontalAlignment(RIGHT);
		}
		
		else if(column == 1){
			composant.setHorizontalAlignment(CENTER);
		}
		
		else if(column == 2){
			composant.setHorizontalAlignment(CENTER);
		}
		
		else if(column == 3){
			composant.setHorizontalAlignment(CENTER);
		}
		
		else if(column == 4){
			composant.setHorizontalAlignment(CENTER);
		}
		
		else if(column == 5){
			composant.setHorizontalAlignment(CENTER);
		}

		return composant ;
	}
	

}