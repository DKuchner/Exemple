import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.ProductNames;
import utils.User;

import static com.codeborne.selenide.Selenide.*;

public class SaucedemoTest {

    private final String url = "https://www.saucedemo.com/";

    @BeforeEach
    public void enter() {
        open(url);
        element(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        element(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        element(By.xpath("//input[@id='login-button']")).shouldBe(Condition.visible).click();
    }
    @AfterEach
    public void close() {
        closeWindow();
    }

    @Test
    public void addProductsToBasket() {

        element(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        element(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        element(By.xpath("//*[@class='shopping_cart_link']")).shouldBe(Condition.visible).click();
        elements(".cart_item").shouldHave(CollectionCondition.size(6));
    }

    @Test
    public void checkBasketNumber() {

        element(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        element(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        element(".shopping_cart_badge").shouldBe(Condition.visible).shouldHave(Condition.exactText("6"));
    }

    @Test
    public void checkEmptyBasket() {

        User user = new User("Alex", "Newman", "123456");
        element(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        element(By.xpath("//*[@class='shopping_cart_link']")).click();
        element(By.xpath("//button[@id='checkout']")).shouldBe(Condition.visible).click();
        element(By.xpath("//input[@id='first-name']")).setValue(user.getFirstName());
        element(By.xpath("//input[@id='last-name']")).setValue(user.getLastName());
        element(By.xpath("//input[@id='postal-code']")).setValue(user.getPostalCode());
        element(By.xpath("//input[@id='continue']")).shouldBe(Condition.visible).click();
        element(By.xpath("//button[@id='finish']")).shouldBe(Condition.visible).click();
        element(By.xpath("//*[@class='shopping_cart_link']")).shouldBe(Condition.visible).click();
        elements(".cart_item").shouldHave(CollectionCondition.size(0));
    }

    @Test
    public void openEachProduct() {

        for (ProductNames product : ProductNames.values()) {
            element(By.xpath("//*[text()=\"" + product.getProductName() + "\"]")).click();
            element(By.xpath("//*[@class=\"inventory_details_name large_size\"]")).shouldHave(Condition.exactText(product.getProductName()));
            back();
        }
    }

    @Test
    public void deleteFromBasket() {

        element(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        element(By.xpath("//*[@class='shopping_cart_link']")).shouldBe(Condition.visible).click();
        element(By.xpath("//button[text()=\"Remove\"]")).shouldBe(Condition.visible).click();
        elements(".cart_item").shouldHave(CollectionCondition.size(0));
    }
}
