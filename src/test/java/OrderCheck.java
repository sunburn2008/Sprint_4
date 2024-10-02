import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.scooter.ConstantsForTests;
import ru.praktikum.scooter.page.object.HomePage;
import ru.praktikum.scooter.page.object.OrderPages;

@RunWith(Parameterized.class)
public class OrderCheck {
    WebDriver webDriver;
    //  Переменные класса
    private final String elementButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String elementMetroStation;
    private final String phoneNumber;
    private final String elementDeliveryDay;
    private final String elementRentalPeriod;
    private final String elementColor;
    private final String commentForTheCourier;

    // конструктор класса
    public OrderCheck(String elementButton,
                      String name,
                      String surname,
                      String address,
                      String elementMetroStation,
                      String phoneNumber,
                      String elementDeliveryDay,
                      String elementRentalPeriod,
                      String elementColor,
                      String commentForTheCourier) {

        this.elementButton = elementButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.elementMetroStation = elementMetroStation;
        this.phoneNumber = phoneNumber;
        this.elementDeliveryDay = elementDeliveryDay;
        this.elementRentalPeriod = elementRentalPeriod;
        this.elementColor = elementColor;
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
                {ConstantsForTests.BUTTON_TOP,
                        ConstantsForTests.USER_NAME_1,
                        ConstantsForTests.USER_SURNAME_1,
                        ConstantsForTests.USER_ADDRESS_1,
                        ConstantsForTests.METRO_STATION_NAME_1,
                        ConstantsForTests.USER_PHONE_NUMBER_1,
                        ConstantsForTests.DELIVERY_DAY_TEXT_1,
                        ConstantsForTests.DELIVERY_DAY_VALUE_1,
                        ConstantsForTests.COLOR_1,
                        ConstantsForTests.COMMENT_FOR_THE_COURIER_1,},

                {ConstantsForTests.BUTTON_BOTTOM,
                        ConstantsForTests.USER_NAME_2,
                        ConstantsForTests.USER_SURNAME_2,
                        ConstantsForTests.USER_ADDRESS_2,
                        ConstantsForTests.METRO_STATION_NAME_2,
                        ConstantsForTests.USER_PHONE_NUMBER_2,
                        ConstantsForTests.DELIVERY_DAY_TEXT_2,
                        ConstantsForTests.DELIVERY_DAY_VALUE_2,
                        ConstantsForTests.COLOR_2,
                        ConstantsForTests.COMMENT_FOR_THE_COURIER_2,},
        };
    }

    //  Сам тест, вызываем методы
    @Test
    public void OrderTest() {
        HomePage homePage = new HomePage(webDriver);
        OrderPages orderPages = new OrderPages(webDriver);
        homePage.open();
        orderPages.findCookiesField();
        orderPages.clickToOrderButton(elementButton);
        orderPages.sendValueToFirstName(name);
        orderPages.sendValueToSurname(surname);
        orderPages.sendValueToAddress(address);
        orderPages.clickToMetroStationField();
        orderPages.clickToMetroStation(elementMetroStation);
        orderPages.sendValueToPhoneNumber(phoneNumber);
        orderPages.clickToNextButton();
        orderPages.clickToCalendarField();
        orderPages.clickToDeliveryDay(elementDeliveryDay);
        orderPages.clickToRentalPeriodField();
        orderPages.clickToRentalPeriod(elementRentalPeriod);
        orderPages.clickToColor(elementColor);
        orderPages.sendValueToCommentForTheCourier(commentForTheCourier);
        orderPages.clickToOrderButtonOnSecondPage();
        orderPages.clickYesButton();

//  Проверяем, что появилось модальное окно с сообщением об успешном заказе
        orderPages.checkText();
    }

    // Закрываем браузер
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
