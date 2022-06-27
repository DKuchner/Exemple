import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    static void setUp() {

        driver = Driver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.tiraet.com/");
    }

    @AfterAll
    static void finish() {
        driver.quit();
    }

    @Test
    @DisplayName("Ввод текста в поле Поиск")
    public void searchText () {

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='title-search-input_fixed']"));
        searchInput.sendKeys("selenium");
        searchInput = driver.findElement(By.xpath("//*[@id='title-search-input_fixed']"));
        String value = searchInput.getAttribute("value");
        assertEquals("selenium", value);
    }

    @Test
    @DisplayName("Нажатие на кнопку Поиск")
    public void searchButton () {

        WebElement searchButton = driver.findElement(By.xpath("//*[@class='btn btn-search']"));
        searchButton.submit();
        String toClick = driver.getTitle();
        assertEquals(toClick, driver.getTitle());
    }

    @Test
    @DisplayName("поиск по ключевому слову ADLER")
    public void searchToledo() {

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='title-search-input_fixed']"));
        searchInput.sendKeys("ADLER");
        WebElement button = driver.findElement(By.xpath("//*[@class='btn btn-search']"));
        button.submit();
        String result = driver.getTitle();
        assertEquals(result, driver.getTitle());
    }

    @Test
    @DisplayName("добавление товара в корзину")
    public void addToBasket() {

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='title-search-input_fixed']"));
        searchInput.sendKeys("SVEN");
        WebElement button = driver.findElement(By.xpath("//*[@class='btn btn-search']"));
        button.submit();
        WebElement product = driver.findElement(By.xpath("//*[@id=\"bx_3966226736_21689\"]"));
        product.click();
        WebElement addToBasket = driver.findElement(By.xpath("//*[@id=\"bx_117848907_21689_basket_actions\"]"));
        addToBasket.click();
        WebElement inBasket = driver.findElement(By.xpath("//*[@id=\"bx_117848907_21689_basket_actions\"]/a"));
        inBasket.click();
        String atBasket = driver.getTitle();
        assertEquals(atBasket, driver.getTitle());
    }

    @Test
    @DisplayName("поиск по пустой строке")
    public void citySelection() {

        WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"bx_breadcrumb_0\"]"));
        mainPage.click();
        WebElement button = driver.findElement(By.xpath("//*[@class='btn btn-search']"));
        button.submit();
        String emptySearch = driver.getTitle();
        assertEquals(emptySearch, driver.getTitle());
    }

    @Test
    @DisplayName("переход во вкладку информация")
    public void buttonSale() {

        WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"bx_breadcrumb_0\"]"));
        mainPage.click();
        WebElement pageSale = driver.findElement(By.xpath("//*[@id=\"bottom_info\"]"));
        pageSale.click();
        String sale = driver.getTitle();
        assertEquals(sale, driver.getTitle());
    }

}