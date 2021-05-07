package example.features.brokenimage;

import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class BrokenImageSteps {

    BrokenImagePage page;

    public BrokenImageSteps() {
        this.page = new BrokenImagePage();
    }

    @Step("Open Borken Image page")
    public BrokenImageSteps openPage() { this.page.open(); return this;}

    @Step("Verify page is displaying {n} broken image")
    public BrokenImageSteps assertIsDisplayingNBrokenImages(int n) {
        assertThat(page.getNumberOfBrokenImages()).isEqualTo(2);
        return this;
    }

}
