package appprint.service;

import appprint.domain.Job;
import appprint.domain.PaperType;
import appprint.domain.Papers;

public class CostCalculator {

    private Papers papers;
    private String defaultType;

    public CostCalculator(Papers papers, String defaultType) {
        this.papers = papers;
        this.defaultType = defaultType;
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

        int bwPages = (job.getTotalPages()-job.getColorPages());
        return (bwPages*bw + job.getColorPages()*c)/100.;
    }

    private PaperType findByPaperType(String paperType){
        return papers.getPapers().stream().filter(pt -> pt.getType().equals(paperType))
                .findFirst().orElse(null);
    }
}
