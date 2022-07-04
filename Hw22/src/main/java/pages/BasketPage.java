package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class BasketPage {
    public SelenideElement checkOutBtn = $(By.xpath( "//button[@id='checkout']"));
    public ElementsCollection cartItem = $$(By.cssSelector(".cart_item"));
    public SelenideElement removeBtn = $(By.xpath("//button[text()=\"Remove\"]"));
}
