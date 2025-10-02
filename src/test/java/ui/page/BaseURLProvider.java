package ui.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseURLProvider {

    public static final Properties properties = new Properties();

    static{
        try (
                InputStream input = new FileInputStream("src/test/resources/url.properties")) {
            properties.load(input);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseURL(String key) {
        return properties.getProperty(key);
    }


}
