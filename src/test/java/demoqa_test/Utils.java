package demoqa_test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static WebDriver driver;

    public static final String URL = "https://demoqa.com/";

    @Step("Создание скриншота")
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] ScreenShot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
