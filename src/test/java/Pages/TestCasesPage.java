package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage {
    WebDriver driver;
    WebElement title;

    public WebElement getTitle() {
        return driver.findElement(By.cssSelector(".title.text-center"));
    }

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }
}
