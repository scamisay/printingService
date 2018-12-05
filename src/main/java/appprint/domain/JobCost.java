package appprint.domain;

import appprint.service.CostCalculator;

public class JobCost {

    private Job job;
    private Double cost;

    public JobCost(Job job, CostCalculator calculator) {
        this.job = job;
        this.cost = calculator.calculate(job);
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f",
                job.toString(), cost);
    }
}
