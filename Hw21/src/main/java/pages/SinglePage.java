package pages;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v100.page.Page;
import org.openqa.selenium.support.FindBy;
import utils.ProductNames;


import static com.codeborne.selenide.Selenide.*;


public class SinglePage {

    public static @NotNull SinglePage singlePage() {
        return page(SinglePage.class);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    public SelenideElement login;
    @FindBy(xpath = "//input[@id='password']")
    public SelenideElement password;
    @FindBy (xpath = "//input[@id='login-button']")
    public SelenideElement loginBtn;

    public SinglePage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }
    public SinglePage setLogin(String login) {
        this.login.sendKeys(login);
        return this;
    }
    public SinglePage clickLoginButton() {
        this.loginBtn.shouldBe(Condition.visible).click();
        return this;
    }
    @FindBy (xpath = "//*[@class=\"btn btn_primary btn_small btn_inventory\"]")
    public SelenideElement addBtn;

    public SinglePage addProductsToBasket() {
        this.addBtn.click();
        return this;
    }
    @FindBy (xpath = "//*[@class='shopping_cart_link']")
    public SelenideElement basketBtn;

    public SinglePage basketBtnClick(){
        this.basketBtn.shouldBe(Condition.visible).click();
        return this;
    }

    @FindBy (css = ".shopping_cart_badge")
    public SelenideElement basketBubble;

    public SinglePage checkBasketBubble(String text) {
        this.basketBubble.shouldBe(Condition.visible).shouldHave(Condition.exactText(text));
        return this;
    }
    @FindBy (xpath = "//button[@id='checkout']")
    public SelenideElement checkOut;

    public SinglePage checkOutClick(){
        this.checkOut.shouldBe(Condition.visible).click();
        return this;
    }
    @FindBy (xpath = "//button[text()=\"Remove\"]")
    public SelenideElement removeBtn;

    public SinglePage removeBtnClick(){
        this.removeBtn.shouldBe(Condition.visible).click();
        return this;
    }
    @FindBy (xpath = "//input[@id='first-name']")
    public SelenideElement firstName;

    public SinglePage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }
    @FindBy (xpath = "//input[@id='last-name']")
    public SelenideElement lastName;

    public SinglePage  setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }
    @FindBy (xpath = "//input[@id='postal-code']")
    public SelenideElement postalCode;

    public SinglePage setPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
        return this;
    }
    @FindBy (xpath = "//input[@id='continue']")
    public SelenideElement continueBtn;

    public SinglePage continueBtnClick(){
        this.continueBtn.shouldBe(Condition.visible).click();
        return this;
    }
    @FindBy (xpath = "//button[@id='finish']")
    public SelenideElement finishBtn;

    public SinglePage finishBtnClick(){
        this.finishBtn.shouldBe(Condition.visible).click();
        return this;
    }
    @FindBy (css = ".cart_item")
    public ElementsCollection cartItem;

    public SinglePage checkCartItem(int size) {
        this.cartItem.shouldHave(CollectionCondition.size(size));
        return this;
    }
    @FindBy (xpath = "//*[@class=\"inventory_details_desc_container\"]")
    public SelenideElement inventoryContainer;

    public SinglePage checkInventoryContainer() {
        this.inventoryContainer.shouldBe(Condition.visible);
        return this;
    }

    @FindBy(xpath = "//div[@class=\"inventory_item_img\"]")
    public SelenideElement openItem;

    public SinglePage openItem() {
        this.openItem.click();
        return this;
    }
}