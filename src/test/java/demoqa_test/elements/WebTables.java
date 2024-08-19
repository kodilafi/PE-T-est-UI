package demoqa_test.elements;

import demoqa_test.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebTables extends TheElements {
    private static final String USER_FORM = "//form[@id='userForm']";

    @FindBy(xpath = "//ul[@class='menu-list']/li[4]")
    WebElement webTables;

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    WebElement addNewRecordButton;

    @FindBy(xpath = USER_FORM + "//input[contains(@class, 'mr-sm-2')]")
    List<WebElement> userFormFields;

    @FindBy(xpath = "//span[contains(@id, 'edit-record')]")
    List<WebElement> editRecordButtons;

    @FindBy(xpath = "//span[contains(@id, 'delete-record')]")
    List<WebElement> deleteRecordButtons;

    @FindBy(xpath = USER_FORM + "//div[contains(@class, 'justify-content-end')]/div/button")
    WebElement userFormSubmit;

    String[] user_Artur = {"Артур", "Рутра", "rutra@gmail.com", "66", "150000", "QA Automation"};
    String[] user_Arkadiy = {"Аркадий", "Газов", "gazov@mail.ru", "33", "70000", "Кладовщик"};
    String[] user_Tikhon = {"Тихон", "Бирюзов", "biruzov@gmail.com", "99", "20000", "Творец"};

    @Step("Открытие тестируемой вкладки с таблицей.")
    public WebTables deleteRecordTest() {
        actions.click(elements).perform();
        actions.click(webTables).perform();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[contains(@id, 'delete-record')]"), 3));

        actions.click(deleteRecordButtons.get(2)).perform();
        actions.click(deleteRecordButtons.get(0)).perform();

        Utils.ScreenShot();

        return this;
    }

    @Step("Открытие тестируемой вкладки с таблицей.")
    public WebTables editRecordTest() {
        actions.click(elements).perform();
        actions.click(webTables).perform();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[contains(@id, 'edit-record')]"), 3));

        //Редактирование первого пользователя
        wait.until(ExpectedConditions.elementToBeClickable(editRecordButtons.get(0)));
        actions.click(editRecordButtons.get(0)).perform();

        //wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(USER_FORM + "//input[contains(@class, 'mr-sm-2')]"), 6));

        editRecord(userFormFields.get(1), "Adobe");
        editRecord(userFormFields.get(3), "15");
        editRecord(userFormFields.get(5), "Какой-то там");

        actions.click(userFormSubmit).perform();

        //Редактирование второго пользователя
        wait.until(ExpectedConditions.elementToBeClickable(editRecordButtons.get(1)));
        actions.click(editRecordButtons.get(1)).perform();

        //wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(USER_FORM + "//input[contains(@class, 'mr-sm-2')]"), 6));

        editRecord(userFormFields.get(0), "Victor");
        editRecord(userFormFields.get(2), "getterov@mail.ru");
        editRecord(userFormFields.get(4), "40000");

        actions.click(userFormSubmit).perform();

        Utils.ScreenShot();

        return this;
    }

    public void editRecord(WebElement element, String data) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        actions.sendKeys(element, data);
    }

    @Step("Открытие тестируемой вкладки с таблицей.")
    public WebTables createRecordTest() {
        actions.click(elements).perform();
        actions.click(webTables).perform();

        createRecord();

        Utils.ScreenShot();

        return this;
    }

    @Step("Создание пользователей.")
    public void createRecord() {
        enterInfo(user_Artur);
        enterInfo(user_Arkadiy);
        enterInfo(user_Tikhon);
    }

    private void enterInfo(String[] infoRecord) {
        wait.until(ExpectedConditions.elementToBeClickable(addNewRecordButton));
        actions.click(addNewRecordButton).perform();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//input[contains(@class, 'mr-sm-2')]"), 6));

        for (int i = 0; i < userFormFields.size(); i++) {
            actions.sendKeys(userFormFields.get(i), infoRecord[i]);
        }

        actions.click(userFormSubmit).perform();
    }
}
