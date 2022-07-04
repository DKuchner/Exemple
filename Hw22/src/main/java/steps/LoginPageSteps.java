package steps;
import io.cucumber.java.After;
import io.cucumber.java.ru.Дано;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageSteps  {
    private static final LoginPage loginPage = new LoginPage();
    @Дано("открыли страницу с сайтом и выполнили вход")
    public static void login() {
        String url = "https://www.saucedemo.com/";
        open(url);
        loginPage.login.sendKeys("standard_user");
        loginPage.password.sendKeys("secret_sauce");
        loginPage.loginBtn.click();
    }
    @After
    public void close() {
        closeWindow();
    }
}
