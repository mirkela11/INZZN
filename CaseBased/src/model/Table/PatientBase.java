package model.Table;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Diagnosis;
import model.MedicalRecord;
import model.Patient;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.util.FileIO;
import util.StringListMapper;
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
	private ArrayList<Diagnosis> diagnosis_list;
	private ArrayList<String> onlyDiagnoseNames;
	
	private PatientBase() {
		initBase();
		initDiagnosis();
	}
	
	private void initBase() {
		this.patients = new ArrayList<Patient>();
		this.diagnosis_list = new ArrayList<Diagnosis>();
		this.onlyDiagnoseNames = new ArrayList<String>();
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	
	public void addPatient(String firstName, String lastname, String jmbg, String dateOfBirth, String address, String phoneNumber) {
		MedicalRecord mr = new MedicalRecord();
		Patient p = new Patient(patients.size()+1,firstName,lastname,jmbg,dateOfBirth,address,phoneNumber, mr);
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
	
	public void editPatient(int id,String firstName, String lastname, String jmbg, String dateOfBirth, String address, String phoneNumber, MedicalRecord mr) {
		Patient p = findPatientById(id);
		p.setFirstName(firstName);
		p.setLastName(lastname);
		p.setJmbg(jmbg);
		p.setDateOfBirth(dateOfBirth);
		p.setAddress(address);
		p.setPhoneNumber(phoneNumber);
		p.setMr(mr);
		p.createVectorOfData();
		
	}
	
	private void initDiagnosis() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/Diagnosis.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");


				Diagnosis diagnosis = new Diagnosis();
				
				diagnosis.setDiagnosis(values[0]);
				diagnosis.setSymptom(StringListMapper.toList(values[1]));
				
				this.diagnosis_list.add(diagnosis);
				this.onlyDiagnoseNames.add(diagnosis.getDiagnosis());
				
				
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
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

	public ArrayList<Diagnosis> getDiagnosis_list() {
		return diagnosis_list;
	}

	public void setDiagnosis_list(ArrayList<Diagnosis> diagnosis_list) {
		this.diagnosis_list = diagnosis_list;
	}

	public ArrayList<String> getOnlyDiagnoseNames() {
		return onlyDiagnoseNames;
	}

	public void setOnlyDiagnoseNames(ArrayList<String> onlyDiagnoseNames) {
		this.onlyDiagnoseNames = onlyDiagnoseNames;
	}

	
	
}
