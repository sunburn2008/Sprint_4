import PageObjects.HomePage;
import PageObjects.OrderPages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderCheck {
    WebDriver webDriver;
    //  Переменные класса
    private final By orderButtonOnMainPage;
    private final String name;
    private final String surname;
    private final String address;
    private final By metroStationValue;
    private final String phoneNumber;
    private final By deliveryDateValue;
    private final By rentalPeriodValue;
    private final By color;
    private final String commentForTheCourier;

    // конструктор класса
    public OrderCheck(By orderButtonOnMainPage, String name, String surname, String address, By metroStationValue,
                      String phoneNumber, By deliveryDateValue, By rentalPeriodValue, By color, String commentForTheCourier) {
        this.orderButtonOnMainPage = orderButtonOnMainPage;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationValue = metroStationValue;
        this.phoneNumber = phoneNumber;
        this.deliveryDateValue = deliveryDateValue;
        this.rentalPeriodValue = rentalPeriodValue;
        this.color = color;
        this.commentForTheCourier = commentForTheCourier;
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        webDriver = new ChromeDriver(options);
    }

    //  Параметры для параметризованного теста
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {OrderPages.ORDER_BUTTON_ON_MAIN_PAGE_TOP,
                        ConstantsForTests.USER_NAME_1,
                        ConstantsForTests.USER_SURNAME_1,
                        ConstantsForTests.USER_ADDRESS_1,
                        OrderPages.METRO_STATION_LUBYANKA,
                        ConstantsForTests.USER_PHONE_NUMBER_1,
                        OrderPages.DELIVERY_DATE_VALUE_20,
                        OrderPages.RENTAL_PERIOD_VALUE_5,
                        OrderPages.COLOR_BLACK_CHECKBOX,
                        ConstantsForTests.COMMENT_FOR_THE_COURIER_1,},

                {OrderPages.ORDER_BUTTON_ON_MAIN_PAGE_BOTTOM,
                        ConstantsForTests.USER_NAME_2,
                        ConstantsForTests.USER_SURNAME_2,
                        ConstantsForTests.USER_ADDRESS_2,
                        OrderPages.METRO_STATION_TRUBNAYA,
                        ConstantsForTests.USER_PHONE_NUMBER_2,
                        OrderPages.DELIVERY_DATE_VALUE_02,
                        OrderPages.RENTAL_PERIOD_VALUE_1,
                        OrderPages.COLOR_GREY_CHECKBOX,
                        ConstantsForTests.COMMENT_FOR_THE_COURIER_2,},
        };
    }

    //  Сам тест, вызываем методы из класса "PageObjects.OrderPages"
    @Test
    public void OrderTest() {
        HomePage homePage = new HomePage(webDriver);
        OrderPages orderPages = new OrderPages(webDriver);
        homePage.open();
        orderPages.findCookiesField();
        orderPages.clickToOrderButtonOnMainPage(orderButtonOnMainPage);
        orderPages.sendValueToFirstName(name);
        orderPages.sendValueToSurname(surname);
        orderPages.sendValueToAddress(address);
        orderPages.clickToMetroStationField();
        orderPages.clickToMetroStationValue(metroStationValue);
        orderPages.sendValueToPhoneNumber(phoneNumber);
        orderPages.clickToNextButton();
        orderPages.clickToCalendarField();
        orderPages.clickToDeliveryDateValue(deliveryDateValue);
        orderPages.clickToRentalPeriodField();
        orderPages.clickToRentalPeriodValue(rentalPeriodValue);
        orderPages.clickToColor(color);
        orderPages.sendValueToCommentForTheCourier(commentForTheCourier);
        orderPages.clickToOrderButtonOnSecondPage();
        orderPages.clickYesButton();
//  Проверяем, что появилось модальное окно с сообщением об успешном заказе
        assertTrue("Не появилось всплывающее окно с сообщением об успешном создании заказа",
                webDriver.findElement(OrderPages.ORDER_HAS_PLACED).isDisplayed());
    }

    // Закрываем браузер
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
