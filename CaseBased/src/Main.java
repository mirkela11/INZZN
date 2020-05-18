import java.util.Arrays;

import cbr.ProceduresCbrApplication;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProceduresCbrApplication pca = new ProceduresCbrApplication();
		pca.run(Arrays.asList("radiographic_imaging_procedure","plain_x-ray","electrocardiogram","kidney_function_tests", "intravenous_fluid_replacement","electrolytes_panel","cardiac_enzymes_measurament"));
	}

}
