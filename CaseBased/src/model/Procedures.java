package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Procedures implements CaseComponent {
	
	private String sympton;
	private String procedure;
	
	public Procedures() {
		super();
	}

	public Procedures(String sympton, String procedure) {
		super();
		this.sympton = sympton;
		this.procedure = procedure;
	}

	public String getSympton() {
		return sympton;
	}

	public void setSympton(String sympton) {
		this.sympton = sympton;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}
	
	

}
