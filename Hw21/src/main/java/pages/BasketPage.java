package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class BasketPage {
    @FindBy(xpath = "//button[@id='checkout']")
    public SelenideElement checkOutBtn;

    public BasketPage checkOutBtnClick(){
        this.checkOutBtn.shouldBe(Condition.visible).click();
        return this;
    }
    @FindBy (css = ".cart_item")
    public ElementsCollection cartItem;

    public BasketPage checkCartItem(int size) {
        this.cartItem.shouldHave(CollectionCondition.size(size));
        return this;
    }
    @FindBy (xpath = "//button[text()=\"Remove\"]")
    public SelenideElement removeBtn;

    public BasketPage removeBtnClick(){
        this.removeBtn.shouldBe(Condition.visible).click();
        return this;
    }


}
