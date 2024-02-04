package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    WebElement signUpLogIn, logOut, loggedInButton, productsPageLink, cartButton, scrollUpButton, topLogo, apiTestingLink,
            subscriptionEmail, deleteAccount, testCasesLink, contactUs, submitSearch, searchField, videoTutorialsLink;


    public void clickOnScrollUpButton() {
        getScrollUpButton().click();
    }

    public void clickOnDeleteAccount() {getDeleteAccount().click();    }

    public void clickOnTestCases() {
        getTestCasesLink().click();
    }

    public void clickOnCOntactUsLink() {
        getContactUs().click();
    }


    public void inputSearch(String searchInput) {
        getSearchField().clear();
        getSearchField().sendKeys(searchInput);
    }

    public void clickOnSearchButton() {
        getSubmitSearch().click();
    }

    public void clickOnAPITesting() {
        getApiTestingLink().click();
    }

    public void clickOnVideoTutorials() {
        getVideoTutorialsLink().click();
    }

    public void clickOnCartButton() { getCartButton().click();  }

    public void clickOnProductsPageLink() {
        // Click on the 'Products' page link
        getProductsPageLink().click();
    }

    public void clickOnLogOutButton() { getLogOut().click();}

    public void clickOnSignUpLoginInButton() {
        // Click on the 'Sign up/Log in' button
        getSignUpLogIn().click();
    }

    public WebElement getSearchField() {
        return driver.findElement(By.id("search_product"));
    }

    public WebElement getSubmitSearch() {
        return driver.findElement(By.id("submit_search"));
    }

    public WebElement getApiTestingLink() {
        return driver.findElement(By.linkText("API Testing"));
    }

    public WebElement getVideoTutorialsLink() {
        return driver.findElement(By.linkText("Video Tutorials"));
    }

    public WebElement getCartButton() {
        return driver.findElement(By.cssSelector(".fa.fa-shopping-cart"));
    }

    public WebElement getProductsPageLink() {
        return driver.findElement(By.cssSelector(".material-icons.card_travel"));
    }

    public WebElement getLoggedInButton() {
        return driver.findElement(By.cssSelector(".fa.fa-user"));
    }

    public WebElement getLogOut() {
        return driver.findElement(By.cssSelector(".fa.fa-lock"));
    }

    public WebElement getSignUpLogIn() {
        return driver.findElement(By.cssSelector(".fa.fa-lock"));
    }

    public WebElement getScrollUpButton() {
        return driver.findElement(By.cssSelector(".fa.fa-angle-up"));
    }

    public WebElement getTopLogo() {
        return driver.findElement(By.cssSelector(".logo.pull-left"));
    }

    public WebElement getSubscriptionEmail() {
        return driver.findElement(By.id("susbscribe_email"));
    }

    public WebElement getDeleteAccount() {
        return driver.findElement(By.cssSelector(".fa.fa-trash-o"));
    }

    public WebElement getTestCasesLink() {
        return driver.findElement(By.linkText("Test Cases"));
    }

    public WebElement getContactUs() {
        return driver.findElement(By.linkText("Contact us"));
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
