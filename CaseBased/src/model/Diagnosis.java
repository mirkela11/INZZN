package model;

import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Diagnosis implements CaseComponent{

	private String diagnosis;
	private String symptom;
	
	
	public Diagnosis() {
		super();
	}


	public Diagnosis(String diagnosis, String symptom) {
		super();
		this.diagnosis = diagnosis;
		this.symptom = symptom;
	}


	public String getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


	public String getSymptom() {
		return symptom;
	}


	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}


	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}

	
}
