package util.datareaders;

import util.constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {
    private PropertiesReader() {
    }

    private static Properties properties;

    public static void readProperties(String propertyFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties = new Properties();
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //get value with the key name
    public static String getPropertyValue(String propertyName) {
        return properties.getProperty(propertyName);

    }

    public static String readFileTestResources(String propertyName) {
        PropertiesReader.readProperties(Constants.TEST_RESOURCES_PROPERTIES+"Market.properties");
        return PropertiesReader.getPropertyValue(propertyName);
    }

}
