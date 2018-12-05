package appprint.service;

import appprint.domain.Job;
import appprint.domain.PaperType;

import java.util.List;

public class CostCalculator {

    private List<PaperType> papers;
    private String defaultType;

    public CostCalculator() {
        PropertyLoader propertyLoader = new PropertyLoader();
        this.papers = new PapersTypeLoader(propertyLoader.getPaperSettingFile()).getPaperTypeList();
        this.defaultType = propertyLoader.getDefaultPaperType();
    }

    public Double calculate(Job job){
        int bw,c;
        PaperType type = findByPaperType(defaultType);
        if(job.isDouble()){
            bw = type.getDoubleSided().getBlackAndWhite();
            c = type.getDoubleSided().getColor();
        }else {
            bw = type.getSingleSided().getBlackAndWhite();
            c = type.getSingleSided().getColor();
        }

        int totalValueInCents = job.getBlackAndWhitePages()*bw + job.getColorPages()*c;
        return totalValueInCents / 100.;
    }

    private PaperType findByPaperType(String paperType){
        return papers.stream().filter(pt -> pt.getType().equals(paperType))
                .findFirst().orElse(null);
    }
}
