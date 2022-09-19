import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
    protected static Properties PROPERTIES;

    static {
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
