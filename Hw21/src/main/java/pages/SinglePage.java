package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SinglePage {

    public SelenideElement login = $(By.xpath("//input[@id='user-name']"));
    public SelenideElement password = $(By.xpath("//input[@id='password']"));
    public SelenideElement loginBtn = $(By.xpath("//input[@id='login-button']"));
    public SelenideElement addBtn = $(By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory\"]"));
    public SelenideElement basketBtn = $(By.xpath("//*[@class='shopping_cart_link']"));
    public SelenideElement basketBubble = $(".shopping_cart_badge");
    public SelenideElement checkOut = $(By.xpath("//button[@id='checkout']"));
    public SelenideElement removeBtn = $(By.xpath("//button[text()=\"Remove\"]"));
    public SelenideElement firstName = $(By.xpath("//input[@id='first-name']"));
    public SelenideElement lastName = $(By.xpath("//input[@id='last-name']"));
    public SelenideElement postalCode = $(By.xpath("//input[@id='postal-code']"));
    public SelenideElement continueBtn = $(By.xpath("//input[@id='continue']"));
    public SelenideElement finishBtn = $(By.xpath("//button[@id='finish']"));
    public ElementsCollection cartItem = $$(By.cssSelector(".cart_item"));
    public String checkAllProducts = "//div[text() = '%s']";



}