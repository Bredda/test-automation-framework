package example.features.addRemove;

import bredda.taf.extension.ReportExtension;
import bredda.taf.extension.Web;
import bredda.taf.extension.WebExtension;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Web
@DisplayName("Add and remove an element")
public class AddRemoveTest {


    AddRemoveSteps steps;

    @Test
    @DisplayName("Should add elements")
    @Description("Custom description fir this test")
    void shouldAddElements() {
        final int nbOfElements = 4;
        steps = new AddRemoveSteps();
        steps
            .openPage()
            .addNElements(nbOfElements)
            .assertNumberOfElementIs(nbOfElements);
    }
}
