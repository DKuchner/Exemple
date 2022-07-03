package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class LoginPage {
    public SelenideElement login = $(By.xpath("//input[@id='user-name']"));
    public SelenideElement password= $(By.xpath("//input[@id='password']"));
    public SelenideElement loginBtn = $(By.xpath("//input[@id='login-button']"));
}
