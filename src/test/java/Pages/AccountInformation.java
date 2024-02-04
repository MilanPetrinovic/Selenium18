package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountInformation {
    WebDriver driver;

    WebElement radioButtonMale, radioButtonFemale, newPassword, adress, state, city, zipcode, mobileNumber, firstName, lastName, createAccountButton;

    public void clickOnMr() {
        // Click on the 'Mr.' option
        getRadioButtonMale().click();
    }

    public void inputNewPassword(String newPassword) {
        // Input the new password
        getNewPassword().clear();
        getNewPassword().sendKeys(newPassword);
    }

    public void inputFirstName(String firstName) {
        // Input the first name
        getFirstName().clear();
        getFirstName().sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        // Input the last name
        getLastName().clear();
        getLastName().sendKeys(lastName);
    }

    public void inputAddress(String address) {
        // Input the address
        getAdress().clear();
        getAdress().sendKeys(address);
    }

    public void inputState(String state) {
        // Input the state
        getState().clear();
        getState().sendKeys(state);
    }

    public void inputCity(String city) {
        // Input the city
        getCity().clear();
        getCity().sendKeys(city);
    }

    public void inputZipcode(String zipcode) {
        // Input the zipcode
        getZipcode().clear();
        getZipcode().sendKeys(zipcode);
    }

    public void inputMobileNumber(String mobileNumber) {
        // Input the mobile number
        getMobileNumber().clear();
        getMobileNumber().sendKeys(mobileNumber);
    }

    public void clickOnCreateAccountButton() {
        // Click on the 'Create an account' button
        getCreateAccountButton().click();
    }

    public WebElement getNewPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getRadioButtonMale() {
        return driver.findElement(By.cssSelector("[value='Mr']"));
    }

    public WebElement getRadioButtonFemale() {
        return driver.findElement(By.cssSelector("[value='Mrs']"));
    }


    public WebElement getAdress() {
        return driver.findElement(By.id("address1"));
    }

    public WebElement getState() {
        return driver.findElement(By.id("state"));
    }

    public WebElement getCity() {
        return driver.findElement(By.id("city"));
    }

    public WebElement getZipcode() {
        return driver.findElement(By.id("zipcode"));
    }

    public WebElement getMobileNumber() {
        return driver.findElement(By.id("mobile_number"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("first_name"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("last_name"));
    }

    public WebElement getCreateAccountButton() {
        return driver.findElement(By.cssSelector("[data-qa='create-account']"));
    }

    public AccountInformation(WebDriver driver) {
        this.driver = driver;
    }


}
