package steps;
import com.codeborne.selenide.Condition;
import pages.ItemPage;
public class ItemPageSteps {
    private static final ItemPage itemPage = new ItemPage();
    public static void checkItemOnPage() {
            itemPage.inventoryContainer.shouldBe(Condition.visible);
    }
}
