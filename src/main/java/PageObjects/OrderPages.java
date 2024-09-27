package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPages {

    WebDriver webDriver;
    //  Локаторы элементов по всему сценарию теста
    public static final By ORDER_BUTTON_ON_MAIN_PAGE_TOP = By.xpath(".//button[@class='Button_Button__ra12g']");
    public static final By ORDER_BUTTON_ON_MAIN_PAGE_BOTTOM = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By FIRST_NAME = By.xpath(".//input[contains(@placeholder,'* Имя')]");
    public static final By SURNAME = By.xpath(".//input[contains(@placeholder,'* Фамилия')]");
    public static final By ADDRESS_FIELD = By.xpath(".//input[contains(@placeholder,'* Адрес: куда привезти заказ')]");
    public static final By COLOR_GREY_CHECKBOX = By.xpath(".//label[@for='grey']");
    public static final By COLOR_BLACK_CHECKBOX = By.xpath(".//label[@for='black']");
    public static final By METRO_STATION_FIELD = By.xpath(".//input[contains(@placeholder,'* Станция метро')]");
    public static final By METRO_STATION_LUBYANKA = By.xpath(".//div[contains(text(),'Лубянка')]");
    public static final By METRO_STATION_TRUBNAYA = By.xpath(".//div[contains(text(),'Трубная')]");
    public static final By PHONE_NUMBER_LOCATOR = By.xpath(".//input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");
    public static final By NEXT_BUTTON = By.xpath(".//button[contains(text(),'Далее')]");
    public static final By CALENDAR_FIELD = By.xpath(".//input[contains(@placeholder,'* Когда привезти самокат')]");
    public static final By DELIVERY_DATE_VALUE_20 = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--020']");
    public static final By DELIVERY_DATE_VALUE_02 = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--002']");
    public static final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class='Dropdown-control']");
    public static final By RENTAL_PERIOD_VALUE_5 = By.xpath(".//div[contains(text(),'пятеро суток')]");
    public static final By RENTAL_PERIOD_VALUE_1 = By.xpath(".//div[contains(text(),'сутки')]");
    public static final By COMMENT_FOR_THE_COURIER_LOCATOR = By.xpath(".//input[contains(@placeholder,'Комментарий для курьера')]");
    public static final By ORDER_BUTTON_ON_SECOND_PAGE = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By YES_BUTTON = By.xpath(".//button[contains(text(),'Да')]");
    public static final By ORDER_HAS_PLACED = By.xpath(".//div[contains(text(),'Заказ оформлен')]");
    public static final By COOKIES_FIELD = By.xpath(".//div[contains(text(),'И здесь куки! В общем, мы их используем.')]");
    public static final By COOKIES_CLOSE_BUTTON = By.xpath(".//button[contains(text(),'да все привыкли')]");

    public OrderPages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //  Методы выполнения шагов, думаю понятно все с ними))
    public void clickToOrderButtonOnMainPage(By orderButtonOnMainPage) {
        webDriver.findElement(orderButtonOnMainPage).click();
    }

    public void sendValueToFirstName(String name) {
        webDriver.findElement(FIRST_NAME).sendKeys(name);
    }

    public void sendValueToSurname(String surname) {
        webDriver.findElement(SURNAME).sendKeys(surname);
    }

    public void sendValueToAddress(String address) {
        webDriver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    public void clickToMetroStationField() {
        webDriver.findElement(METRO_STATION_FIELD).click();
    }

    public void clickToMetroStationValue(By metroStationValue) {
        webDriver.findElement(metroStationValue).click();
    }

    public void sendValueToPhoneNumber(String phoneNumber) {
        webDriver.findElement(PHONE_NUMBER_LOCATOR).sendKeys(phoneNumber);
    }

    public void clickToNextButton() {
        webDriver.findElement(NEXT_BUTTON).click();
    }

    public void clickToCalendarField() {
        webDriver.findElement(CALENDAR_FIELD).click();
    }

    public void clickToDeliveryDateValue(By deliveryDateValue) {
        webDriver.findElement(deliveryDateValue).click();
    }

    public void clickToRentalPeriodField() {
        webDriver.findElement(RENTAL_PERIOD_FIELD).click();
    }

    public void clickToRentalPeriodValue(By rentalPeriodValue) {
        webDriver.findElement(rentalPeriodValue).click();
    }

    public void clickToColor(By color) {
        webDriver.findElement(color).click();
    }

    public void sendValueToCommentForTheCourier(String commentForTheCourier) {
        webDriver.findElement(COMMENT_FOR_THE_COURIER_LOCATOR).sendKeys(commentForTheCourier);
    }

    public void clickToOrderButtonOnSecondPage() {
        webDriver.findElement(ORDER_BUTTON_ON_SECOND_PAGE).click();
    }

    public void clickYesButton() {
        webDriver.findElement(YES_BUTTON).click();
    }

    public void findCookiesField() {
        if (webDriver.findElement(COOKIES_FIELD).isDisplayed()) {
            webDriver.findElement(COOKIES_CLOSE_BUTTON).click();
        }
    }

}
