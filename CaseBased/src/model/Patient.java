package model;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Vector;


public class Patient implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private String jmbg;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	
	private Vector<Object> structuredData;
	
	public Patient() {
		super();
	}
	
	
	
	public Patient(int id, String firstName, String lastName, String jmbg, String dateOfBirth, String address,
			String phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jmbg = jmbg;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		createVectorOfData();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Vector<Object> getStructuredData() {
		return structuredData;
	}



	public void setStructuredData(Vector<Object> structuredData) {
		this.structuredData = structuredData;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Patient [patientId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", jmbg="
		+ jmbg + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", telephoneNumber="
		+ phoneNumber + "]";
	}
	
	public void createVectorOfData() {
		Vector<Object> objects = new Vector<Object>();
		objects.add(getId());
		objects.add(getFirstName());
		objects.add(getLastName());
		objects.add(getDateOfBirth());
		objects.add(getJmbg());
		objects.add(getAddress());
		objects.add(getPhoneNumber());
		setStructuredData(objects);
	}
	
}
