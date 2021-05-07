package example.features.brokenimage;

import bredda.taf.extension.WEB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@WEB
@DisplayName("Displaying broken image link")
public class BrokenImageTest {


    @Test
    @DisplayName("Should found broken images")
    public void shouldFindBrokenImage() {
        new BrokenImageSteps()
            .openPage()
            .assertIsDisplayingNBrokenImages(2);
    }
}
