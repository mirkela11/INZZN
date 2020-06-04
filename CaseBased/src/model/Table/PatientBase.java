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

import model.Patient;
import view.MainFrame;

public class PatientBase implements Serializable {

	private static PatientBase instance = null;
	
	public static PatientBase getInstance() {
		if (instance == null) {
			instance = new PatientBase();
		}
		return instance;
	}
	
	private ArrayList<Patient> patients;
	
	private PatientBase() {
		initBase();		
	}
	
	private void initBase() {
		this.patients = new ArrayList<Patient>();
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
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
		p.createVectorOfData();
		
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
			MainFrame.getInstance().updateMainPanelPatientsTable();
			System.out.println(patients.toString());
			fProf.close();
			profIn.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
}
