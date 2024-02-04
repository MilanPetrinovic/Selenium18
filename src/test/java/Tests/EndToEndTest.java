package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {
    @BeforeMethod
    // Set up the test by opening the application's home page
    public void pageSetUp() {
        driver.get("https://automationexercise.com/");
    }

    @Test(priority = 10)
    public void verifyThatUserCanCreateNewAccountAndCompletePurchaseOfProduct() throws InterruptedException {
        // Test case for end-to-end user journey: creating an account and completing a product purchase
        String validEmail = excelReader.getStringData("LoginCredentials", 1, 0);
        String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);
        // Click on the 'Sign up/Log in' button
        homePage.clickOnSignUpLoginInButton();

        // Input new account information
        loginPage.inputNewName(newName);
        loginPage.inputNewEmail(newEmail);
        loginPage.clickOnSignUpButton();

        // Fill in the account information
        accountInformation.clickOnMr();
        accountInformation.inputNewPassword(newPassword);
        accountInformation.inputFirstName(firstName);
        accountInformation.inputLastName(lastName);
        accountInformation.inputAddress(address);
        accountInformation.inputState(state);
        accountInformation.inputCity(city);
        accountInformation.inputZipcode(zipcode);
        accountInformation.inputMobileNumber(mobileNumber);

        // Scroll to the 'Create Account' button
        WebElement element = driver.findElement(By.cssSelector("[data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

        // Click on the 'Create Account' button
        accountInformation.clickOnCreateAccountButton();

        // Verify that the account is created
        Assert.assertTrue(accountCreatedPage.getAccountCreated().isDisplayed());
        Assert.assertEquals(accountCreatedPage.getAccountCreated().getText(), "ACCOUNT CREATED!");

        // Navigate to the 'Products' page
        driver.get("https://automationexercise.com/");
        homePage.clickOnProductsPageLink();
        closeVignette();

        // Add products to the cart
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(500);
        productDetailsPage.clickOnViewCart();

        // Proceed to checkout
        cartPage.clickOnProceedToCheckout();
        scrollToBottom();
        cartPage.clickOnProceedToCheckout();

        // Perform payment steps
        Assert.assertTrue(paymentPage.getPaymentText().isDisplayed());
        Assert.assertEquals(paymentPage.getPaymentText().getText(), "Payment");
        paymentPage.inputNameOnCard(name);
        paymentPage.inputCardNumber(number);
        paymentPage.inputCvc(cvc);
        paymentPage.inputExpirationMonth(expirationMonth);
        paymentPage.inputExpirationYear(expirationYear);
        paymentPage.confirmPayment();

        // Verify that the order is placed
        Assert.assertTrue(paymentDonePage.getOrderPlacedMessage().isDisplayed());
        Assert.assertEquals(paymentDonePage.getOrderPlacedMessage().getText(), "ORDER PLACED!");

        // Continue after order placement
        paymentDonePage.clickOnContinue();

        // Navigate to the cart and verify it's empty
        homePage.clickOnCartButton();
        Assert.assertTrue(cartPage.getEmptyCart().isDisplayed());
        Assert.assertEquals(cartPage.getEmptyCart().getText(), "Cart is empty! Click here to buy products.");


    }

    @AfterMethod
    public void logOut() {
        // Perform logout after the test
        driver.get("https://automationexercise.com/");
        homePage.clickOnLogOutButton();

        // Verify that user is logged out
        Assert.assertTrue(loginPage.getSignUpForm().isDisplayed());
    }
}
