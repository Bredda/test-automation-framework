package bredda.taf.extension;

import bredda.taf.reporter.AllureManager;
import org.junit.jupiter.api.extension.*;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

/**
 * JUNIT5 extension handling test execution reporting
 */
public class ReportExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            // Your "before all tests" startup logic goes here
            // The following line registers a callback hook when the root test context is shut down
            context.getRoot().getStore(GLOBAL).put("any unique name", this);
            //TODO: find a fix for allure-envir
            //AllureManager.setAllureEnvironmentInformation();
        }
    }

    @Override
    public void close() {
        // Your "after all tests" logic goes here
    }
}