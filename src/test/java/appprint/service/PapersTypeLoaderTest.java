package appprint.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class PapersTypeLoaderTest {

    @Test
    public void loadYaml() {
        PapersTypeLoader papersTypeLoader = new PapersTypeLoader("/papers.yaml");
        assertTrue(!papersTypeLoader.getPaperTypeList().isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void yamlWrongName() {
        PapersTypeLoader papersTypeLoader = new PapersTypeLoader("/paperews.yaml");
    }
}