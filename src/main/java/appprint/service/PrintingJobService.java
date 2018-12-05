package appprint.service;

import appprint.domain.Job;
import appprint.domain.JobCost;

import java.util.List;
import java.util.stream.Collectors;

public class PrintingJobService {

    private List<Job> jobs;

    public PrintingJobService(String inputFileName) {
        jobs = readJobs(inputFileName);
    }

    private List<Job> readJobs(String inputFileName) {
        JobsReader jobsReader = new JobsReader(inputFileName);
        return jobsReader.read();
    }

    public List<JobCost> calculateCosts() {
        CostCalculator costCalculator = new CostCalculator();
        return jobs.stream()
                .map(j -> new JobCost(j, costCalculator ))
                .collect(Collectors.toList());
    }
}
