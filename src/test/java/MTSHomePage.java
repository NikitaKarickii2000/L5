import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MTSHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Element locators
    private final By cookieAcceptButtonLocator = By.xpath("//*[@id=\"cookie-agree\"]");
    private final By onlinePaymentBlockTitleLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private final By logosListLocator = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul");
    private final By paymentHelpLinkLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");
    private final By phoneInputLocator = By.xpath("//*[@id='connection-phone']");
    private final By sumInputLocator = By.xpath("//*[@id='connection-sum']");
    private final By continueButtonLocator = By.xpath("//*[@id=\"pay-connection\"]/button");

    // Payment options locators
    private final By paymentOptionsButtonLocator = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By communicationServicesOptionLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p");
    private final By homeInternetOptionLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p");
    private final By installmentOptionLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p");
    private final By debtOptionLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p");

    // Payment page locators - обновленные локаторы
    private final By paymentContainerLocator = By.xpath("//app-payment-container | //div[contains(@class, 'payment-wrapper')]");
    private final By displayedAmountLocator = By.xpath("//app-payment-container//span[contains(@class, 'amount')] | //div[contains(@class, 'amount')]");
    private final By payButtonAmountLocator = By.xpath("//button[contains(@class, 'pay-button')] | //button[contains(text(), 'Заплатить')]");
    private final By phoneNumberLabelLocator = By.xpath("//label[contains(text(), 'телефона')] | //div[contains(text(), 'телефона')]");
    private final By cardNumberLabelLocator = By.xpath("//label[contains(text(), 'карты')] | //div[contains(text(), 'карты')]");
    private final By cardExpiryLabelLocator = By.xpath("//label[contains(text(), 'действия')] | //div[contains(text(), 'действия')]");
    private final By paymentIconsLocator = By.cssSelector(".icons-container, .payment-icons");

    public MTSHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Увеличиваем таймаут ожидания
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public void acceptCookies() {
        try {
            WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButtonLocator));
            cookieAcceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieAcceptButton));
        } catch (Exception e) {
            System.out.println("Кнопка принятия файлов cookie не найдена или неактивна: " + e.getMessage());
        }
    }

    public String getOnlinePaymentBlockTitle() {
        WebElement block = driver.findElement(onlinePaymentBlockTitleLocator);
        return block.getText();
    }

    public List<WebElement> getPaymentPartnerLogos() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(logosListLocator));
    }

    public void clickPaymentHelpLink() {
        WebElement link = driver.findElement(paymentHelpLinkLocator);
        link.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(phoneInputLocator));
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        WebElement sumInput = wait.until(ExpectedConditions.presenceOfElementLocated(sumInputLocator));
        sumInput.clear();
        sumInput.sendKeys(amount);
    }

    public void clickContinueButton() {
        try {
            // Закрываем возможные всплывающие окна
            try {
                WebElement closePopup = driver.findElement(By.xpath("//button[contains(@class, 'close')] | //div[contains(@class, 'close')]"));
                if (closePopup.isDisplayed()) {
                    closePopup.click();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                // Если всплывающего окна нет, просто продолжаем
            }

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
            // Прокручиваем страницу к кнопке, чтобы она была видна
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", continueButton);

            Thread.sleep(1500);

            // Пробуем сначала клик с помощью JavaScript
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);

            // На всякий случай проверяем и делаем обычный клик
            if (continueButton.isEnabled() && continueButton.isDisplayed()) {
                Thread.sleep(500);
                continueButton.click();
            }

            // Ожидаем завершения перехода на новую страницу
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Ошибка при нажатии на кнопку: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean isContinueButtonEnabled() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        return continueButton.isEnabled();
    }

    public void clickPaymentOptionsButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(paymentOptionsButtonLocator));
        button.click();
    }

    public void selectCommunicationServicesOption() {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(communicationServicesOptionLocator));
        option.click();
    }

    public String getCommunicationServicesOptionText() {
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(communicationServicesOptionLocator));
        return option.getText();
    }

    public String getHomeInternetOptionText() {
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(homeInternetOptionLocator));
        return option.getText();
    }

    public String getInstallmentOptionText() {
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(installmentOptionLocator));
        return option.getText();
    }

    public String getDebtOptionText() {
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(debtOptionLocator));
        return option.getText();
    }

    // Payment page methods

    public void waitForPaymentContainer() {
        try {
            // Проверяем изменение URL как признак перехода на страницу оплаты
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Текущий URL: " + currentUrl);

            // Добавляем паузу перед проверкой видимости
            Thread.sleep(3000);

            // Добавляем проверку наличия iframe
            try {
                java.util.List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
                if (!iframes.isEmpty()) {
                    System.out.println("Найдено " + iframes.size() + " iframe");

                    // Переключаемся на первый iframe
                    driver.switchTo().frame(0);
                    Thread.sleep(1000);
                    System.out.println("Переключились на iframe");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при проверке iframe: " + e.getMessage());
            }

            // Используем более общие локаторы
            try {
                boolean containerFound = false;

                // Пробуем разные варианты локаторов для страницы оплаты
                String[] possibleLocators = {
                        "//app-payment-container",
                        "//div[contains(@class, 'payment-wrapper')]",
                        "//div[contains(@class, 'payment')]",
                        "//div[contains(@class, 'card-page')]",
                        "//form[contains(@class, 'payment')]",
                        "//form[contains(@class, 'card')]"
                };

                for (String locator : possibleLocators) {
                    try {
                        WebElement element = driver.findElement(By.xpath(locator));
                        if (element.isDisplayed()) {
                            System.out.println("Найден элемент по локатору: " + locator);
                            containerFound = true;
                            break;
                        }
                    } catch (Exception e) {
                        // Продолжаем проверку следующих локаторов
                    }
                }

                if (!containerFound) {
                    // Делаем скриншот для диагностики
                    try {
                        org.openqa.selenium.TakesScreenshot ts = (org.openqa.selenium.TakesScreenshot) driver;
                        java.io.File screenshot = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
                        java.nio.file.Files.copy(
                                screenshot.toPath(),
                                new java.io.File("payment-page-debug.png").toPath(),
                                java.nio.file.StandardCopyOption.REPLACE_EXISTING
                        );
                        System.out.println("Сделан скриншот для диагностики: payment-page-debug.png");
                    } catch (Exception e) {
                        System.out.println("Не удалось сделать скриншот: " + e.getMessage());
                    }

                    System.out.println("HTML страницы: " + driver.getPageSource().substring(0, 500) + "...");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при поиске элементов страницы оплаты: " + e.getMessage());
            }

            // Если переключились на iframe, возвращаемся в основной контекст
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("Общая ошибка при ожидании контейнера оплаты: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getDisplayedAmount() {
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(displayedAmountLocator));
        return amountElement.getText();
    }

    public String getPayButtonAmount() {
        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(payButtonAmountLocator));
        return payButton.getText();
    }

    public String getPhoneNumberLabel() {
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberLabelLocator));
        return label.getText();
    }

    public String getCardNumberLabel() {
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabelLocator));
        return label.getText();
    }

    public String getCardExpiryLabel() {
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryLabelLocator));
        return label.getText();
    }

    public boolean arePaymentIconsDisplayed() {
        try {
            WebElement iconsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIconsLocator));
            return iconsContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to perform common steps for payment flow
    public void initiatePaymentFlow(String phoneNumber, String amount) {
        enterPhoneNumber(phoneNumber);
        enterAmount(amount);
        clickContinueButton();
        waitForPaymentContainer();
    }
}