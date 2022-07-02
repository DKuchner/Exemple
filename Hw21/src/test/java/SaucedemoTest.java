import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.ProductNames;

import static com.codeborne.selenide.Selenide.*;

public class SaucedemoTest {

    @BeforeEach
    public void loginToSite() {
        String url = "https://www.saucedemo.com/";
        LoginPage page = open(url,LoginPage.class);
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
            page(MainPage.class).addProductsToBasket();
        }
        page(MainPage.class).basketBtnClick();
                page(BasketPage.class).checkCartItem(6);
    }
    @Test
    public void checkBasketNumber() {
        for (ProductNames ignored : ProductNames.values()) {
            page(MainPage.class).addProductsToBasket();
        }
            page(MainPage.class).checkBasketBubble("6");
    }
    @Test
    public void checkEmptyBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            page(MainPage.class).addProductsToBasket();
        }
        page(MainPage.class).basketBtnClick();
                page(BasketPage.class).checkOutBtnClick();
                page(InformationPage.class).setFirstName("Alex")
                .setLastName("Newman")
                .setPostalCode("123456")
                .continueBtnClick();
                page(OverviewPage.class).finishBtnClick();
                page(CompletePage.class).basketBtnClick();
                page(BasketPage.class).checkCartItem(0);
    }
    @Test
    public void openEachProduct() {
        for (ProductNames ignored : ProductNames.values()) {
            page(MainPage.class).openItem();
                    page(ItemPage.class).checkInventoryContainer();
            back();
        }
    }
    @Test
    public void deleteFromBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            page(MainPage.class).addProductsToBasket();
        }
        page(MainPage.class).basketBtnClick();
        for (ProductNames ignored : ProductNames.values()) {
            page(BasketPage.class).removeBtnClick();
        }
        page(BasketPage.class).checkCartItem(0);
    }
}
