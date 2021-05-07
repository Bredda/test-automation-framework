package example.features.addRemove;

import bredda.taf.extension.WEB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@WEB
@DisplayName("Add and remove an element")
public class AddRemoveTest {


    AddRemoveSteps steps;

    @Test
    @DisplayName("Should add elements via steps")
    public void shouldAddElementsSteps() {
        final int nbOfElements = 4;
        steps = new AddRemoveSteps();
        steps
            .openPage()
            .addNElements(nbOfElements)
            .assertNumberOfElementIs(nbOfElements);
    }
}
