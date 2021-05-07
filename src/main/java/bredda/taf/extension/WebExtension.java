package bredda.taf.extension;

import bredda.taf.driver.DriverManager;
import bredda.taf.driver.DriverFactory;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static bredda.taf.configuration.ConfigurationManager.configuration;

public class WebExtension
        implements BeforeEachCallback, AfterEachCallback {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    @Override
    public void beforeEach(ExtensionContext context) {
        WebDriver driver = DriverFactory.createInstance();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(configuration().webBaseUrl());
        logger.info("Browser instance created: %s", DriverManager.getInfo());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        DriverManager.quit();
    }

}
