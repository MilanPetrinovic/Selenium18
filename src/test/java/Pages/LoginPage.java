package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    WebElement newName, newEmail, signUpButton, email, password, loginButton, errorMessage, signUpForm;

    public void inputLoginEmail(String email) {
        getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void inputLoginPassword(String password) {
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public void inputNewName(String newName) {
        getNewName().clear();
        getNewName().sendKeys(newName);
    }

    public void inputNewEmail(String newEmail) {
        getNewEmail().clear();
        getNewEmail().sendKeys(newEmail);
    }

    public void clickOnSignUpButton() {
        getSignUpButton().click();
    }

    public WebElement getSignUpForm() {
        return driver.findElement(By.className("signup-form"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector("[style='color: red;']"));
    }


    public WebElement getEmail() {
        return driver.findElement(By.cssSelector("[data-qa='login-email']"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.cssSelector("[data-qa='login-password']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("[data-qa='login-button']"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.cssSelector("[data-qa='signup-button']"));
    }

    public WebElement getNewEmail() {
        return driver.findElement(By.cssSelector("[data-qa='signup-email']"));
    }

    public WebElement getNewName() {
        return driver.findElement(By.cssSelector("[data-qa='signup-name']"));
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
