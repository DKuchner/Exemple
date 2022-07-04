package steps;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import pages.CompletePage;
public class CompletePageSteps {
    private static final CompletePage completePage = new CompletePage();
    @И("с открывшейся страницы перешли в корзину")
    public static void basketButtonClick() {
        completePage.basketBtn.shouldBe(Condition.visible).click();
    }
}
