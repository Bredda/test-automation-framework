package bredda.taf.page;

import bredda.taf.driver.DriverManager;
import bredda.taf.exception.NoPageUrlException;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.lang.annotation.Annotation;
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

}
