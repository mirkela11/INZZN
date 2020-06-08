package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhysicalExamination implements Serializable {

	private int id;
	private String vidljivPrelom;
	private String vidljivOtok;
	private String mogucnostPokreta;
	private ArrayList<String> simptomi = new ArrayList<String>();
	
	
	public PhysicalExamination() {
		super();
	}
	


	public PhysicalExamination(int id, String vidljivPrelom, String vidljivOtok, String mogucnostPokreta,
			ArrayList<String> simptomi) {
		super();
		this.id = id;
		this.vidljivPrelom = vidljivPrelom;
		this.vidljivOtok = vidljivOtok;
		this.mogucnostPokreta = mogucnostPokreta;
		this.simptomi = simptomi;
	}


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ArrayList<String> getSimptomi() {
		return simptomi;
	}



	public void setSimptomi(ArrayList<String> simptomi) {
		this.simptomi = simptomi;
	}



	public String getVidljivPrelom() {
		return vidljivPrelom;
	}

	public void setVidljivPrelom(String vidljivPrelom) {
		this.vidljivPrelom = vidljivPrelom;
	}

	public String getVidljivOtok() {
		return vidljivOtok;
	}

	public void setVidljivOtok(String vidljivOtok) {
		this.vidljivOtok = vidljivOtok;
	}

	public String getMogucnostPokreta() {
		return mogucnostPokreta;
	}

	public void setMogucnostPokreta(String mogucnostPokreta) {
		this.mogucnostPokreta = mogucnostPokreta;
	}




	@Override
	public String toString() {
		return "PhysicalExamination [vidljivPrelom=" + vidljivPrelom + ", vidljivOtok=" + vidljivOtok
				+ ", mogucnostPokreta=" + mogucnostPokreta + ", simptomi=" + simptomi + "]";
	}
	
	
	
}
