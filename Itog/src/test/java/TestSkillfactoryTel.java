import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@RunWith(Parameterized.class)
public class TestSkillfactoryTel {
    private WebDriver driver;
    private WebDriverWait wait;

    private final String linkMainPage = "https://skillfactory.ru/";
    //поле для ввода телефона в форме Оставьте контакты
    private final By elementInputTel = By.id("input_1676828667932");

    private String input;
    private String expected;

    public TestSkillfactoryTel(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection inputs (){
        return Arrays.asList(new Object[][] {{"5555555555", "(555) 555-55-55"}, {"abc", ""}, {"abc5555555555", "(555) 555-55-55"}, {"5b6", "(56"}, {"5555555555555555555", "(555) 555-55-55"}});
    }

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk-21\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String checkTel (String inp) {
        driver.get(linkMainPage);
        WebElement input = driver.findElement(elementInputTel);
        input.sendKeys(inp);
        return input.getAttribute("value");


    }
    @Test
    public void test(){
        Assert.assertEquals(expected, checkTel(input));
    }


    @After
    public void quit() {

        driver.quit();
    }

}
