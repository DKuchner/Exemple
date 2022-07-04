package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class CompletePage {
    public SelenideElement basketBtn = $(By.xpath("//*[@class='shopping_cart_link']"));

}
