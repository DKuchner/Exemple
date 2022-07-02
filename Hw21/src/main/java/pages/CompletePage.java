package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage {
    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    public SelenideElement basketBtn;

    public CompletePage basketBtnClick(){
        this.basketBtn.shouldBe(Condition.visible).click();
        return this;
    }
}
