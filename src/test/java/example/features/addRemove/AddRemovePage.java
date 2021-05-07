package example.features.addRemove;

import bredda.taf.page.AbstractPageObject;
import bredda.taf.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Page(path = "add_remove_elements/")
public class AddRemovePage extends AbstractPageObject {

    @FindBy(css = "#elements button.added-manually")
    private List<WebElement> BUTTON_REMOVE_ELEMENT;

    @FindBy(css = ".example button")
    private WebElement BUTTON_ADD_ELEMENT;

    public void addElement() {
        this.BUTTON_ADD_ELEMENT.click();
    }

    public int getNumberOfElements() {
        return this.BUTTON_REMOVE_ELEMENT.size();
    }

}
