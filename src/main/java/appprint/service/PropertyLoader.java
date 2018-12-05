package appprint.service;

import appprint.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROPERTY_FILENAME = "/application.properties";

    private String defaultPaperType;
    private String paperSettingFile;

    public PropertyLoader() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = App.class.getResourceAsStream(PROPERTY_FILENAME);

            // load properties file
            prop.load(input);
            defaultPaperType = prop.getProperty("defaultPaperType");
            paperSettingFile = prop.getProperty("paperSettingFile");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException("There was an error trying to load application.properties file");
                }
            }
        }
    }

    public String getDefaultPaperType() {
        return defaultPaperType;
    }

    public String getPaperSettingFile() {
        return paperSettingFile;
    }
}
