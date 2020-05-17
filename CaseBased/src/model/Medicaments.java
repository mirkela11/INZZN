package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Medicaments implements CaseComponent{

	private String diagnose;
	private String medicament;
		
	public Medicaments() {
		super();
	}
	
	public Medicaments(String diagnose, String medicament) {
		super();
		this.diagnose = diagnose;
		this.medicament = medicament;
	}
	
	
	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getMedicament() {
		return medicament;
	}

	public void setMedicament(String medicament) {
		this.medicament = medicament;
	}

	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}
	
	
}
