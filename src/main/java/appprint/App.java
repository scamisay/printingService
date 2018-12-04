package appprint;

import appprint.domain.Job;
import appprint.domain.JobCost;
import appprint.domain.Papers;
import appprint.service.CostCalculator;
import appprint.service.JobsReader;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {
        Papers papers;
        Yaml yaml = new Yaml();
        try (InputStream in = App.class.getResourceAsStream("/papers.yaml")) {
            papers = yaml.loadAs(in, Papers.class);
        }


        CostCalculator costCalculator = new CostCalculator(papers, "A4");

        JobsReader jobsReader = new JobsReader(args[0]);
        List<Job> jobs = jobsReader.read();

        List<JobCost> costs = jobs.stream()
                .map(j -> new JobCost(j,costCalculator ))
                .collect(Collectors.toList());

        //printing
        costs.forEach(c -> System.out.println(c));

        double total = costs.stream()
                .mapToDouble(JobCost::getCost)
                .sum();
        System.out.println(String.format("\njobs: %d - total: $%.2f",
                costs.size(), total));

    }
}
