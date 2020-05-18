package model;

import java.util.ArrayList;
import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;
import util.StringListMapper;

public class Procedures implements CaseComponent {
	
	private String sympton;
	private List<String> procedures;
	
	

	public Procedures() {
		super();
	}

	public Procedures(String sympton, List<String> procedures) {
		super();
		this.sympton = sympton;
		this.procedures = procedures;
	}
	
	

	public String getSympton() {
		return sympton;
	}

	public void setSympton(String sympton) {
		this.sympton = sympton;
	}

	public List<String> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<String> procedures) {
		this.procedures = procedures;
	}

	@Override
	public Attribute getIdAttribute() {
		return null;
	}
	
	@Override
    public String toString() {
        String retVal = StringListMapper.toString(procedures);
        if (sympton != null && sympton.length() > 0)
            retVal += " => " + sympton;
        return retVal;
    }
	

}
