package demoqa_test;

import demoqa_test.elements.*;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

@Owner("Дима")
public class Main extends SeleniumDriverOptions {
    @Test
    @Description("Тест на корректность работы web-элементов из вкладки Buttons")
    public void Buttons() {
        Buttons testButtons = new Buttons();
        testButtons.startTest();
    }

    @Test
    @Description("Тест на корректность работы web-элементов из вкладки Text Box")
    public void TextBox() {
        TextBox testTextBox = new TextBox();
        testTextBox.startTest();
    }

    @Test
    @Description("Тест на корректность работы web-элементов из вкладки Check Box")
    public void CheckBox() {
        CheckBox testCheckBox = new CheckBox();
        testCheckBox.startTest();
    }

    @Test
    @Description("Тест на корректность работы web-элементов из вкладки Radio Button")
    public void RadioButton() {
        RadioButton testRadioButton = new RadioButton();
        testRadioButton.startTest();
    }

    @Test
    @Description("Тест на удаление записей в Web Tables")
    public void WebTablesDelete() {
        WebTables deleteTest = new WebTables();
        deleteTest.deleteRecordTest();
    }

    @Test
    @Description("Тест редактирование записей в Web Tables")
    public void WebTablesEdit() {
        WebTables editTest = new WebTables();
        editTest.editRecordTest();
    }

    @Test
    @Description("Тест создание записей в Web Tables")
    public void WebTablesCreate() {
        WebTables createTest = new WebTables();
        createTest.createRecordTest();
    }
}
