package appprint.service;

import appprint.domain.Job;
import appprint.domain.JobCost;

import java.util.List;
import java.util.stream.Collectors;

/**
 * PrintingJobService is a class that parses jobs from a CSV file and calculates its costs
 */
public class PrintingJobService {

    private List<Job> jobs;

    public PrintingJobService(String inputFileName) {
        jobs = readJobs(inputFileName);
    }

    /**
     * This method parses each entry of the csv file into a list of Jobs
     *
     * @param inputFileName
     * @return List<Job>
     */
    private List<Job> readJobs(String inputFileName) {
        JobsReader jobsReader = new JobsReader(inputFileName);
        return jobsReader.read();
    }

    /**
     * create a list of JobCost from the parsed jobs and using an instance of CostCalculator
     *
     * @return List<JobCost>
     */
    public List<JobCost> calculateCosts() {
        CostCalculator costCalculator = new CostCalculator();
        return jobs.stream()
                .map(j -> new JobCost(j, costCalculator ))
                .collect(Collectors.toList());
    }
}
