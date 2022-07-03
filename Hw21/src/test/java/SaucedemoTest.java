import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.*;
import utils.ProductNames;
import static com.codeborne.selenide.Selenide.*;
public class SaucedemoTest {
    @BeforeEach
    public void loginToSite() {
        String url = "https://www.saucedemo.com/";
        open(url);
        LoginPageSteps.login();
    }
    @AfterEach
    public void close() {
        closeWindow();
    }
    @Test
    @DisplayName("Проверка на добавление всех товаров в корзину")
    public void addProductsToBasket() {
        MainPageSteps.addAllProductsToBasket();
        BasketPageSteps.cartItem(6);
    }
    @Test
    @DisplayName("Проверка на соответсвие номера на пузырьке корзины количеству добаленных товаров")
    public void checkBasketNumber() {
        MainPageSteps.addAllProductsToBasket();
        MainPageSteps.checkBubbleNumber("6");
    }
    @Test
    @DisplayName("Проверка на то, что корзина пуста после оформления заказа")
    public void checkEmptyBasket() {
        MainPageSteps.addAllProductsToBasket();
        BasketPageSteps.checkOut();
        InformationPageSteps.inputUserData("Alex","Newman", "123456");
        OverwiewPageSteps.clickFinishButton();
        CompletePageSteps.basketButtonClick();
        BasketPageSteps.cartItem(0);
    }
    @Test
    @DisplayName("Проверка на открытие каждого товара на странице")
    public void openEachProduct() {
        for (ProductNames ignored : ProductNames.values()){
            MainPageSteps.openItem();
            ItemPageSteps.checkItemOnPage();
            back();
        }
    }
    @Test
    @DisplayName("Проверка на возможность удаления товара из корзины")
    public void deleteFromBasket() {
          MainPageSteps.addProductToBasket();
          BasketPageSteps.removeButtonClick();
          BasketPageSteps.cartItem(0);
    }
}
