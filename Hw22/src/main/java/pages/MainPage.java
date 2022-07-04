package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class MainPage {
    public SelenideElement addBtn = $(By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory\"]"));
    public SelenideElement basketBtn = $(By.xpath("//*[@class='shopping_cart_link']"));
    public SelenideElement openItem = $(By.xpath("//div[@class=\"inventory_item_img\"]"));
    public SelenideElement basketBubble = $(By.cssSelector(".shopping_cart_badge"));
}
