package controller;

import model.Table.AbstractTableModelPatient;
import model.Table.PatientBase;
import model.Table.PatientTable;

public class PatientController {

	private static PatientController instance = null;
	
	public static PatientController getInstance() {
		if(instance == null) {
			instance = new PatientController();
		}
		return instance;
	}
	
	public void removePatient(int id) {
		PatientBase.getInstance().deletePatient(id);
		
		AbstractTableModelPatient model = (AbstractTableModelPatient) PatientTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void editPatient(int id,String firstName, String lastname, String jmbg, String dateOfBirth, String address, String phoneNumber)
	{
		PatientBase.getInstance().editPatient(id, firstName, lastname, jmbg, dateOfBirth, address, phoneNumber);
		AbstractTableModelPatient model = (AbstractTableModelPatient) PatientTable.getInstance().getModel();
		model.fireTableDataChanged();
		
	}
	
	public void dodajProfesora(String firstName, String lastname, String jmbg, String dateOfBirth, String address, String phoneNumber) {
		
		System.out.println("Dodavanje pacijenta");
		PatientBase.getInstance().addPatient(firstName, lastname, jmbg, dateOfBirth, address, phoneNumber);
		
		AbstractTableModelPatient model = (AbstractTableModelPatient) PatientTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void afterDeserilazie() {
		AbstractTableModelPatient model = (AbstractTableModelPatient) PatientTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
}
