package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class InformationPage {
    public SelenideElement firstName = $(By.xpath("//input[@id='first-name']"));
    public SelenideElement lastName = $(By.xpath("//input[@id='last-name']"));
    public SelenideElement postalCode = $(By.xpath("//input[@id='postal-code']"));
    public SelenideElement continueBtn = $(By.xpath("//input[@id='continue']"));
}
