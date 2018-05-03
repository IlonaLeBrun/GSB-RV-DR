package fr.gsb.rv.technique;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RenduCelluleBouttonVisiteur extends JButton implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		
		if(value != null){
			this.setText(value.toString());
			
		}
		
		else{
			this.setText("");
		}
		
		return this;
	}

}
