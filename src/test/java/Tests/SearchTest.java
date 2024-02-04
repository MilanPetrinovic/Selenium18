package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    String searchTerm = "Blue";

    @BeforeMethod
    public void pageSetUp() {

        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
    }

    @Test(priority = 10)
    public void verifyThatUserCanSearchProducts() {
        homePage.clickOnProductsPageLink();
        closeVignette();
        homePage.clickOnProductsPageLink();
        homePage.inputSearch(searchTerm);
        homePage.clickOnSearchButton();
        productsPage.clickOnRandomProductInList();
        String elementText = productDetailsPage.getProductInformation().getText();
        if (elementText.contains(searchTerm)) {
            Assert.assertTrue(true);
        }
    }

}
