package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage {
    @FindBy(xpath = "//button[@id='finish']")
    public SelenideElement finishBtn;

    public OverviewPage finishBtnClick() {
        this.finishBtn.shouldBe(Condition.visible).click();
        return this;
    }
}
