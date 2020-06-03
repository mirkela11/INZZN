package model.Table;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPatient extends AbstractTableModel {

	public static String patient_column= "Patient";
	
	@Override
	public int getColumnCount() {
		return PatientBase.getInstance().getColumnCount() + 1;
	}

	@Override
	public int getRowCount() {
		return PatientBase.getInstance().getPatients().size();
	}
	
	@Override
	public String getColumnName(int col) {
		if(col >= PatientBase.getInstance().getColumnCount()) {
			return patient_column;
		}else return PatientBase.getInstance().getColumnName(col);	
	}

	@Override
	public Object getValueAt(int row, int column) {
		if(column < 6) {
			return PatientBase.getInstance().getValueAt(row, column);
		}else if(column == 6){
			// JButton btn = new JButton("" + row);
			// return btn;
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return col >= 6;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		super.setValueAt(value, row, col);
		if(col != 6) return;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		default:
			return null;
		}
	}
	

}
