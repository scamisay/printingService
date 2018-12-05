package appprint;

import appprint.domain.JobCost;
import appprint.service.PrintingJobService;

import java.util.List;

public class App {

    public static void main(String[] args){
        if(!areArgumentsValid(args)){
            printHelp();
        }else{
            String inputFileName = args[0];
            PrintingJobService service = new PrintingJobService(inputFileName);
            List<JobCost> costs = service.calculateCosts();
            printCosts(costs);
        }
    }

    private static void printHelp() {
        System.out.println("You need to add as argument the path and filename to csv file with jobs to process");
    }

    private static boolean areArgumentsValid(String[] args) {
        return !(args.length < 1 || args[0].isEmpty());
    }

    private static void printCosts(List<JobCost> costs) {
        //printing each job cost detailed
        costs.forEach(c -> System.out.println(c));

        //printing total cost
        double total = costs.stream()
                .mapToDouble(JobCost::getCost)
                .sum();
        System.out.println(String.format("\nNumber of Jobs =  %d",
                costs.size()));
        System.out.println(String.format("Total Cost = $%.2f", total));
    }
}
