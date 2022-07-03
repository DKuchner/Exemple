package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    @FindBy(xpath = "//input[@id='user-name']")
    public SelenideElement login;
    @FindBy(xpath = "//input[@id='password']")
    public SelenideElement password;
    @FindBy (xpath = "//input[@id='login-button']")
    public SelenideElement loginBtn;

    public LoginPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }
    public LoginPage setLogin(String login) {
        this.login.sendKeys(login);
        return this;
    }
    public LoginPage clickLoginButton() {
        this.loginBtn.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginPage login() {
        this.setLogin("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton();
        return this;
    }
}
