package test.configuration;

import org.jbehave.web.selenium.DelegatingWebDriverProvider;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RealConnexWebDriverProvider extends DelegatingWebDriverProvider {
    @Override
    public void initialize() {
        String browser = System.getProperty("browser", "").toLowerCase();

        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        dc.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        //dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // It's possible to avoid the post-processing cost of uploading videos for passing tests
//        dc.setCapability("video-upload-on-pass", false);

        if ("ie8".equals(browser)) {
            dc.setVersion("8");
            dc.setCapability("platform", "Windows 2008");
        } else if ("ie9".equals(browser)) {
            dc.setVersion("9");
            dc.setCapability("platform", "Windows 2008");
        } else if ("ie10".equals(browser)) {
            dc.setVersion("10");
            dc.setCapability("platform", "Windows 2012");
        }

        // Set a 10 minute limit per test
        dc.setCapability("max-duration", 10 * 60);
        // Set a 30 second command timeout
        dc.setCapability("command-timeout", 30);
        // Set a 15 second idle timeout
        dc.setCapability("idle-timeout", 15);

    }
}
