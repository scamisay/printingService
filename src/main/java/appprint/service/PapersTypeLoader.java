package appprint.service;

import appprint.App;
import appprint.domain.PaperType;
import appprint.domain.Papers;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PapersTypeLoader {

    private List<PaperType> paperTypeList;

    public PapersTypeLoader(String yamlFile) {
        Papers papers;
        Yaml yaml = new Yaml();
        try (InputStream in = App.class.getResourceAsStream(yamlFile)) {
            papers = yaml.loadAs(in, Papers.class);
            paperTypeList = papers.getPapers();
        }catch (Exception e){
            throw new RuntimeException("There was an error trying to load yaml file with paper types");
        }
    }

    public List<PaperType> getPaperTypeList() {
        return paperTypeList;
    }
}
