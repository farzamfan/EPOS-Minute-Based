package func;

import data.Plan;
import data.Vector;

import java.util.function.Supplier;

/**
 * This cost function transforms a the plan score by substracting it from 1.
 * This can be used when the maximization of the plan cost is desired, by minimizing the 
 * 1 - c function. This function is opposite to the {@code PlanScoreCostFunction}
 * 
 * @author Jovan N., Thomas Asikis
 *
 */
public class PlanPreferenceFunction implements PlanCostFunction {

	@Override
	public double calcCost(Plan plan, Vector costSignal) {
		if (Double.isNaN(plan.getScore())) {
			return 0.0;
		} else {
			return 1 - plan.getScore();
		}
	}

	@Override
	public double calcCost(Plan plan, Supplier cost) {
		return 0;
	}

	@Override
	public String toString() {
		return "preference local cost function";
	}
	
	@Override
	public String getLabel() {
		return "PREF";
	}

}
