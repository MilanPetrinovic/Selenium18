package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage {
    WebDriver driver;

    WebElement accountCreated;

    public WebElement getAccountCreated() {
        // Get the element indicating that the account is created
        return driver.findElement(By.cssSelector("[data-qa='account-created']"));
    }

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }


}
