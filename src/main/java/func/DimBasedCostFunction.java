/*
 * Copyright (C) 2016 peter
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package func;

import config.Configuration;
import data.Plan;
import data.Vector;

import java.util.function.Supplier;

/**
 * dimension based cost function. Multiplies each dimension by the price / cost of that dimension
 *
 * @author Farzam
 */
public class DimBasedCostFunction implements DifferentiableCostFunction<Vector>, HasGoal{

    private Vector target;

    public DimBasedCostFunction() {
    }

    @Override
    public double calcCost(Vector value) {
        System.out.println("wrong");
        return 0;
        }

    @Override
    public double calcCost(Vector value, boolean normalise) {
        return 0;
    }

    @Override
    public double calcCost(Plan<Vector> plan, Vector cost) {
        Vector c = cost.cloneThis();
        Vector v = plan.getValue();

        double[] costs = c.getValues();
        double[] vPlan = v.getValues();
        double sum=0;
        for (int i=0;i<costs.length;i++){sum += costs[i]*vPlan[i];}
        return sum;
    }

    @Override
    public double calcCost(Plan<Vector> plan, Supplier<Vector> cost) {
        return 0;
    }

    @Override
    public double calcCost(Vector plan, Vector cost) {
        return 0;
    }

    @Override
    public Vector calcGradient(Vector vector) {
        Vector v = vector.cloneThis();
        v.subtract(target);
        v.multiply(2);
        return v;
    }

    @Override
    public String toString() {
        return "DimBased";
    }

    @Override
    public void populateGoalSignal() {
        this.target = Configuration.goalSignalSupplier.get();
    }

    @Override
    public String getLabel() {
        // TODO Auto-generated method stub
        return "DBCF";
    }
}
