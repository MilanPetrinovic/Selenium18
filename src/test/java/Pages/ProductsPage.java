package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BaseTest {

    WebDriver driver;
    List<WebElement> listOfAllProducts;

    WebElement productTitle, productInformation, womenCategoryButton, dressButton, allProducts, randomProduct;


    public void clickOnWomenCategory() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView()", getWomenCategoryButton());
        getWomenCategoryButton().click();
    }

    public void clickOnDressButton() {
        getDressButton().click();
    }

    public void clickOnRandomProductInList() {
        //Actions builder = new Actions(driver);

        List<WebElement> productList = getListOfAllProducts();

        if (!productList.isEmpty()) {
            Random randomGenerator = new Random();
            int index = randomGenerator.nextInt(productList.size());

            WebElement randomProduct = productList.get(index);
            //Actions actions = new Actions(driver);
            //actions.moveToElement(randomProduct).click().perform();
            //randomProduct.click();
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].scrollIntoView()", randomProduct);
            randomProduct.click();
        }

    }

    public WebElement getProductTitle() {
        return driver.findElement(By.cssSelector(".title.text-center"));
    }

    public WebElement getProductInformation() {
        return driver.findElement(By.className("product-information"));
    }

    public WebElement getWomenCategoryButton() {
        return driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[1]/h4/a"));
    }

    public WebElement getDressButton() {
        return driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[2]/div/ul/li[1]/a"));
    }

    public WebElement getAllProducts() {
        return driver.findElement(By.cssSelector(".title.text-center"));
    }

    public List<WebElement> getListOfAllProducts() {
        return driver.findElements(By.linkText("View Product"));
    }

    public WebElement getRandomProduct() {
        return randomProduct;
    }

    public ProductsPage(WebDriver driver) {
        this.driver = driver;

    }

}
