package example.features;

import bredda.taf.extension.WEB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@WEB
@DisplayName("Add and remove an element")
@Tag("WEB")
public class AddRemoveTest {


    AddRemovePage page;
    AddRemoveSteps steps;

    @Test
    @Tag("WEB")
    @DisplayName("Should add elements via steps")
    public void shouldAddElementsSteps() {
        final int nbOfElements = 4;
        steps = new AddRemoveSteps();
        steps
                .openPage()
                .addNElements(nbOfElements)
                .assertNumberOfElementIs(nbOfElements);

    }

    @Test
    @DisplayName("Should add elements via pages")
    public void shouldAddElementsPages() {
        final int nbOfElements = 4;
        page = new AddRemovePage();
        page.open();
        for(int i = 0 ; i < nbOfElements ; i++) {
            page.addElement();
        }
        assertThat(page.getNumberOfElements() ).isEqualTo(nbOfElements);

    }
}
