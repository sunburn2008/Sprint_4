package ru.praktikum.scooter;

import org.openqa.selenium.By;

public class ConstantsForTests {

    //  Текст, который мы ждем при раскрытии элементов аккордеона
    public static final String EXPECTED_ANSWER_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String EXPECTED_ANSWER_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String EXPECTED_ANSWER_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String EXPECTED_ANSWER_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXPECTED_ANSWER_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String EXPECTED_ANSWER_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String EXPECTED_ANSWER_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String EXPECTED_ANSWER_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //  Локаторы для теста заказа
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
    public static final By DELIVERY_DATE_VALUE_20 = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--020 react-datepicker__day--weekend']");
    public static final By DELIVERY_DATE_VALUE_02 = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--002 react-datepicker__day--keyboard-selected react-datepicker__day--today']");
    public static final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class='Dropdown-control']");
    public static final By RENTAL_PERIOD_VALUE_5 = By.xpath(".//div[contains(text(),'пятеро суток')]");
    public static final By RENTAL_PERIOD_VALUE_1 = By.xpath(".//div[contains(text(),'сутки')]");
    public static final By COMMENT_FOR_THE_COURIER_LOCATOR = By.xpath(".//input[contains(@placeholder,'Комментарий для курьера')]");
    public static final By ORDER_BUTTON_ON_SECOND_PAGE = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By YES_BUTTON = By.xpath(".//button[contains(text(),'Да')]");
    public static final By ORDER_HAS_PLACED = By.xpath(".//div[contains(text(),'Заказ оформлен')]");
    public static final By COOKIES_FIELD = By.xpath(".//div[contains(text(),'И здесь куки! В общем, мы их используем.')]");
    public static final By COOKIES_CLOSE_BUTTON = By.xpath(".//button[contains(text(),'да все привыкли')]");

    //  Значения, которые вводим при первом тесте заказа самоката
    public static final String BUTTON_TOP = "Кнопка верхняя";
    public static final String USER_NAME_1 = "Иван";
    public static final String METRO_STATION_NAME_1 = "Лубянка";
    public static final String DELIVERY_DAY_TEXT_1 = "20";
    public static final String DELIVERY_DAY_VALUE_1 = "пятеро суток";
    public static final String COLOR_1 = "чёрный жемчуг";
    public static final String USER_SURNAME_1 = "Таранов";
    public static final String USER_ADDRESS_1 = "ул. Пукшина, д. 5, кв. 15";
    public static final String USER_PHONE_NUMBER_1 = "+74959379992";
    public static final String COMMENT_FOR_THE_COURIER_1 = "Шире шаг!";

    //  Значения, которые вводим при втором тесте заказа самоката
    public static final String BUTTON_BOTTOM = "Кнопка нижняя";
    public static final String USER_NAME_2 = "Таран";
    public static final String METRO_STATION_NAME_2 = "Трубная";
    public static final String DELIVERY_DAY_TEXT_2 = "2";
    public static final String DELIVERY_DAY_VALUE_2 = "двое суток";
    public static final String COLOR_2 = "серая безысходность";
    public static final String USER_SURNAME_2 = "Иванов";
    public static final String USER_ADDRESS_2 = "ул. Колотушкина, д. 0.5, кв. 0.15";
    public static final String USER_PHONE_NUMBER_2 = "88002000600";
    public static final String COMMENT_FOR_THE_COURIER_2 = "Kengroq qadam!";
}
