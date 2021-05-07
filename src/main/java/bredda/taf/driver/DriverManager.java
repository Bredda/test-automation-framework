package bredda.taf.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import static bredda.taf.configuration.ConfigurationManager.configuration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static String SCREENSHOT_FOLDER = "screenshots";

    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static String takeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        Path path = Paths.get(configuration().reportPath()).resolve(SCREENSHOT_FOLDER).resolve(UUID.randomUUID() + ".png");
        FileUtils.copyFile(screenshotFile , path.toFile());
        return path.toString();
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return ((JavascriptExecutor)getDriver());
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }

    public static String getInfo() {
        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platform = cap.getPlatformName().toString();
        String version = cap.getBrowserVersion();
        return String.format("browser: %s v: %s platform: %s", browserName, version, platform);
    }
}
