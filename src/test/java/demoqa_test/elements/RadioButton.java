package demoqa_test.elements;

import demoqa_test.Utils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RadioButton extends TheElements {
    @FindBy(xpath = "//ul[@class='menu-list']/li[3]")
    WebElement radioButton;

    @FindBy(xpath = "//input[contains(@id, 'yesRadio')]")
    WebElement yesRadio;

    @FindBy(xpath = "//input[contains(@id, 'impressiveRadio')]")
    WebElement impressiveRadio;

    @FindBy(xpath = "//input[contains(@id, 'noRadio')]")
    WebElement noRadio;

    @FindBy(xpath = "//span[@class='text-success']")
    WebElement youHaveSelected;

    @Step("Открытие тестируемой вкладки с деревом переключателей.")
    public RadioButton startTest() {
        actions = new Actions(Utils.driver);

        actions.click(elements).perform();
        actions.click(radioButton).perform();

        yesRadioTest();
        impressiveRadioTest();

        Utils.ScreenShot();

        return this;
    }

    @Step("Нажатие кнопки yes и проверка отображаемой информации после You have selected...")
    public void yesRadioTest() {
        actions.click(yesRadio).perform();
        Assertions.assertEquals("Yes", youHaveSelected.getText());

        Utils.ScreenShot();
    }

    @Step("Нажатие кнопки impressive и проверка отображаемой информации после You have selected...")
    public void impressiveRadioTest() {
        actions.click(impressiveRadio).perform();

        Assertions.assertEquals("Impressive", youHaveSelected.getText());
    }
}
