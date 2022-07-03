package steps;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import pages.BasketPage;
public class BasketPageSteps {
    private static final BasketPage basketPage = new BasketPage();
    public static void cartItem(int size) {
        basketPage.cartItem.shouldHave(CollectionCondition.size(size));
    }
    public static void checkOut() {
        basketPage.checkOutBtn.shouldBe(Condition.visible).click();
    }
    public static void removeButtonClick() {
        basketPage.removeBtn.shouldBe(Condition.visible).click();
    }
}
