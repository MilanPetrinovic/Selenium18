package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReviewTest extends BaseTest {

    public String name = "Milan";
    public String review = "This product is very nice!";
    public String reviewMessage = "Thank you for your review.";

    @BeforeMethod
    public void pageSetUp() {

        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
    }

    @Test(priority = 10)
    public void verifyThatUserCanAddProductReview() {
        homePage.clickOnProductsPageLink();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        closeVignette();
        productsPage.clickOnRandomProductInList();
        scrollToBottom();
        productDetailsPage.inputNameForReview(name);
        productDetailsPage.inputEmailForReview(validEmail);
        productDetailsPage.inputProductReview(review);
        productDetailsPage.clickOnSubmitReview();
        Assert.assertTrue(productDetailsPage.getThankYouForReviewMessage().isDisplayed());
        Assert.assertEquals(productDetailsPage.getThankYouForReviewMessage().getText(), reviewMessage);
    }
}
