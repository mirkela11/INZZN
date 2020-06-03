package model.Table;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

public class PatientTable extends JTable {
	
	private static PatientTable instance = null;
	
	public static PatientTable getInstance() {
		if(instance == null) {
			instance = new PatientTable();
		}
		return instance;
	}
	
	private TableRowSorter<AbstractTableModelPatient> sorter;
	
	private PatientTable() {
		this.setModel(new AbstractTableModelPatient());
		sorter = new TableRowSorter<>((AbstractTableModelPatient) getModel());
		this.setRowSorter(sorter);
	}
	
}
