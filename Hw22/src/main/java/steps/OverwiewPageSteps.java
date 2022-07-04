package steps;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import pages.OverviewPage;
public class OverwiewPageSteps {
    private static final OverviewPage overviewPage = new OverviewPage();
    @И("на открывшейся странице нажали кнопку ФИНИШ")
    public static void clickFinishButton() {
        overviewPage.finishBtn.shouldBe(Condition.visible).click();
    }
}
