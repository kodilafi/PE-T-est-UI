package demoqa_test.elements;

import demoqa_test.Utils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TheElements {
    protected Actions actions;
    protected WebDriverWait wait;

    @FindBy(xpath = "//div[@class='card-up']")
    WebElement elements;

    public TheElements() {
        try {
            Utils.driver.get(Utils.URL);
        } catch (TimeoutException e) {

        }

        PageFactory.initElements(Utils.driver, this);
        actions = new Actions(Utils.driver);
        wait = new WebDriverWait(Utils.driver, Duration.ofSeconds(3));
    }
}
