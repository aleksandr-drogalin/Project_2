package api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiProvider {

    public static final Properties properties = new Properties();

    static {
        try(
                InputStream input = new FileInputStream("src/test/resources/api.properties")
                ){
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
