package steps;
import com.codeborne.selenide.Condition;
import pages.InformationPage;
public class InformationPageSteps {
    private static final InformationPage informationPage = new InformationPage();
    public static void inputUserData(String fName, String lName, String postCode) {
        informationPage.firstName.sendKeys(fName);
        informationPage.lastName.sendKeys(lName);
        informationPage.postalCode.sendKeys(postCode);
        informationPage.continueBtn.shouldBe(Condition.visible).click();
    }
}
