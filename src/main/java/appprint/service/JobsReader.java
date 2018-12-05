package appprint.service;

import appprint.domain.Job;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class JobsReader {

    private String filePath;

    public JobsReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Job> read(){
        List<Job> inputList = null;

        try{
            File inputF = new File(filePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().skip(1).map(s->new Job(s)).collect(Collectors.toList());
            br.close();
        } catch (Exception e) {
            throw new RuntimeException("Error trying to parse csv file. " +
                    "Please make sure the file has the following format:");
        }
        return inputList;
    }
}
