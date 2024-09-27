import PageObjects.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScooterTest {
    WebDriver webDriver;
    //    Переменные класса
    private final String expectedResult;
    private final By answerLocator;
    private final By questionLocator;

    //  Конструктор
    public ScooterTest(String expectedResult, By answerLocator, By questionLocator) {
        this.expectedResult = expectedResult;
        this.answerLocator = answerLocator;
        this.questionLocator = questionLocator;
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
                {ConstantsForTests.EXPECTED_ANSWER_1, HomePage.accordionAnswer1, HomePage.accordionQuestion1},
                {ConstantsForTests.EXPECTED_ANSWER_2, HomePage.accordionAnswer2, HomePage.accordionQuestion2},
                {ConstantsForTests.EXPECTED_ANSWER_3, HomePage.accordionAnswer3, HomePage.accordionQuestion3},
                {ConstantsForTests.EXPECTED_ANSWER_4, HomePage.accordionAnswer4, HomePage.accordionQuestion4},
                {ConstantsForTests.EXPECTED_ANSWER_5, HomePage.accordionAnswer5, HomePage.accordionQuestion5},
                {ConstantsForTests.EXPECTED_ANSWER_6, HomePage.accordionAnswer6, HomePage.accordionQuestion6},
                {ConstantsForTests.EXPECTED_ANSWER_7, HomePage.accordionAnswer7, HomePage.accordionQuestion7},
                {ConstantsForTests.EXPECTED_ANSWER_8, HomePage.accordionAnswer8, HomePage.accordionQuestion8},
        };
    }

    @Test
    public void checkValueItemPanel() {
        HomePage homePage = new HomePage(webDriver);
//  Вызываем методы для выполнения шагов
        homePage.open();
        homePage.scrollToAccordion(questionLocator);
        homePage.clickAccordionItem(questionLocator);
//  Сравниваем текст из ответов аккордеоена с заданными константами

        assertEquals("Текст в панели аккордеона не соответствует требованию",
                expectedResult, homePage.getActualAnswer(answerLocator));
    }

    //  Закарываем браузер
    @After
    public void tearDown() {
        webDriver.quit();
    }
}

