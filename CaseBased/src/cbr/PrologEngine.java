package cbr;
import java.util.List;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import util.StringListMapper;
import view.MainFrame;

public class PrologEngine {

	public void run_procedures(List<String> sympthoms) {
		
		JIPEngine engine = new JIPEngine();
		
		engine.consultFile("procedures.pl");
		String tmp = StringListMapper.toString(sympthoms);
		JIPQuery query = engine.openSynchronousQuery("recomended_procedures(" + tmp + ",X)");
		System.out.println("recomended_procedures(" + tmp + ",X)");
		
		// pravila se mogu dodavati i tokom izvrsavanja (u runtime-u)
		// assertz dodaje pravilo na kraj programa (aasserta dodaje na pocetak programa), na primer:
		// engine.assertz(engine.getTermParser().parseTerm("sledbenik(X,Y) :- X is Y+1."));

		JIPTerm solution = query.nextSolution();
		System.out.println("solution: " + solution);
		MainFrame.getInstance().setSolution(solution);
		if(solution != null) {
			for (JIPVariable var: solution.getVariables()) {
					System.out.println(var.getName() + "=" + var.getValue());
			}
		}
		

	}
}
