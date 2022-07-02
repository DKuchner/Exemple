package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage {
    @FindBy(xpath = "//*[@class=\"inventory_details_desc_container\"]")
    public SelenideElement inventoryContainer;

    public ItemPage checkInventoryContainer() {
        this.inventoryContainer.shouldBe(Condition.visible);
        return this;
    }
}
