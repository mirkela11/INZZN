import java.util.ArrayList;
import java.util.Arrays;

import cbr.DiagnosisApplication;
import cbr.MedicamentApplication;
import cbr.ProceduresCbrApplication;
import cbr.SymptomeApplication;

public class Main {

    public static void main(String[] args) {
        
//    	DiagnosisApplication diagnosisApplication = new DiagnosisApplication();
//    	diagnosisApplication.run(Arrays.asList("ankle_pain", "ankle_weakness", "leg_pain"));
//		
//		  MedicamentApplication medicamentApplication = new MedicamentApplication();
//		  medicamentApplication.run(Arrays.asList("ketamine","flumazenil","fluorides","fenoprofen","plasma_protein_fraction")); 
		  // ProceduresCbrApplication pca =
//		  ProceduresCbrApplication pca = new ProceduresCbrApplication(); 
//		  pca.run(Arrays.asList("radiographic_imaging_procedure","plain_x-ray",
//		  "electrocardiogram","kidney_function_tests",
//		  "intravenous_fluid_replacement","electrolytes_panel",
//		  "cardiac_enzymes_measurament"));
    	
    	MedicamentApplication medicamentApplication = new MedicamentApplication();
		  medicamentApplication.run(Arrays.asList("etodolac","sodium hyaluronate","fluorides","diflunisal","salsalate","flurbiprofen"));
		  MedicamentApplication medicamentApplication1 = new MedicamentApplication();
		  medicamentApplication1.run(Arrays.asList("celecoxib","meloxicam","fluorides","cortisone","piroxicam"));
		  
    }

}



