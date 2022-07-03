package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import utils.ProductNames;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    @FindBy(xpath = "//*[@class=\"btn btn_primary btn_small btn_inventory\"]")
    public SelenideElement addBtn;
    private java.util.Arrays Arrays;

    public MainPage addProductsToBasket() {
        this.addBtn.click();
        return this;
    }

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    public SelenideElement basketBtn;

    public MainPage basketBtnClick() {
        this.basketBtn.shouldBe(Condition.visible).click();
        return this;
    }

    @FindBy(xpath = "//div[@class=\"inventory_item_img\"]")
    public SelenideElement openItem;

    public MainPage openItem() {
        this.openItem.click();
        return this;
    }

    @FindBy(css = ".shopping_cart_badge")
    public SelenideElement basketBubble;

    public MainPage checkBasketBubble(String text) {
        this.basketBubble.shouldBe(Condition.visible).shouldHave(Condition.exactText(text));
        return this;
    }

    public MainPage addItemsToBasket() {
        this.addProductsToBasket()
                .basketBtnClick();
        return this;
    }

    public MainPage addAllItemsToBasket() {
        this.Arrays.stream(ProductNames.values()).forEach(ignored -> page(MainPage.class).addProductsToBasket());
        page(MainPage.class).basketBtnClick();
        page(BasketPage.class).checkCartItem(6);
        return this;
    }

    public MainPage checkEachItem() {
        this.Arrays.stream(ProductNames.values()).forEach(ignored -> {
            page(MainPage.class).openItem();
            page(ItemPage.class).checkInventoryContainer();
            back();
        });
        return this;
    }

    public MainPage checkEmptyBasketAfterOrder() {
        this.addItemsToBasket();
        page(BasketPage.class).checkOutBtnClick();
        page(InformationPage.class).inputUserData();
        page(OverviewPage.class).finishBtnClick();
        page(CompletePage.class).basketBtnClick();
        page(BasketPage.class).checkCartItem(0);
        return this;
    }

    public MainPage chekBubbleNumberAfterAddProduct() {
        this.addAllItemsToBasket();
        page(MainPage.class).checkBasketBubble("6");
        return this;
    }

    public MainPage checkRemoveProductFromBasket() {
        this.addItemsToBasket();
        page(BasketPage.class).removeBtnClick()
                .checkCartItem(0);
        return this;
    }
}
