package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    WebDriver driver;

    WebElement productInformation, addToCart, addedMessage, thankYouForReviewMessage, inputNameField,
            inputEmailField, inputReviewField, submitReviewField, continueShopping, viewCart, productQuantity;

    public WebElement getProductQuantity() {
        return driver.findElement(By.id("quantity"));
    }
    public void increaseQuantity(String quantityToIncrease){
        getProductQuantity().clear();
        getProductQuantity().sendKeys(quantityToIncrease);
    }




    public void inputNameForReview(String name) {
        getInputNameField().sendKeys(name);
    }

    public void inputEmailForReview(String email) {
        getInputEmailField().sendKeys(email);
    }

    public void inputProductReview(String review) {
        getInputReviewField().sendKeys(review);
    }

    public void clickOnSubmitReview() {
        getSubmitReviewField().click();
    }

    public void clickOnViewCart() {
        getViewCart().click();
    }

    public void clickOnAddToCart() {
        getAddToCart().click();
    }

    public WebElement getThankYouForReviewMessage() {
        return driver.findElement(By.className("form-row"));
    }

    public WebElement getInputNameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getInputEmailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getInputReviewField() {
        return driver.findElement(By.id("review"));
    }

    public WebElement getSubmitReviewField() {
        return driver.findElement(By.id("button-review"));
    }

    public WebElement getViewCart() {
        return driver.findElement(By.linkText("View Cart"));
    }

    public WebElement getAddedMessage() {
        return driver.findElement(By.cssSelector(".modal-title.w-100"));
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getAddToCart() {
        return driver.findElement(By.cssSelector(".btn.btn-default.cart"));
    }

    public WebElement getProductInformation() {
        return driver.findElement(By.className("product-information"));
    }

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

}
