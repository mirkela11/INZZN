import java.util.Arrays;

import cbr.DiagnosisApplication;
import cbr.MedicamentApplication;
import cbr.ProceduresCbrApplication;
import cbr.SymptomeApplication;

public class Main {

    public static void main(String[] args) {
        
    	DiagnosisApplication diagnosisApplication = new DiagnosisApplication();
       	diagnosisApplication.run(Arrays.asList("arm_pain","wrist_swelling", "arm_stiffness_or_tightness","arm_swelling","hand_or_finger_stiffness_or_tigtness","wrist_stiffnes_or_tightness"));
        MedicamentApplication medicamentApplication = new MedicamentApplication();
        medicamentApplication.run(Arrays.asList("ketamine","flumazenil","fluorides","fenoprofen","plasma_protein_fraction"));
        ProceduresCbrApplication pca = new ProceduresCbrApplication();
		pca.run(Arrays.asList("radiographic_imaging_procedure","plain_x-ray","electrocardiogram","kidney_function_tests", "intravenous_fluid_replacement","electrolytes_panel","cardiac_enzymes_measurament"));
        SymptomeApplication symptomeApplication = new SymptomeApplication();
        symptomeApplication.run(Arrays.asList("bruise","sprain_or_strain","fracture_of_the_arm","injury_to_the_shoulder","spinal_stenosis","brachial_neuritis","pyogenic_skin_infection","carpal_tunel_syndrome"));
    }

}



