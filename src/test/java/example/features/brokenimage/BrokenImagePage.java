package example.features.brokenimage;

import bredda.taf.page.AbstractPageObject;
import bredda.taf.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page(path="broken_images")
public class BrokenImagePage extends AbstractPageObject {

    @FindBy(css = "img")
    private List<WebElement> images;

    public int getNumberOfBrokenImages() {
        return this.filterBrokenImages(images).size();
    }
}
