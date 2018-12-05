package appprint.service;

import appprint.domain.Job;
import appprint.domain.JobCost;
import org.junit.Test;

import static org.junit.Assert.*;

public class CostCalculatorTest {


    @Test
    public void calculateJobCost() throws Exception{
        CostCalculator calculator = new CostCalculator();
        Job job = new Job("25, 10, false");
        Double cost = calculator.calculate(job);
        assertEquals(new Double(4.75),cost);
    }

    @Test
    public void createJobCost() throws Exception{
        CostCalculator calculator = new CostCalculator();
        Job job = new Job("25, 10, false");
        JobCost jobCost = new JobCost(job, calculator);
        assertEquals(new Double(4.75),jobCost.getCost());
    }
}