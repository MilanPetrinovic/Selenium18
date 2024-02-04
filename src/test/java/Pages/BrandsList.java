package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandsList {
    WebDriver driver;

    List<WebElement> listOfBrands;

    WebElement poloTitle;

    public void clickOnPolo(){
        getListOfBrands().get(4).click();
    }

    public List<WebElement> getListOfBrands() {
        return driver.findElements(By.className("pull-right"));
    }

    public WebElement getPoloTitle() {
        return driver.findElement(By.cssSelector(".title.text-center"));
    }

    public BrandsList(WebDriver driver) {
        this.driver = driver;
    }

}
