package bredda.taf.driver;

import bredda.taf.exception.BrowserNotSupported;
import bredda.taf.exception.TargetNotValidException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static bredda.taf.configuration.ConfigurationManager.configuration;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver createInstance() {
        String targetName = configuration().target().toUpperCase();
        logger.debug("Creating web browser instance for %s", targetName);
        Target target = Target.valueOf(targetName);
        WebDriver webdriver;
        BrowserFactory targetFactory;
        try {
            String browserName = configuration().browser().toUpperCase();
            logger.debug("Target browser is %s", browserName);
            targetFactory = BrowserFactory.valueOf(browserName);
        } catch (IllegalArgumentException e) {
            throw new BrowserNotSupported(configuration().browser());
        }

        switch (target) {
            case LOCAL:
                webdriver = targetFactory.createDriver();
                break;
            case REMOTE:
                webdriver = createRemoteInstance(targetFactory.getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configuration().webDefaultTimeout()));
        return webdriver;
    }

    private static RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", configuration().gridUrl(), configuration().gridPort());

            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
        } catch (java.net.MalformedURLException e) {
            logger.error("Grid URL is invalid or Grid is not available");
            logger.error(String.format("Browser: %s", capability.getBrowserName()), e);
        } catch (IllegalArgumentException e) {
            logger.error(String.format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
        }

        return remoteWebDriver;
    }

    enum Target {
        LOCAL, REMOTE
    }
}
