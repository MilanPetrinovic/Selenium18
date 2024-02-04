package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    List<WebElement> deliveryInformation;
    WebElement placeOrder;

    public List<WebElement> getDeliveryInformation() {
        return driver.findElements(By.cssSelector(".address_address1.address_address2"));
    }

    public WebElement getPlaceOrder() {
        return driver.findElement(By.cssSelector(".btn.btn-default.check_out"));
    }

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
}
