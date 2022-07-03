package steps;
import com.codeborne.selenide.Condition;
import pages.OverviewPage;
public class OverwiewPageSteps {
    private static final OverviewPage overviewPage = new OverviewPage();
    public static void clickFinishButton() {
        overviewPage.finishBtn.shouldBe(Condition.visible).click();
    }
}
