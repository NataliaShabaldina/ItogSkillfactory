

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Set;


public class TestSkillfactory {
    private WebDriver driver;
    private WebDriverWait wait;

    private final String linkMainPage = "https://skillfactory.ru/";
    //next на слайдах Отзывы работодателей
    private final By elementNextSlide = By.xpath("//div[@aria-label=\"Next slide\"]");
    //prev на слайдах Отзывы работодателей
    private final By elementPrevSlide = By.xpath("//div[@aria-label=\"Previous slide\"]");

    //поле для ввода имени в форме Оставьте контакты
    private final By elementInputName = By.xpath("//input[@aria-label=\"name\"]");

    //поле для ввода емейла в форме Оставьте контакты
    private final By elementInputEmail = By.xpath("//input[@aria-label=\"email\"]");

    //поле для ввода телефона в форме Оставьте контакты
    private final By elementInputTel = By.id("input_1676828667932");

    // кнопка Отправить в форме Оставьте контакты
    private final By elementSubmitForm = By.cssSelector(".tn-form__submit > .t-submit");


    //элемент-обработка ошибки при вводе имени в форме Оставьте контакты
    private final By elementErrorName = By.cssSelector(".js-error-control-box:nth-child(1) .t-input-error");

    //элемент-обработка ошибки при вводе емейла в форме Оставьте контакты
    private final By elementErrorEmail = By.cssSelector(".js-error-control-box:nth-child(2) .t-input-error");

    //элемент-обработка ошибки при вводе телефона в форме Оставьте контакты
    private final By elementErrorTel = By.cssSelector(".js-error-control-box:nth-child(3) .t-input-error");

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk-21\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    //Тест 1. Проверка заголовка главной страницы
    public void checkTitle() {
        driver.get(linkMainPage);
        String expectedTitle = "Онлайн-школа Skillfactory — онлайн-обучение востребованным IT-профессиям";
        String title = driver.getTitle();
        Assert.assertEquals(expectedTitle, title);
        driver.close();
    }

    // Тест 2. Проверка заголовка при переходе по карточке 1

