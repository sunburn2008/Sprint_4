package ru.praktikum.scooter.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.praktikum.scooter.ConstantsForTests.*;

public class OrderPages {

    WebDriver webDriver;

    public OrderPages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //  Методы выполнения шагов, думаю понятно все с ними))
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

    public void sendValueToPhoneNumber(String phoneNumber) {
        webDriver.findElement(PHONE_NUMBER_LOCATOR).sendKeys(phoneNumber);
    }

    public void clickToNextButton() {
        webDriver.findElement(NEXT_BUTTON).click();
    }

    public void clickToCalendarField() {
        webDriver.findElement(CALENDAR_FIELD).click();
    }

    public void clickToRentalPeriodField() {
        webDriver.findElement(RENTAL_PERIOD_FIELD).click();
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

    public void checkText() {
        webDriver.findElement(ORDER_HAS_PLACED).isDisplayed();
    }

    //  Методы возвразают элемент страницы для разных тестов
    private By elementOrderButton(String elementButton) {
        By elementLocator;
        if (elementButton.equals(BUTTON_TOP)) {
            elementLocator = ORDER_BUTTON_ON_MAIN_PAGE_TOP;
        } else {
            elementLocator = ORDER_BUTTON_ON_MAIN_PAGE_BOTTOM;
        }
        return elementLocator;
    }

    private By elementMetroStation(String elementMetro) {
        By metroStationLocator;
        if (elementMetro.equals(METRO_STATION_NAME_1)) {
            metroStationLocator = METRO_STATION_LUBYANKA;
        } else {
            metroStationLocator = METRO_STATION_TRUBNAYA;
        }
        return metroStationLocator;
    }

    private By elementDeliveryDayLocator(String elementDeliveryDay) {
        By deliveryDayLocator;
        if (elementDeliveryDay.equals(DELIVERY_DAY_TEXT_1)) {
            deliveryDayLocator = DELIVERY_DATE_VALUE_20;
        } else {
            deliveryDayLocator = DELIVERY_DATE_VALUE_02;
        }
        return deliveryDayLocator;
    }

    private By elementRentalPeriodLocator(String elementRentalPeriod) {
        By rentalPeriodLocator;
        if (elementRentalPeriod.equals(DELIVERY_DAY_VALUE_1)) {
            rentalPeriodLocator = RENTAL_PERIOD_VALUE_5;
        } else {
            rentalPeriodLocator = RENTAL_PERIOD_VALUE_1;
        }
        return rentalPeriodLocator;
    }

    private By elementColorLocator(String elementColor) {
        By colorLocator;
        if (elementColor.equals(COLOR_1)) {
            colorLocator = COLOR_BLACK_CHECKBOX;
        } else {
            colorLocator = COLOR_GREY_CHECKBOX;
        }
        return colorLocator;
    }

    //  Методы выполняют действие с выбранным элеменом
    public void clickToOrderButton(String elementButton) {
        webDriver.findElement(elementOrderButton(elementButton)).click();
    }

    public void clickToMetroStation(String elementMetroStation) {
        webDriver.findElement(elementMetroStation(elementMetroStation)).click();
    }

    public void clickToDeliveryDay(String elementDeliveryDay) {
        webDriver.findElement(elementDeliveryDayLocator(elementDeliveryDay)).click();
    }

    public void clickToRentalPeriod(String elementRentalPeriod) {
        webDriver.findElement(elementRentalPeriodLocator(elementRentalPeriod)).click();
    }

    public void clickToColor(String elementColor) {
        webDriver.findElement(elementColorLocator(elementColor)).click();
    }
}

