package demoqa_test.elements;

import demoqa_test.Utils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBox extends TheElements {
    private static final String output = "//div[contains(@id, 'output')]/div";
    String inputName = "Артур Рутра";
    String inputEmail = "Rutra@post.com";
    String inputCurrentAddress = "г. Ближний, ул. Параллельная, д. 69, кв. 123";
    String inputPermanentAddress = "г. Дальний, ул. Перпендикулярная, д. 69, кв. 321";

    @FindBy(xpath = "//ul[@class='menu-list']/li[1]")
    WebElement textBox;

    @FindBy(xpath = "//div[@id='userName-wrapper']/div[2]")
    WebElement userName;

    @FindBy(xpath = "//div[@id='userEmail-wrapper']/div[2]")
    WebElement userEmail;

    @FindBy(xpath = "//div[@id='currentAddress-wrapper']/div[2]")
    WebElement currentAddress;

    @FindBy(xpath = "//div[@id='permanentAddress-wrapper']/div[2]")
    WebElement permanentAddress;

    @FindBy(xpath = "//div[contains(@class, 'justify-content-end')]/div/button")
    WebElement submit;

    @FindBy(xpath = output + "/p[1]")
    WebElement outputName;

    @FindBy(xpath = output + "/p[2]")
    WebElement outputEmail;

    @FindBy(xpath = output + "/p[3]")
    WebElement outputCurrentAddress;

    @FindBy(xpath = output + "/p[4]")
    WebElement outputPermanentAddress;

    @Step("Открытие тестируемой вкладки с полями ввода.")
    public TextBox startTest () {
        actions = new Actions(Utils.driver);

        actions.click(elements).perform();
        actions.click(textBox).perform();

        enterInformation();
        clickSubmit();

        Utils.ScreenShot();

        return this;
    }

    @Step("Ввод данных в поля.")
    private void enterInformation() {
        actions.sendKeys(userName, inputName).perform();
        actions.sendKeys(userEmail, inputEmail).perform();
        actions.sendKeys(currentAddress, inputCurrentAddress).perform();
        actions.sendKeys(permanentAddress, inputPermanentAddress).perform();
    }

    @Step("Нажатие кнопки Submit и проверка на соответствие выводимых данных.")
    private void clickSubmit() {
        actions.click(submit).perform();

        Assertions.assertEquals(inputName, outputName.getText().split(":")[1]);
        Assertions.assertEquals(inputEmail, outputEmail.getText().split(":")[1]);
        Assertions.assertEquals(inputCurrentAddress, outputCurrentAddress.getText().split(":")[1]);
        Assertions.assertEquals(inputPermanentAddress, outputPermanentAddress.getText().split(":")[1]);
    }
}
