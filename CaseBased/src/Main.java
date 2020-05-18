import java.util.Arrays;

import cbr.DiagnosisApplication;

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
        DiagnosisApplication diagnosisCbrApplication = new DiagnosisApplication();
        diagnosisCbrApplication.run(Arrays.asList("arm_pain","wrist_pain", "arm_swelling","ankle_pain"));
    }
}
