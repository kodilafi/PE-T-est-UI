package demoqa_test.elements;

import demoqa_test.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Buttons extends TheElements {
    @FindBy(xpath = "//ul[@class='menu-list']/li[5]")
    WebElement buttons;

    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    WebElement doubleClickButton;

    @FindBy(xpath = "//button[@id='rightClickBtn']")
    WebElement rightClickButton;

    @FindBy(xpath = "//div[@class='mt-4'][2]/button[contains(@class, 'btn')]")
    WebElement classicClickButton;

    @Step("Открытие тестируемой вкладки с кнопками.")
    public Buttons startTest () {
        actions.click(elements).perform();
        actions.click(buttons).perform();

        clickButtons();

        Utils.ScreenShot();

        return this;
    }

    @Step("Нажатие на кнопки.")
    public void clickButtons() {
        actions.doubleClick(doubleClickButton).perform();
        actions.contextClick(rightClickButton).perform();
        actions.click(classicClickButton).perform();
    }
}
