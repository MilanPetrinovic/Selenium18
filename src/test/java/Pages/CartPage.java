package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    WebElement emptyCart, proceedToCheckout, productsLink, price;

    public WebElement getQuantity() {
        return driver.findElement(By.className("disabled"));
    }

    WebElement quantity;


    public void clickOnProceedToCheckout() {
        getProceedToCheckoutButton().click();
    }

    public void clickOnProductsLink() {
        getProductsLink().click();
    }

    public void removeAllProducts() throws InterruptedException {
        // Remove all products from the cart
        List<WebElement> removeProductBtnList = driver.findElements(By.cssSelector(".fa.fa-times"));
        for (WebElement removeProductBtn : removeProductBtnList) {
            driver.findElement(By.cssSelector(".fa.fa-times")).click();
            Thread.sleep(500);
        }
    }

    public WebElement getPrice() {
        // Get the element indicating the price in the cart
        return driver.findElement(By.className("price"));
    }

    public WebElement getProceedToCheckoutButton() {
        // Get the 'Proceed to checkout' button element
        return driver.findElement(By.cssSelector(".btn.btn-default.check_out"));
    }

    public WebElement getProductsLink() {
        return driver.findElement(By.linkText("here"));
    }

    public WebElement getEmptyCart() {
        // Get the element indicating that the cart is empty
        return driver.findElement(By.className("text-center"));
    }
}
