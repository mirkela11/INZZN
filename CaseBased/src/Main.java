import java.util.Arrays;

import cbr.DiagnosisApplication;
import cbr.MedicamentApplication;import similarity.ListTableSimilarity;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class Main {

    public static void main(String[] args) {
//        SuppTestCbrApplication suppTestCbrApplication = new SuppTestCbrApplication();
//        suppTestCbrApplication.run(Arrays.asList("anemia", "pain_penis_tip", "pain_or_burning_while_urinating", "painful_ejaculation", "fever", "pain_vagina"));
//        TherapyCbrApplication therapyCbrApplication = new TherapyCbrApplication();
//        therapyCbrApplication.run(Arrays.asList("prostate_cancer_stage2"));
//        ProstateCbrApplication prostateCbrApplication = new ProstateCbrApplication();
//        prostateCbrApplication.run("high", "abnormal");
//        BladderCbrApplication bladderCbrApplication = new BladderCbrApplication();
//        bladderCbrApplication.run("BAD");
//        KidneyCbrApplication kidneyCbrApplication = new KidneyCbrApplication();
//        kidneyCbrApplication.run("cancer tissue small");
       // DiagnosisApplication diagnosisApplication = new DiagnosisApplication();
       // diagnosisApplication.run(Arrays.asList("arm_pain","wrist_swelling", "arm_stiffness_or_tightness","arm_swelling","hand_or_finger_stiffness_or_tigtness","wrist_stiffnes_or_tightness"));
        MedicamentApplication medicamentApplication = new MedicamentApplication();
        medicamentApplication.run(Arrays.asList("ketamine","flumazenil","fluorides","fenoprofen","plasma_protein_fraction"));
        

    }
}