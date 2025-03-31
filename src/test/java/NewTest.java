import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NewTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void title() {
        driver.get("https://www.mts.by/");
        WebElement block = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));

        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";
        String actualTitle = block.getText();

        assertEquals(expectedTitle, actualTitle, "Название блока не совпадает");
    }
    @Test
    public void logos() {
        driver.get("https://www.mts.by/");

        List<WebElement> logos = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(
                        By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul"
                        )));

        Assertions.assertAll(
                "Проверка логотипов",
                () -> Assertions.assertFalse(logos.isEmpty(),
                        "Не найдено ни одного логотипа"));
    }
    @Test
    public void servis() {
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement link = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        link.click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                                driver.getCurrentUrl());
    }
    @Test
    public void testButton() {
        driver.get("https://www.mts.by/");
        WebElement phoneInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#connection-phone")
                ));

        phoneInput.sendKeys("297777777");

        WebElement continueButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id=\"pay-connection\"]/button")
                ));

        Assertions.assertTrue(continueButton.isEnabled(),
                "Кнопка должна быть активной");
    }


        @AfterEach
        public void teardown () {
            if (driver != null) {
                driver.quit();
            }
        }
}
