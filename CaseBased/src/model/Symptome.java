package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Symptome implements CaseComponent{
	
	private String potentialDiagnose;
	private String symptome;

	public Symptome() {
		super();
	}

	public Symptome(String potentialDiagnose, String symptome) {
		super();
		this.potentialDiagnose = potentialDiagnose;
		this.symptome = symptome;
	}
	
	public String getPotentialDiagnose() {
		return potentialDiagnose;
	}

	public void setPotentialDiagnose(String potentialDiagnose) {
		this.potentialDiagnose = potentialDiagnose;
	}

	public String getSymptome() {
		return symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return new Attribute("id",this.getClass());
	}

}
