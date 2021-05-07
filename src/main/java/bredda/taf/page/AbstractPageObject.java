package bredda.taf.page;

import bredda.taf.driver.DriverManager;
import bredda.taf.exception.NoPageUrlException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

import static bredda.taf.configuration.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;


public abstract class AbstractPageObject {

    public void open(String path) {
        DriverManager.getDriver().get(path);
    }

    public void open() {
        if (this.getClass().isAnnotationPresent(Page.class)) {
            Annotation a = this.getClass().getAnnotation(Page.class);
            Page annotation = (Page) a;
            if (annotation.path().isEmpty()) throw new NoPageUrlException(this.getClass().getName());

             DriverManager.getDriver().get(configuration().webBaseUrl() + annotation.path());
        } else {
            throw new NoPageUrlException(this.getClass().getName());
        }
    }

     public AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), 10), this);
    }

    protected List<WebElement> filterBrokenImages(List<WebElement> images) {
        return images.stream().filter(e -> e.getTagName().equalsIgnoreCase("img") && isBrokenImage(e)).collect(Collectors.toList());
    }

    protected boolean isBrokenImage(WebElement image) {
        final String script = "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0";
        return (boolean)(DriverManager.getJavascriptExecutor().executeScript(script, image));
    }

}
