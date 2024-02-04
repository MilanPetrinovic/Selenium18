package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {

        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();


    }

    @Test(priority = 10)
    public void verifyTestCasesLink() {
        Assert.assertTrue(homePage.getTestCasesLink().isDisplayed());
        homePage.clickOnTestCases();
        Assert.assertEquals(testCasesPage.getTitle().getText(), "TEST CASES");
    }

    @Test(priority = 20)
    public void verifyAPITestingLink() {
        Assert.assertTrue(homePage.getApiTestingLink().isDisplayed());
        homePage.clickOnAPITesting();
        closeVignette();
        homePage.clickOnAPITesting();
        Assert.assertEquals(apiTestingPage.getTitle().getText(), "APIS LIST FOR PRACTICE");
    }

    @Test(priority = 30)
    public void verifyVideoTutorialsLink() {
        Assert.assertTrue(homePage.getVideoTutorialsLink().isDisplayed());
        homePage.clickOnVideoTutorials();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/c/AutomationExercise");
    }

    @Test(priority = 40)
    public void verifyContactUsLink() {
        Assert.assertTrue(homePage.getContactUs().isDisplayed());
        homePage.getContactUs().click();
        Assert.assertEquals(contactPage.getTitle().getText(), "CONTACT US");
    }
}
