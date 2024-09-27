package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver webDriver;
    //  Локаторы элементов аккордеона, вопросы (свернуты элементы)
    public static final By accordionQuestion1 = By.xpath("//div[@id='accordion__heading-0']");
    public static final By accordionQuestion2 = By.xpath("//div[@id='accordion__heading-1']");
    public static final By accordionQuestion3 = By.xpath("//div[@id='accordion__heading-2']");
    public static final By accordionQuestion4 = By.xpath("//div[@id='accordion__heading-3']");
    public static final By accordionQuestion5 = By.xpath("//div[@id='accordion__heading-4']");
    public static final By accordionQuestion6 = By.xpath("//div[@id='accordion__heading-5']");
    public static final By accordionQuestion7 = By.xpath("//div[@id='accordion__heading-6']");
    public static final By accordionQuestion8 = By.xpath("//div[@id='accordion__heading-7']");

    //  Локаторы элементов аккордеона, ответы (развернутые элементы)
    public static final By accordionAnswer1 = By.xpath("//*[@id='accordion__panel-0']/p");
    public static final By accordionAnswer2 = By.xpath("//*[@id='accordion__panel-1']/p");
    public static final By accordionAnswer3 = By.xpath("//*[@id='accordion__panel-2']/p");
    public static final By accordionAnswer4 = By.xpath("//*[@id='accordion__panel-3']/p");
    public static final By accordionAnswer5 = By.xpath("//*[@id='accordion__panel-4']/p");
    public static final By accordionAnswer6 = By.xpath("//*[@id='accordion__panel-5']/p");
    public static final By accordionAnswer7 = By.xpath("//*[@id='accordion__panel-6']/p");
    public static final By accordionAnswer8 = By.xpath("//*[@id='accordion__panel-7']/p");

    //  Переменная с адресом ресурса
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //  Метод открывает станицу
    public void open() {
        webDriver.get(url);
    }

    //  Метод скролит страницу до аккордеона
    public void scrollToAccordion(By questionLocator) {
        WebElement element = webDriver.findElement(questionLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //  Метод кликает на элементы аккордеона
    public void clickAccordionItem(By questionLocator) {
        webDriver.findElement(questionLocator).click();
    }

    //  Метод получает текст из раскрываемых элементов аккордеонна
    public String getActualAnswer(By answerLockator) {
        return webDriver.findElement(answerLockator).getText();
    }
}