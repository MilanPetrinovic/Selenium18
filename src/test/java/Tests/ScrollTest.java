package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {

        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
    }

    @Test(priority = 10)
    public void verifyThatUserCanScrollToTheToPUsingScrollButton() {
        scrollToBottom();
        Assert.assertTrue(homePage.getSubscriptionEmail().isDisplayed());
        homePage.clickOnScrollUpButton();
        Assert.assertTrue(homePage.getTopLogo().isDisplayed());
    }
}
