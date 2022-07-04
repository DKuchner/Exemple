package steps;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Тогда;
import pages.ItemPage;
public class ItemPageSteps {
    private static final ItemPage itemPage = new ItemPage();
    @Тогда("открылась страница с товаром")
    public static void checkItemOnPage() {
            itemPage.inventoryContainer.shouldBe(Condition.visible);
    }
}
