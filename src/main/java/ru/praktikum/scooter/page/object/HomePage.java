package ru.praktikum.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.scooter.ConstantsForTests;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HomePage {
    private final WebDriver webDriver;
    //  Локаторы элементов аккордеона, вопросы (свернуты элементы)
    private static final By accordionQuestion1 = By.xpath("//div[@id='accordion__heading-0']");
    private static final By accordionQuestion2 = By.xpath("//div[@id='accordion__heading-1']");
    private static final By accordionQuestion3 = By.xpath("//div[@id='accordion__heading-2']");
    private static final By accordionQuestion4 = By.xpath("//div[@id='accordion__heading-3']");
    private static final By accordionQuestion5 = By.xpath("//div[@id='accordion__heading-4']");
    private static final By accordionQuestion6 = By.xpath("//div[@id='accordion__heading-5']");
    private static final By accordionQuestion7 = By.xpath("//div[@id='accordion__heading-6']");
    private static final By accordionQuestion8 = By.xpath("//div[@id='accordion__heading-7']");
    // Локатор ответов
    private static final By answerElement = By.xpath("//div[not(@hidden) and contains(@id,'accordion__panel')]");

    //  Переменная с адресом ресурса
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //  Метод открывает станицу
    public void open() {
        webDriver.get(url);
    }

    // Метод сравнивает значения текста ответа с константами
    public void checkActualAnswer(String text) {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(answerElement)));
        assertEquals("Текст в панели аккордеона не соответствует требованию",
                text, webDriver.findElement(answerElement).getText());
    }

    //  Метод скролит страницу до аккордеона
    public void scrollToAccordion(String text) {
        WebElement element = webDriver.findElement(getAccordionQuestion(text));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // Метод скроллит до ответа
    public void scrollToAnswer() {
        WebElement element = webDriver.findElement(answerElement);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //  Метод кликает на элементы аккордеона
    public void clickAccordionItem(String text) {
        webDriver.findElement(getAccordionQuestion(text)).click();
    }

    // Метод получает ответ в каждом из элементов аккордеона
    private By getAccordionQuestion(String text) {
        By questionLocator = null;
        switch (text) {
            case ConstantsForTests.EXPECTED_ANSWER_1:
                questionLocator = accordionQuestion1;
                break;
            case ConstantsForTests.EXPECTED_ANSWER_2:
                questionLocator = accordionQuestion2;
                break;
            case ConstantsForTests.EXPECTED_ANSWER_3:
                questionLocator = accordionQuestion3;
                break;
            case ConstantsForTests.EXPECTED_ANSWER_4:
                questionLocator = accordionQuestion4;
                break;
            case ConstantsForTests.EXPECTED_ANSWER_5:
                questionLocator = accordionQuestion5;
                break;
            case ConstantsForTests.EXPECTED_ANSWER_6:
                questionLocator = accordionQuestion6;
                break;
            case ConstantsForTests.EXPECTED_ANSWER_7:
                questionLocator = accordionQuestion7;
                break;
            case ConstantsForTests.EXPECTED_ANSWER_8:
                questionLocator = accordionQuestion8;
                break;
        }
        return questionLocator;
    }
}