package test.Support;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Savita
 * Date: 3/2/14
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnvironmentProperty {

    public Properties QaPropertiesPath() throws Exception {
        Properties QaProperties = new Properties();
        InputStream is = this.getClass().getResourceAsStream(System.getProperty("QA.file", "/qa.properties"));
        QaProperties.load(is);
        return QaProperties;
    }
}
