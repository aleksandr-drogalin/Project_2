package api.provider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiPropertiesProvider {

    public static final Properties propertiesApi = new Properties();

    static {
        try(
                InputStream input = new FileInputStream("src/test/resources/api.properties")
                ){
            propertiesApi.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
