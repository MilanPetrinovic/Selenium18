package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CartTests extends BaseTest {

    public String quantityToIncrease = "5";


    @BeforeMethod
    public void pageSetUp() {
        // Set up the test environment by logging in and navigating to the cart
        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
        homePage.clickOnCartButton();
        closeVignette();

    }

    @Test(priority = 10)
    public void verifyThatCartIsEmpty() {
        // Verify that the cart is empty and displays the correct message
        homePage.clickOnCartButton();
        Assert.assertTrue(cartPage.getEmptyCart().isDisplayed());
        Assert.assertEquals(cartPage.getEmptyCart().getText(), "Cart is empty! Click here to buy products.");

    }

    @Test(priority = 20)
    public void verifyThatUserCanAddProductToCart() throws InterruptedException {
        // Verify the ability to add a product to the cart
        homePage.clickOnProductsPageLink();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(500);
        Assert.assertTrue(productDetailsPage.getAddedMessage().isDisplayed());
        Assert.assertEquals(productDetailsPage.getAddedMessage().getText(), "Added!");
        productDetailsPage.clickOnViewCart();
        Assert.assertTrue(cartPage.getProceedToCheckoutButton().isDisplayed());
        Assert.assertTrue(cartPage.getPrice().isDisplayed());

    }

    @Test(priority = 25)
    public void verifyThatUserCanAddMultipleDifferentProductsToCart() throws InterruptedException {
        // Verify the ability to add multiple products to the cart
        for (int i = 0; i < 3; i++) {
            homePage.clickOnProductsPageLink();
            closeVignette();
            homePage.clickOnProductsPageLink();
            productsPage.clickOnRandomProductInList();
            closeVignette();
            productsPage.clickOnRandomProductInList();
            productDetailsPage.clickOnAddToCart();
            Thread.sleep(300);
            productDetailsPage.clickOnViewCart();
            List<WebElement> productsImage = driver.findElements(By.className("product_image"));
            Assert.assertTrue(productsImage.size() > 1);

        }
    }
    @Test(priority = 27)
        public void verifyThatUserCanAddMultiplePiecesOfSingleProduct() throws InterruptedException {
        homePage.clickOnProductsPageLink();
        closeVignette();
        homePage.clickOnProductsPageLink();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.increaseQuantity(quantityToIncrease);
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(300);
        productDetailsPage.clickOnViewCart();
        Assert.assertEquals(cartPage.getQuantity().getText(), quantityToIncrease);




    }

    @Test(priority = 30)
    public void verifyThatUserCanRemoveItemsFromCart() throws InterruptedException {
        // Verify the ability to remove items from the cart
        homePage.clickOnProductsPageLink();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(500);
        productDetailsPage.clickOnViewCart();
        cartPage.removeAllProducts();
        homePage.clickOnCartButton();
        Assert.assertTrue(cartPage.getEmptyCart().isDisplayed());
        Assert.assertEquals(cartPage.getEmptyCart().getText(), "Cart is empty! Click here to buy products.");

    }

    @Test(priority = 40)
    public void verifyThatItemsRemainInCartAfterLogout() throws InterruptedException {
        // Verify that items remain in the cart after logout and login
        homePage.clickOnCartButton();
        homePage.clickOnProductsPageLink();
        closeVignette();
        homePage.clickOnProductsPageLink();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(500);
        productDetailsPage.clickOnViewCart();
        List<WebElement> productsImage = driver.findElements(By.className("product_image"));
        Assert.assertFalse(productsImage.isEmpty());
        homePage.clickOnLogOutButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
        homePage.clickOnCartButton();
        List<WebElement> productsImageAfterLogout = driver.findElements(By.className("product_image"));
        Assert.assertEquals(productsImage.size(), productsImageAfterLogout.size());


    }
}
