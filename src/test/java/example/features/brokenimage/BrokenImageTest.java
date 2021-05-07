package example.features.brokenimage;

import bredda.taf.extension.Web;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Web
@DisplayName("Displaying broken image link")
public class BrokenImageTest {


    @Test
    @DisplayName("Should found broken images")
    void shouldFindBrokenImage() {
        new BrokenImageSteps()
            .openPage()
            .assertIsDisplayingNBrokenImages(2);
    }
}
