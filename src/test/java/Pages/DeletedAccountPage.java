package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeletedAccountPage {
    WebDriver driver;

    WebElement deletedAccountMessage;

    public WebElement getDeletedAccountMessage() {
        // Get the element indicating the account is deleted
        return driver.findElement(By.cssSelector(".title.text-center"));
    }

    public DeletedAccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
