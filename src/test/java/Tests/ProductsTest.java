package Tests;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    public String allProductsText = "ALL PRODUCTS";
    public String validEmail = "milan@gmail.com";
    public String validPassword = "qwerty";
    @BeforeMethod
    public void pageSetUp(){

        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUpLoginInButton();
        loginPage.inputLoginEmail(validEmail);
        loginPage.inputLoginPassword(validPassword);
        loginPage.clickOnLoginButton();
    }
    @Test(priority = 10)
    public void verifyThatAllProductsAreDisplayed() throws InterruptedException {
        homePage.clickOnProductsPageLink();
        closeVignette();
        homePage.clickOnProductsPageLink();
        Assert.assertTrue(productsPage.getAllProducts().isDisplayed());
        Assert.assertEquals(productsPage.getAllProducts().getText(), allProductsText);
    }
    @Test(priority = 20)
    public void verifyThatUserCanViewProductDetails(){
        homePage.clickOnProductsPageLink();
        closeVignette();
        homePage.clickOnProductsPageLink();
        productsPage.clickOnRandomProductInList();
        Assert.assertTrue(productDetailsPage.getProductInformation().isDisplayed());
    }
    @Test(priority = 30)
    public void verifyThatUserCanSelectProductCategory(){
        homePage.clickOnProductsPageLink();
        closeVignette();
        homePage.clickOnProductsPageLink();
        productsPage.clickOnWomenCategory();
        productsPage.clickOnDressButton();
        closeVignette();
        productsPage.clickOnDressButton();
        Assert.assertTrue(productsPage.getProductTitle().isDisplayed());
        Assert.assertEquals(productsPage.getProductTitle().getText(), "WOMEN - DRESS PRODUCTS");
    }
    @Test(priority = 40)
    public void verifyThatUserCanSelectProductsByBrand() throws InterruptedException {
        homePage.clickOnProductsPageLink();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        closeVignette();
        homePage.clickOnProductsPageLink();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandsList.getListOfBrands().get(4));
        Thread.sleep(500);
        brandsList.clickOnPolo();
        closeVignette();
        brandsList.clickOnPolo();
        Assert.assertTrue(brandsList.getPoloTitle().isDisplayed());
        Assert.assertEquals(brandsList.getPoloTitle().getText(), "BRAND - POLO PRODUCTS");
    }
}
