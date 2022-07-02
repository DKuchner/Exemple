package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage {
    @FindBy(xpath = "//input[@id='first-name']")
    public SelenideElement firstName;

    public InformationPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }
    @FindBy (xpath = "//input[@id='last-name']")
    public SelenideElement lastName;

    public InformationPage  setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }
    @FindBy (xpath = "//input[@id='postal-code']")
    public SelenideElement postalCode;

    public InformationPage setPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
        return this;
    }
    @FindBy (xpath = "//input[@id='continue']")
    public SelenideElement continueBtn;

    public InformationPage continueBtnClick(){
        this.continueBtn.shouldBe(Condition.visible).click();
        return this;
    }
}
