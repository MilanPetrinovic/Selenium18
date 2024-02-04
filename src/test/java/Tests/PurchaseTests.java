package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PurchaseTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
    }

    @Test(priority = 10)
    public void verifyThatUserCanCompletePurchase() throws InterruptedException {


        homePage.clickOnProductsPageLink();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(500);
        productDetailsPage.clickOnViewCart();
        cartPage.clickOnProceedToCheckout();
        scrollToBottom();
        cartPage.clickOnProceedToCheckout();
        Assert.assertTrue(paymentPage.getPaymentText().isDisplayed());
        Assert.assertEquals(paymentPage.getPaymentText().getText(), "Payment");
        paymentPage.inputNameOnCard(name);
        paymentPage.inputCardNumber(number);
        paymentPage.inputCvc(cvc);
        paymentPage.inputExpirationMonth(expirationMonth);
        paymentPage.inputExpirationYear(expirationYear);
        paymentPage.confirmPayment();
        Assert.assertTrue(paymentDonePage.getOrderPlacedMessage().isDisplayed());
        Assert.assertEquals(paymentDonePage.getOrderPlacedMessage().getText(), "ORDER PLACED!");
        paymentDonePage.clickOnContinue();
        homePage.clickOnCartButton();
        Assert.assertTrue(cartPage.getEmptyCart().isDisplayed());
        Assert.assertEquals(cartPage.getEmptyCart().getText(), "Cart is empty! Click here to buy products.");

    }

    @Test(priority = 20)
    public void verifyThatInvoiceIsDownloaded() throws InterruptedException {
        String downloadPath = "C:\\Users\\Sofija\\Downloads\\";
        String filename = "invoice.txt";

        homePage.clickOnProductsPageLink();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(500);
        productDetailsPage.clickOnViewCart();
        cartPage.clickOnProceedToCheckout();
        scrollToBottom();
        cartPage.clickOnProceedToCheckout();
        Assert.assertTrue(paymentPage.getPaymentText().isDisplayed());
        Assert.assertEquals(paymentPage.getPaymentText().getText(), "Payment");
        paymentPage.inputNameOnCard(name);
        paymentPage.inputCardNumber(number);
        paymentPage.inputCvc(cvc);
        paymentPage.inputExpirationMonth(expirationMonth);
        paymentPage.inputExpirationYear(expirationYear);
        paymentPage.confirmPayment();
        Assert.assertTrue(paymentDonePage.getOrderPlacedMessage().isDisplayed());
        Assert.assertEquals(paymentDonePage.getOrderPlacedMessage().getText(), "ORDER PLACED!");
        paymentDonePage.clickOnDownloadInvoice();
        Assert.assertTrue(paymentDonePage.isFileDownloaded(downloadPath, filename));

    }

    @Test(priority = 30)
    public void verifyThatDeliveryAddressIsTheSameAsCreateAccountAddress() throws InterruptedException {
        homePage.clickOnProductsPageLink();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(500);
        productDetailsPage.clickOnViewCart();
        cartPage.clickOnProceedToCheckout();
        Assert.assertEquals(checkoutPage.getDeliveryInformation().get(1).getText(), address);

    }
}
