package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://automationexercise.com/");
    }

    String errorMessageText = "Your email or password is incorrect!";
    String loggedInText = " Logged in as ";
    String name = "Milan";

    @Test(priority = 10)
    public void VerifyThatUserCannotLoginWithInvalidEmail() {
        String invalidEmail = excelReader.getStringData("LoginCredentials", 1, 2);
        String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(invalidEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), errorMessageText);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(priority = 20)
    public void VerifyThatUserCannotLoginWithInvalidPassword() {
        String validEmail = excelReader.getStringData("LoginCredentials", 1, 0);
        String invalidPassword = excelReader.getStringData("LoginCredentials", 1, 3);
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), errorMessageText);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(priority = 30)
    public void VerifyThatUserCannotLoginWithEmptyEmailAndPassword() {
        homePage.clickOnSignUpLoginInButton();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(priority = 40)
    public void VerifyThatUserCanLoginWithValidCredentials() {
        String validEmail = excelReader.getStringData("LoginCredentials", 1, 0);
        String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.getLogOut().isDisplayed());
        Assert.assertTrue(homePage.getLoggedInButton().isDisplayed());

    }

    @Test(priority = 50)
    public void VerifyThatUserCanLogOut() {
        String validEmail = excelReader.getStringData("LoginCredentials", 1, 0);
        String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();

        homePage.clickOnLogOutButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/login"));
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getPassword().isDisplayed());

    }
}
