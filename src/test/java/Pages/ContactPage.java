package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
    WebDriver driver;

    WebElement title;

    public void clickOnContactUs() {
        getTitle().click();
    }

    public WebElement getTitle() {
        return driver.findElement(By.cssSelector(".title.text-center"));
    }


    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }
}
