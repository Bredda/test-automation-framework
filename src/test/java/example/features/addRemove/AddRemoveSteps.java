package example.features.addRemove;

import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class AddRemoveSteps {



    AddRemovePage page;

    public AddRemoveSteps() {
        this.page = new AddRemovePage();
    }

    @Step
    public AddRemoveSteps openPage() {
        this.page.open(); return this;}

    @Step("Add {n} elements")
    public AddRemoveSteps addNElements(int n) {
        for(int i = 0 ; i < n ; i++) {
            page.addElement();
        }
        return this;
    }

    @Step("Verify there is exactly {expected} element(s)")
    public AddRemoveSteps assertNumberOfElementIs(int expected) {
        assertThat(page.getNumberOfElements() ).isEqualTo(expected);
        return this;
    }

}
