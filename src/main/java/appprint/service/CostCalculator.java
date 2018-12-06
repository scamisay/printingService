package appprint.service;

import appprint.domain.Job;
import appprint.domain.PaperType;

import java.util.List;

/**
 * CostCalculator is a class that calculates a job cost from the paper settings in yaml file and
 * some information read from a properties file
 */
public class CostCalculator {

    private List<PaperType> papers;
    private String defaultType;

    public CostCalculator() {
        //loads information from properties file
        PropertyLoader propertyLoader = new PropertyLoader();

        //instantiate paper settings from yaml file. yaml file name is in properties file
        this.papers = new PapersTypeLoader(propertyLoader.getPaperSettingFile()).getPaperTypeList();

        //read default paper type from properties file
        this.defaultType = propertyLoader.getDefaultPaperType();
    }

    /**
     * Calculates a job cost in cents
     * @param job
     * @return
     */
    public Double calculate(Job job){
        int bw,c;

        //load paper settings for default paper type. In this case is A4
        PaperType type = findByPaperType(defaultType);

        //black and white and color cost is calculated depending if job is double sided or not
        if(job.isDouble()){
            bw = type.getDoubleSided().getBlackAndWhite();
            c = type.getDoubleSided().getColor();
        }else {
            bw = type.getSingleSided().getBlackAndWhite();
            c = type.getSingleSided().getColor();
        }

        //computing the cost and then expressing it in cents
        int totalValueInCents = job.getBlackAndWhitePages()*bw + job.getColorPages()*c;
        return totalValueInCents / 100.;
    }

    private PaperType findByPaperType(String paperType){
        return papers.stream().filter(pt -> pt.getType().equals(paperType))
                .findFirst().orElse(null);
    }
}
