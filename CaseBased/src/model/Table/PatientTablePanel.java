package model.Table;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PatientTablePanel extends JScrollPane {

	private JTable patientsTable;
	
	public PatientTablePanel() {
		//setBounds(100, 100, 450, 300);
		//setBorder(new EmptyBorder(5, 5, 5, 5));
		//setLayout(new BorderLayout(0, 0));
		
		PatientTable tableModel = new PatientTable();
		patientsTable = new JTable(tableModel);
		
		patientsTable.setPreferredScrollableViewportSize(new Dimension(500, 400));
		patientsTable.setFillsViewportHeight(true);
		patientsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		setViewportView(patientsTable);
		
		this.getViewport().add(patientsTable);
		
	}
	
	public void refreshData() {
		PatientTable tableModel = (PatientTable) patientsTable.getModel();
		tableModel.refreshData();
	}

	public JTable getTable() {
		return patientsTable;
	}
}
