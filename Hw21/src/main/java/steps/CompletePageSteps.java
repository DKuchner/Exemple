package steps;
import com.codeborne.selenide.Condition;
import pages.CompletePage;
public class CompletePageSteps {
    private static final CompletePage completePage = new CompletePage();
    public static void basketButtonClick() {
        completePage.basketBtn.shouldBe(Condition.visible).click();
    }
}