    @Test
    public void checkCard1() {
        driver.get(linkMainPage);

        WebElement input_it = driver.findElement(By.xpath("//a[@class=\"card__link\" ]"));

        input_it.click();

        Set<String> windowHandles=driver.getWindowHandles();
        String lastTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(lastTab);
        String expectedTitle = "Профориентационный курс для новичков «IT-специалист с нуля», курс профориентации в IT: выбор профессии, обучение IT-технологиям с нуля";

        String curTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, curTitle);
        driver.close();

    }

    // Тест 3. Проверка URL при переходе по карточке 2

    @Test
    public void checkCard2() {
        driver.get(linkMainPage);

        WebElement input_it = driver.findElement(By.id("DAPR"));

        input_it.click();

        Set<String> windowHandles=driver.getWindowHandles();
        String lastTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(lastTab);
        String expectedUrl = "https://skillfactory.ru/data-analyst-pro";

        String curUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, curUrl);
        driver.close();

    }

    // Тест 4. Проверка заголовка при переходе по ссылке Отзывы студентов

    @Test
    public void checkFeedBack() {
        driver.get(linkMainPage);

        WebElement input_it = driver.findElement(By.xpath("//a[text()='Отзывы студентов']"));

        input_it.click();

        Set<String> windowHandles=driver.getWindowHandles();
        String lastTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(lastTab);
        String expectedTitle = "Отзывы студентов о курсах Skillfactory - читать";

        String curTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, curTitle);
        driver.close();

    }

    // Тест 5. Проверка URL при переходе по ссылке в шапке "БЕСПЛАТНО"

    @Test
    public void checkFree() {
        driver.get(linkMainPage);

        WebElement input_it = driver.findElement(By.xpath("//a[text()='БЕСПЛАТНО']"));

        input_it.click();

        Set<String> windowHandles=driver.getWindowHandles();
        String lastTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(lastTab);
        String expectedUrl = "https://skillfactory.ru/free-events";

        String curUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, curUrl);
        driver.close();

    }

    // Тест 6. Проверка URL при переходе по ссылке Акции в подвале

    @Test
    public void checkAk() {
        driver.get(linkMainPage);

        WebElement input_it = driver.findElement(By.xpath("//a[text()='Акции']"));

        input_it.click();

        Set<String> windowHandles=driver.getWindowHandles();
        String lastTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(lastTab);
        String expectedUrl = "https://skillfactory.ru/actions";

        String curUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, curUrl);
        driver.close();

    }


    // Тест 7. Проверка заголовка при переходе по ссылке Habr

    @Test
    public void checkHabr() {
        driver.get(linkMainPage);

        WebElement input_it = driver.findElement(By.xpath("//a[@href=\"https://habr.com/ru/company/skillfactory/blog/\"]"));

        input_it.click();

        Set<String> windowHandles=driver.getWindowHandles();
        String lastTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(lastTab);
        String expectedTitle = "Skillfactory, Москва - Учим работать в IT на курсах и в магистратурах / Статьи / Хабр";

        String curTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, curTitle);
        driver.close();

    }

    // Тест 8. Проверка меню Онлайн-курсы в шапке главной страницы - переход по ссылке из submenu

    @Test
    public void checkMenuSubmenu() {
        driver.get(linkMainPage);

        WebElement input_it = driver.findElement(By.xpath("//a[@data-tooltip-menu-id=\"623893182\"]"));

        input_it.click();
        WebElement input_web = driver.findElement(By.xpath("//a[@href=\"https://skillfactory.ru/courses/web-razrabotka\"]"));
        input_web.click();
        Set<String> windowHandles=driver.getWindowHandles();
        String lastTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(lastTab);

        String expectedTitle = "Курсы по веб-разработке | ТОП-15 онлайн-курсов по разработке сайтов";
        String curTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, curTitle);
        driver.close();
    }

    // Тест 9. Проверка сслылок prev и next на слайдах отзывов работодателей
    @Test
    public void checkSlides1() {
        driver.get(linkMainPage);

        WebElement prev_sl = driver.findElement(elementPrevSlide);
        String ariaDisPrev = prev_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisPrev, "true");
        WebElement next_sl = driver.findElement(elementNextSlide);
        String ariaDisNext = next_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisNext, "false");
        driver.close();
    }

    // Тест 10. Проверка сслылок prev и next на слайдах отзывов работодателей - после клика по next
    @Test
    public void checkSlides2() {
        driver.get(linkMainPage);
        WebElement next_sl = driver.findElement(elementNextSlide);
        next_sl.click();

        WebElement prev_sl = driver.findElement(elementPrevSlide);
        String ariaDisPrev = prev_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisPrev, "false");

        String ariaDisNext = next_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisNext, "false");
        driver.close();
    }

    // Тест 11. Проверка сслылок prev и next на слайдах отзывов работодателей- после клика по next, а потом по prev
    @Test
    public void checkSlides3() {
        driver.get(linkMainPage);
        WebElement next_sl = driver.findElement(elementNextSlide);
        next_sl.click();

        WebElement prev_sl = driver.findElement(elementPrevSlide);
        prev_sl.click();
        String ariaDisPrev = prev_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisPrev, "true");

        String ariaDisNext = next_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisNext, "false");
        driver.close();
    }

    // Тест 12. Проверка сслылок prev и next на слайдах отзывов работодателей - после клика по next 3 раза
    @Test
    public void checkSlides4() {
        driver.get(linkMainPage);
        WebElement next_sl = driver.findElement(elementNextSlide);
        for (int i = 0; i < 3; i++) {
            next_sl.click();

            wait.withTimeout(Duration.ofSeconds(10));
            next_sl = driver.findElement(elementNextSlide);

        }
        WebElement prev_sl = driver.findElement(elementPrevSlide);

        String ariaDisPrev = prev_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisPrev, "false");

        String ariaDisNext = next_sl.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisNext, "true");
        driver.close();
    }
    // Тест 13. Проверка формы "Оставьте контакты"- ввод всех пустьх значений
    @Test
    public void checkForm1() {
        driver.get(linkMainPage);
        wait.withTimeout(Duration.ofSeconds(20));
        driver.findElement(elementSubmitForm).click();
        WebElement error1= driver.findElement(elementErrorName);
        WebElement error2= driver.findElement(elementErrorEmail);
        WebElement error3= driver.findElement(elementErrorTel);
        String expectedErrorMessage = "Обязательное поле";
        Assert.assertEquals(error1.getAttribute("innerHTML"), expectedErrorMessage);
        Assert.assertEquals(error2.getAttribute("innerHTML"), expectedErrorMessage);
        Assert.assertEquals(error3.getAttribute("innerHTML"), expectedErrorMessage);
        driver.close();
    }

    // Тест 14. Проверка формы "Оставьте контакты" - ввод корректного имени, некорректного емейла и короткого телефонного номера
    @Test
    public void checkForm2() {
        driver.get(linkMainPage);
        wait.withTimeout(Duration.ofSeconds(20));
        WebElement input_name = driver.findElement(elementInputName);
        input_name.sendKeys("Masha");
        WebElement input_email = driver.findElement(elementInputEmail);
        input_email.sendKeys("Masha");
        WebElement input_name_record = driver.findElement(elementInputTel);
        input_name_record.sendKeys("23");
        driver.findElement(elementSubmitForm).click();
        WebElement error2= driver.findElement(elementErrorEmail);
        WebElement error3= driver.findElement(elementErrorTel);
        String expectedErrorMessage2 = "Укажите, пожалуйста, корректный email";
        String expectedErrorMessage3 = "Слишком короткое значение";
        Assert.assertEquals(error2.getAttribute("innerHTML"), expectedErrorMessage2);
        Assert.assertEquals(error3.getAttribute("innerHTML"), expectedErrorMessage3);
        driver.close();
    }

    // Тест 15. Проверка формы "Оставьте контакты"- ввод цифр вместо имени, телефонного номера 0000000000
    @Test
    public void checkForm3() {
        driver.get(linkMainPage);
        wait.withTimeout(Duration.ofSeconds(20));
        WebElement input_name = driver.findElement(elementInputName);
        input_name.sendKeys("999");
        WebElement input_email = driver.findElement(elementInputEmail);
        input_email.sendKeys("a@b.com");
        WebElement input_name_record = driver.findElement(elementInputTel);
        input_name_record.sendKeys("0000000000");
        driver.findElement(elementSubmitForm).click();
        WebElement error1= driver.findElement(elementErrorName);
        WebElement error3= driver.findElement(elementErrorTel);
        String expectedErrorMessage1 = "Укажите, пожалуйста, имя";
        String expectedErrorMessage3 = "Укажите, пожалуйста, корректный номер телефона";
        Assert.assertEquals(error1.getAttribute("innerHTML"), expectedErrorMessage1);
        Assert.assertEquals(error3.getAttribute("innerHTML"), expectedErrorMessage3);
        driver.close();
    }

    @After
    public void quit() {

        driver.quit();
    }

}
