package ProductStoryTest.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private ConfigurationReader() {

    }

    private static Properties properties;

    static {
        try {
            String patch = "src/test/resurses/configuration.properties";
            FileInputStream inputStream = new FileInputStream(patch);

            properties = new Properties();
            properties.load(inputStream);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
