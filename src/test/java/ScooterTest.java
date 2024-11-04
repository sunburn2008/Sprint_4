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

@RunWith(Parameterized.class)
public class ScooterTest {
    WebDriver webDriver;
    //    Переменные класса
    private final String expectedResult;

    //  Конструктор
    public ScooterTest(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        webDriver = new ChromeDriver(options);
    }

    //  Параметры для переметризованного теста
    @Parameterized.Parameters
    public static Object[][] results() {
        return new Object[][]{
                {ConstantsForTests.EXPECTED_ANSWER_1},
                {ConstantsForTests.EXPECTED_ANSWER_2},
                {ConstantsForTests.EXPECTED_ANSWER_3},
                {ConstantsForTests.EXPECTED_ANSWER_4},
                {ConstantsForTests.EXPECTED_ANSWER_5},
                {ConstantsForTests.EXPECTED_ANSWER_6},
                {ConstantsForTests.EXPECTED_ANSWER_7},
                {ConstantsForTests.EXPECTED_ANSWER_8},
        };
    }

    @Test
    public void checkValueItemPanel() {
        HomePage homePage = new HomePage(webDriver);

//  Вызываем методы для выполнения шагов
        homePage.open();
        homePage.scrollToAccordion(expectedResult);
        homePage.clickAccordionItem(expectedResult);
        homePage.scrollToAnswer();

//  Вызываем метод сравнения текстов аккордеона с заданными константами
        homePage.checkActualAnswer(expectedResult);
    }

    //  Закарываем браузер
    @After
    public void tearDown() {
        webDriver.quit();
    }
}

