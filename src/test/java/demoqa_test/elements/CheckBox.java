package demoqa_test.elements;

import demoqa_test.Utils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CheckBox extends TheElements {
    private static final String rootTree = "//div[contains(@class, 'react-checkbox-tree')]/ol/li/ol";

    @FindBy(xpath = "//ul[@class='menu-list']/li[2]")
    WebElement checkBox;

    @FindBy(xpath = "//button[contains(@class, 'rct-option-expand-all')]")
    WebElement expandAll;

    @FindBy(xpath = rootTree + "/li[1]/span/label")
    WebElement desktopCheckBox;

    @FindBy(xpath = rootTree + "/li[1]/span/button")
    WebElement desktopToogle;

    @FindBy(xpath = rootTree + "/li[2]/ol/li[1]/span/label")
    WebElement workSpaceCheckBox;

    @FindBy(xpath = rootTree + "/li[2]/ol/li[2]/span/button")
    WebElement officeToogle;

    @FindBy(xpath = "//div[@id='result']/span[@class='text-success']")
    List<WebElement> textSuccess;

    @Step("Открытие тестируемой вкладки с деревом переключателей.")
    public CheckBox startTest() {
        actions.click(elements).perform();
        actions.click(checkBox).perform();

        expandAllElements();
        chooseWorkSpace();
        chooseAndCloseDesktop();
        closeOfficeToogle();
        assuredResult();

        Utils.ScreenShot();

        return this;
    }

    @Step("Нажатие кнопки, которая расскрывает всё дерево.")
    private void expandAllElements() {
        actions.click(expandAll).perform();
    }

    @Step("Выделить и свернуть ветку Desktop.")
    private void chooseAndCloseDesktop() {
        actions.click(desktopCheckBox).perform();
        actions.click(desktopToogle).perform();
    }

    @Step("Выделить ветку Work Space.")
    private void chooseWorkSpace() {
        actions.click(workSpaceCheckBox).perform();
    }

    @Step("Свернуть ветку Office.")
    private void closeOfficeToogle() {
        actions.click(officeToogle).perform();
    }

    @Step("Проверка отображаемой информации после You have selected...")
    private void assuredResult() {
        List<String> expect = Arrays.stream("desktop notes commands workspace react angular veu".split(" ")).toList();

        Assertions.assertEquals(expect.size(), textSuccess.size());

        for (int i = 0; i < expect.size(); i++) {
            Assertions.assertEquals(expect.get(i), textSuccess.get(i).getText());
        }
    }
}
