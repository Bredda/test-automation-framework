package bredda.taf.extension;

import bredda.taf.reporter.AllureManager;
import org.junit.jupiter.api.extension.*;

/**
 * JUNIT5 extension handling test execution reporting
 */
public class ReportExtension implements BeforeAllCallback {


    /**
     * Before each test suite is executed:
     *   * if this is the first test suite, the test execution object is initialized
     *   * for all test suite (first and following), it is added to the execution
     * @param extensionContext Context info for the test suite
     */
    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        AllureManager.setAllureEnvironmentInformation();
    }

}
