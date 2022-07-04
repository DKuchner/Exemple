package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class ItemPage {
    public SelenideElement inventoryContainer = $(By.xpath("//*[@class=\"inventory_details_desc_container\"]"));
}
