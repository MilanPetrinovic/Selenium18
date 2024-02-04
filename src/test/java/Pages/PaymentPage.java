package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    WebDriver driver;
    WebElement paymentText, nameOnCard, cardNumber, cvc, expiration, expirationYear, confirmAndPay;

    public void confirmPayment() {
        getConfirmAndPay().click();
    }

    public void inputExpirationYear(String year) {
        getExpirationYear().clear();
        getExpirationYear().sendKeys(year);
    }

    public void inputExpirationMonth(String month) {
        getExpiration().clear();
        getExpiration().sendKeys(month);
    }

    public void inputCvc(String cvc) {
        getCvc().clear();
        getCvc().sendKeys(cvc);
    }

    public void inputCardNumber(String cardNumber) {

        getCardNumber().clear();
        getCardNumber().sendKeys(cardNumber);
    }

    public void inputNameOnCard(String name) throws InterruptedException {
        getNameOnCard().clear();
        getNameOnCard().sendKeys(name);
    }

    public WebElement getConfirmAndPay() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getExpirationYear() {
        return driver.findElement(By.cssSelector("[name='expiry_year']"));
    }

    public WebElement getExpiration() {
        return driver.findElement(By.cssSelector("[name='expiry_month']"));
    }

    public WebElement getCvc() {
        return driver.findElement(By.cssSelector("[name='cvc']"));
    }

    public WebElement getCardNumber() {
        return driver.findElement(By.cssSelector("[name='card_number']"));
    }


    public WebElement getNameOnCard() {
        return driver.findElement(By.cssSelector("[name='name_on_card']"));
    }

    public WebElement getPaymentText() {
        return driver.findElement(By.className("heading"));
    }

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
}
