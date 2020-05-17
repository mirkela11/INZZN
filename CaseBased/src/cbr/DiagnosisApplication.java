package cbr;

import java.util.Arrays;
import java.util.Collection;

import connector.DiagnosisConnector;
import model.Diagnosis;
import similarity.TableSimilarity;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
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
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Threshold;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class DiagnosisApplication implements StandardCBRApplication{
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new DiagnosisConnector();
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		setSimilarityConfigration1();
	}
	
	public void setSimilarityConfigration1() {
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		TableSimilarity genreSimilarity = new TableSimilarity((Arrays.asList(new String[] {"fracture_of_the_arm","fracture_of_the_hand", "fracture_of_the_leg"})));
		genreSimilarity.setSimilarity("fracture_of_the_arm", "fracture_of_the_hand",.9);
		genreSimilarity.setSimilarity("fracture_of_the_arm", "fracture_of_the_leg",.1);
		genreSimilarity.setSimilarity("fracture_of_the_hand", "fracture_of_the_leg", .2);
		
		simConfig.addMapping(new Attribute("diagnosis", Diagnosis.class), genreSimilarity);
	}
	
	public void setSimilarityConfigration2() {
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		TableSimilarity genreSimilarity = new TableSimilarity((Arrays.asList(new String[] {"arm_pain","arm_swelling", "wrist_pain", "arm_stiffness_or_tightness"})));
		genreSimilarity.setSimilarity("arm_pain", "arm_swelling",.6);
		genreSimilarity.setSimilarity("wrist_pain", "arm_swelling",.1);
		genreSimilarity.setSimilarity("arm_stiffness_or_tightness", "arm_pain", .9);
		
		simConfig.addMapping(new Attribute("diagnosis", Diagnosis.class), genreSimilarity);
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
//		for (CBRCase c: cases)
//			System.out.println(c.getDescription());
		return _caseBase;
	}

	public static void main(String[] args) {
		DiagnosisApplication recommender = new DiagnosisApplication();
		try {
			System.out.println("-----");
			recommender.configure();
			recommender.preCycle();
			CBRQuery query = new CBRQuery();
			Diagnosis d = new Diagnosis();
			d.setDiagnosis("knee_pain");
			d.setSymptom("knee_pain");
			query.setDescription( d );
			recommender.cycle(query);
			recommender.postCycle();
			
			System.out.println("-----");
			recommender.setSimilarityConfigration2();
			recommender.preCycle();
			d = new Diagnosis();
			d.setDiagnosis("fracture_of_the_arm");
			d.setSymptom("arm_pain");
			
			query.setDescription( d );
			recommender.cycle(query);
			recommender.postCycle();
		}catch (Exception e) {
		e.printStackTrace();
		}

	}
}
