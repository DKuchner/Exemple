package steps;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.BasketPage;
public class BasketPageSteps {
    private static final BasketPage basketPage = new BasketPage();
    @Тогда("количество товаров в корзине соответсвует количеству {int}")
    public static void cartItem(int size) {
        basketPage.cartItem.shouldHave(CollectionCondition.size(size));
    }
    @И("перешли в козину")
    public static void checkOut() {
        basketPage.checkOutBtn.shouldBe(Condition.visible).click();
    }
    @И("на открывшейся странице нажали кнопку УДАЛИТЬ")
    public static void removeButtonClick() {
        basketPage.removeBtn.shouldBe(Condition.visible).click();
    }
    @Тогда("количество товаров в корзине равно {int}")
    public static void checkCartItem(int size) {
        basketPage.cartItem.shouldHave(CollectionCondition.size(size));
    }
}
