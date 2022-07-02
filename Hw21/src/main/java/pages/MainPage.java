package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//*[@class=\"btn btn_primary btn_small btn_inventory\"]")
    public SelenideElement addBtn;

    public MainPage addProductsToBasket() {
        this.addBtn.click();
        return this;
    }
    @FindBy (xpath = "//*[@class='shopping_cart_link']")
    public SelenideElement basketBtn;

    public MainPage basketBtnClick(){
        this.basketBtn.shouldBe(Condition.visible).click();
        return this;
    }
    @FindBy(xpath = "//div[@class=\"inventory_item_img\"]")
    public SelenideElement openItem;

    public MainPage openItem() {
        this.openItem.click();
        return this;
    }
    @FindBy (css = ".shopping_cart_badge")
    public SelenideElement basketBubble;

    public MainPage checkBasketBubble(String text) {
        this.basketBubble.shouldBe(Condition.visible).shouldHave(Condition.exactText(text));
        return this;
    }

}
