package steps;
import pages.LoginPage;
public class LoginPageSteps  {
    private static final LoginPage loginPage = new LoginPage();
    public static void login() {
        loginPage.login.sendKeys("standard_user");
        loginPage.password.sendKeys("secret_sauce");
        loginPage.loginBtn.click();
    }
}
