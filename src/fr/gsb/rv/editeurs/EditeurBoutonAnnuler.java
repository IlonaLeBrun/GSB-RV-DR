package fr.gsb.rv.editeurs;


import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;


import fr.gsb.rv.controleurs.ControleurListeRV;

public class EditeurBoutonAnnuler extends DefaultCellEditor {
	protected JButton bouton = new JButton();
	private ControleurListeRV controleur = new ControleurListeRV(null) ;
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		super.getTableCellEditorComponent(table, value, isSelected, row, column);
		
		//this.controleur.setRow(row);
		
		if(value == null){
			this.bouton.setText("") ;
			
		}
		else {
			this.bouton.setText(value.toString()) ;
		}
		return this.bouton ;
	}


	public EditeurBoutonAnnuler() {
		super(new JCheckBox());
		this.bouton.addActionListener( controleur );
	}

	
	
}