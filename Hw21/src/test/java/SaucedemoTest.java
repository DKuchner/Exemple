import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ProductNames;
import pages.SinglePage;

import static com.codeborne.selenide.Selenide.*;

public class SaucedemoTest {

    @BeforeEach
    public void loginToSite() {
        String url = "https://www.saucedemo.com/";
        SinglePage page = open(url,SinglePage.class);
        page.setLogin("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton();
    }
    @AfterEach
    public void close() {
        closeWindow();
    }

    @Test
    public void addProductsToBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            page(SinglePage.class).addProductsToBasket();
        }
        page(SinglePage.class).basketBtnClick()
                .checkCartItem(6);
    }
    @Test
    public void checkBasketNumber() {
        for (ProductNames ignored : ProductNames.values()) {
            page(SinglePage.class).addProductsToBasket();
        }
            page(SinglePage.class).checkBasketBubble("6");
    }
    @Test
    public void checkEmptyBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            page(SinglePage.class).addProductsToBasket();
        }
        page(SinglePage.class).basketBtnClick()
                .checkOutClick()
                .setFirstName("Alex")
                .setLastName("Newman")
                .setPostalCode("123456")
                .continueBtnClick()
                .finishBtnClick()
                .basketBtnClick()
                .checkCartItem(0);
    }
    @Test
    public void openEachProduct() {
        for (ProductNames ignored : ProductNames.values()) {
            page(SinglePage.class).openItem()
                    .checkInventoryContainer();
            back();
        }
    }
    @Test
    public void deleteFromBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            page(SinglePage.class).addProductsToBasket();
        }
        page(SinglePage.class).basketBtnClick();
        for (ProductNames ignored : ProductNames.values()) {
            page(SinglePage.class).removeBtnClick();
        }
        page(SinglePage.class).checkCartItem(0);
    }
}
