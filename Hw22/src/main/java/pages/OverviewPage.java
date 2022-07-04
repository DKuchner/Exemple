package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class OverviewPage {
    public SelenideElement finishBtn = $(By.xpath("//button[@id='finish']"));

}
