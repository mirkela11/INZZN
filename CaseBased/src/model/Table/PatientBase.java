package model.Table;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controller.PatientController;
import model.Patient;

public class PatientBase implements Serializable {

	private static PatientBase instance = null;
	
	public static PatientBase getInstance() {
		if (instance == null) {
			instance = new PatientBase();
		}
		return instance;
	}
	
	private ArrayList<String> columns;
	private ArrayList<Patient> patients;
	
	private PatientBase() {
		initBase();
		this.columns = new ArrayList<String>();
		this.columns.add("Ime");
		this.columns.add("Prezime");
		this.columns.add("Jmbg");
		this.columns.add("Datum rodjenja");
		this.columns.add("Adresa");
		this.columns.add("Telefon");
		
	}
	
	private void initBase() {
		this.patients = new ArrayList<Patient>();
		patients.add(new Patient(1,"Veljko", "Vukovic","1234567891234", "12.10.1997", "Stojana Novakovica 44", "123456"));
		patients.add(new Patient(2,"Marko", "Markovic","9876543216541", "5.12.1990", "Mike Mikica 22", "180565"));
	}

	public ArrayList<String> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	
	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Patient getRow(int rowIndex) {
		return this.patients.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Patient patient = this.patients.get(row);
		switch(column) {
		case 0: return patient.getFirstName();
		case 1: return patient.getLastName();
		case 2: return patient.getJmbg();
		case 3: return patient.getDateOfBirth();
		case 4: return patient.getAddress();
		case 5: return patient.getPhoneNumber();
		default: return null;
		}
	}
	
	public void addPatient(String firstName, String lastname, String jmbg, String dateOfBirth, String address, String phoneNumber) {
		Patient p = new Patient(patients.size()+1,firstName,lastname,jmbg,dateOfBirth,address,phoneNumber);
		this.patients.add(p);
	}
	public void deletePatient(int id) {
		Patient p = findPatientById(id);
		patients.remove(p);
	}
	
	public Patient findPatientById(int id) {
		for(Patient p : patients) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public void editPatient(int id,String firstName, String lastname, String jmbg, String dateOfBirth, String address, String phoneNumber) {
		Patient p = findPatientById(id);
		p.setFirstName(firstName);
		p.setLastName(lastname);
		p.setJmbg(jmbg);
		p.setDateOfBirth(dateOfBirth);
		p.setAddress(address);
		p.setPhoneNumber(phoneNumber);
	}
	
	public void serialize() {
		try {
			FileOutputStream fProf = new FileOutputStream("patients.ser");
			ObjectOutputStream profOut = new ObjectOutputStream(fProf);
			profOut.writeObject(PatientBase.getInstance().getPatients());
			System.out.println("\nUspesna serilizacija");
			profOut.close();
			fProf.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public void deserialize() {
		try {
			System.out.println("\nUspesna deserilizacija");
			FileInputStream fProf = new FileInputStream("patients.ser");
			ObjectInputStream profIn= new ObjectInputStream(fProf);
			ArrayList<Patient> patients = (ArrayList<Patient>) profIn.readObject();
			PatientBase.getInstance().setPatients(patients);
			PatientController.getInstance().afterDeserilazie();
			
			fProf.close();
			profIn.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
}
