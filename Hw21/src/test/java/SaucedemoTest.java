import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.ProductNames;
import utils.User;
import pages.SinglePage;

import static com.codeborne.selenide.Selenide.*;

public class SaucedemoTest {
    SinglePage singlePage = new SinglePage();
    private final String url = "https://www.saucedemo.com/";

    @BeforeEach
    public void enter() {
        open(url);
        singlePage.login.sendKeys("standard_user");
        singlePage.password.sendKeys("secret_sauce");
        singlePage.loginBtn.shouldBe(Condition.visible).click();
    }
    @AfterEach
    public void close() {
        closeWindow();
    }

    @Test
    public void addProductsToBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            singlePage.addBtn.click();
        }
        singlePage.basketBtn.shouldBe(Condition.visible).click();
        singlePage.cartItem.shouldHave(CollectionCondition.size(6));
    }
    @Test
    public void checkBasketNumber() {
        for (ProductNames ignored : ProductNames.values()) {
            singlePage.addBtn.click();
        }
        singlePage.basketBubble.shouldBe(Condition.visible).shouldHave(Condition.exactText("6"));
    }
    @Test
    public void checkEmptyBasket() {

        User user = new User("Alex", "Newman", "123456");
        for (ProductNames ignored : ProductNames.values()) {
            singlePage.addBtn.click();
        }
        singlePage.basketBtn.click();
        singlePage.checkOut.shouldBe(Condition.visible).click();
        singlePage.firstName.setValue(user.getFirstName());
        singlePage.lastName.setValue(user.getLastName());
        singlePage.postalCode.setValue(user.getPostalCode());
        singlePage.continueBtn.shouldBe(Condition.visible).click();
        singlePage.finishBtn.shouldBe(Condition.visible).click();
        singlePage.basketBtn.shouldBe(Condition.visible).click();
        singlePage.cartItem.shouldHave(CollectionCondition.size(0));
    }
    @Test
    public void openEachProduct() {

        for (ProductNames product : ProductNames.values()) {
            String ProductNames = product.getProductName();
            SelenideElement checkProduct = $(By.xpath(String.format(singlePage.checkAllProducts, ProductNames)));
            checkProduct.click();
            checkProduct.shouldHave(Condition.exactText(ProductNames));
            back();
        }
    }
    @Test
    public void deleteFromBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            singlePage.addBtn.click();
        }
        singlePage.basketBtn.shouldBe(Condition.visible).click();
        for (ProductNames ignored : ProductNames.values()) {
            singlePage.removeBtn.click();
        }
        singlePage.cartItem.shouldHave(CollectionCondition.size(0));
    }
}
