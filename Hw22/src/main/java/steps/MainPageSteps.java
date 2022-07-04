package steps;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;
import utils.ProductNames;
public class MainPageSteps {
    private static final MainPage mainPage = new MainPage();
    @Когда("добавили все товары в корзину и перешли в корзину")
    public static void addAllProductsToBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            mainPage.addBtn.shouldBe(Condition.visible).click();
        }
        mainPage.basketBtn.shouldBe(Condition.visible).click();
    }
    @Тогда("номер на пузырьке корзины соответсвует {string}")
    public static void checkBubbleNumber(String text) {
        mainPage.basketBubble.shouldHave(Condition.exactText(text));
    }
    @Когда("нажали на странице на иконку товара")
    public static void openItem() {
        mainPage.openItem.shouldBe(Condition.visible).click();
    }
    @Когда("добавили товар в корзину и перешли в корзину")
    public static void addProductToBasket() {
        mainPage.addBtn.shouldBe(Condition.visible).click();
        mainPage.basketBtn.shouldBe(Condition.visible).click();
    }

}
