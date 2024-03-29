/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package func;

import data.Plan;
import data.DataType;
import data.Vector;

import java.util.function.Supplier;

/**
 * A cost functionfunction that operates on a plan to calculate a scalar real value.
 * 
 * @author Peter, Thomas Asikis
 * @param <V> the type of the data this cost function should handle
 */
public interface PlanCostFunction<V extends DataType<V>> {
	
	/**
	 * This method takes as an input any plan of type V and calculates the
	 * real number that represents the cost of the plan. This function is used during
	 * the minimization.
	 * @param plan
	 * @param costSignal
     * @return
	 */
    public double calcCost(Plan<V> plan, Vector costSignal);

	public double calcCost(Plan<V> plan, Supplier<Vector> cost);
    
    public abstract String getLabel();

}
