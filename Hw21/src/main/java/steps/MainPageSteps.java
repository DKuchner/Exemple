package steps;
import com.codeborne.selenide.Condition;
import pages.MainPage;
import utils.ProductNames;
public class MainPageSteps {
    private static final MainPage mainPage = new MainPage();
    public static void addAllProductsToBasket() {
        for (ProductNames ignored : ProductNames.values()) {
            mainPage.addBtn.shouldBe(Condition.visible).click();
        }
        mainPage.basketBtn.shouldBe(Condition.visible).click();
    }
    public static void checkBubbleNumber(String text) {
        mainPage.basketBubble.shouldHave(Condition.exactText(text));
    }
    public static void openItem() {
        mainPage.openItem.shouldBe(Condition.visible).click();
    }
    public static void addProductToBasket() {
        mainPage.addBtn.shouldBe(Condition.visible).click();
        mainPage.basketBtn.shouldBe(Condition.visible).click();
    }
}
