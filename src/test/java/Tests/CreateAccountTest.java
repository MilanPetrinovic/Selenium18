package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {
    // Set up the test environment by navigating to the home page
    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://automationexercise.com/");
    }


    @Test(priority = 10)
    public void verifyThatUserCanCreateNewAccountWithMinimumRequiredInformation() throws InterruptedException {
        // Verify the ability to create a new account with minimum required information
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputNewName(newName);
        loginPage.inputNewEmail(newEmail);
        loginPage.clickOnSignUpButton();
        accountInformation.clickOnMr();
        accountInformation.inputNewPassword(newPassword);
        accountInformation.inputFirstName(firstName);
        accountInformation.inputLastName(lastName);
        accountInformation.inputAddress(address);
        accountInformation.inputState(state);
        accountInformation.inputCity(city);
        accountInformation.inputZipcode(zipcode);
        accountInformation.inputMobileNumber(mobileNumber);
        WebElement element = driver.findElement(By.cssSelector("[data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        accountInformation.clickOnCreateAccountButton();
        Assert.assertTrue(accountCreatedPage.getAccountCreated().isDisplayed());
        Assert.assertEquals(accountCreatedPage.getAccountCreated().getText(), "ACCOUNT CREATED!");

    }
    @Test(priority = 15)
    public void verifyThatUserCannotCreateAccountWithoutAllRequiredFields() throws InterruptedException {
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputNewName(newName);
        loginPage.inputNewEmail(newEmail);
        loginPage.clickOnSignUpButton();
        accountInformation.clickOnMr();
        accountInformation.inputFirstName(firstName);
        accountInformation.inputLastName(lastName);
        accountInformation.inputAddress(address);
        accountInformation.inputState(state);
        accountInformation.inputCity(city);
        accountInformation.inputZipcode(zipcode);
        accountInformation.inputMobileNumber(mobileNumber);
        WebElement element = driver.findElement(By.cssSelector("[data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        accountInformation.clickOnCreateAccountButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");


    }

    @Test(priority = 20)
    public void verifyThatUserCanDeleteAccount() throws InterruptedException {
        // Verify the ability to delete the account
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputNewName(newName);
        loginPage.inputNewEmail(newEmail);
        loginPage.clickOnSignUpButton();
        accountInformation.clickOnMr();
        accountInformation.inputNewPassword(newPassword);
        accountInformation.inputFirstName(firstName);
        accountInformation.inputLastName(lastName);
        accountInformation.inputAddress(address);
        accountInformation.inputState(state);
        accountInformation.inputCity(city);
        accountInformation.inputZipcode(zipcode);
        accountInformation.inputMobileNumber(mobileNumber);
        WebElement element = driver.findElement(By.cssSelector("[data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        accountInformation.clickOnCreateAccountButton();
        Assert.assertTrue(accountCreatedPage.getAccountCreated().isDisplayed());
        Assert.assertEquals(accountCreatedPage.getAccountCreated().getText(), "ACCOUNT CREATED!");
        driver.get("https://automationexercise.com/");
        homePage.clickOnDeleteAccount();
        closeVignette();
        Assert.assertTrue(deletedAccountPage.getDeletedAccountMessage().isDisplayed());
        Assert.assertEquals(deletedAccountPage.getDeletedAccountMessage().getText(), "ACCOUNT DELETED!");
    }


}
