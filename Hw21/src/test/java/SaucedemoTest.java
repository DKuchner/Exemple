import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class SaucedemoTest {

    @BeforeEach
    public void loginToSite() {
        String url = "https://www.saucedemo.com/";
        open(url);
        page(LoginPage.class).login();
    }
    @AfterEach
    public void close() {
        closeWindow();
    }
    @Test
    @DisplayName("Проверка на добавление всех товаров в корзину")
    public void addProductsToBasket() {
        page(MainPage.class).addAllItemsToBasket();
    }
    @Test
    @DisplayName("Проверка на соответсвие номера на пузырьке корзины количеству добаленных товаров")
    public void checkBasketNumber() {
        page(MainPage.class).chekBubbleNumberAfterAddProduct();
    }
    @Test
    @DisplayName("Проверка на то, что корзина пуста после оформления заказа")
    public void checkEmptyBasket() {
        page(MainPage.class).checkEmptyBasketAfterOrder();
    }
    @Test
    @DisplayName("Проверка на открытие каждого товара на странице")
    public void openEachProduct() {
        page(MainPage.class).checkEachItem();
    }
    @Test
    @DisplayName("Проверка на возможность удаления товара из корзины")
    public void deleteFromBasket() {
            page(MainPage.class).checkRemoveProductFromBasket();
    }
}
