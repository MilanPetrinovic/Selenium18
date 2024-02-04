package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public ExcelReader excelReader;
    public HomePage homePage;
    public LoginPage loginPage;
    public AccountInformation accountInformation;
    public AccountCreatedPage accountCreatedPage;
    public ProductsPage productsPage;

    public ProductDetailsPage productDetailsPage;
    public BrandsList brandsList;
    public CartPage cartPage;
    public TestCasesPage testCasesPage;
    public ApiTestingPage apiTestingPage;
    public ContactPage contactPage;
    public PaymentPage paymentPage;
    public CheckoutPage checkoutPage;
    public PaymentDonePage paymentDonePage;
    public DeletedAccountPage deletedAccountPage;


    public void closeVignette() {
        // Close the vignette that sometimes appears on the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName" + "('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

    public void scrollToBottom() {
        //Scroll down to the bottom of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Test data
    public String firstName = "Milan";
    public String newName = "milan";
    public String newEmail = "milan@gmail.com";
    public String newPassword = "qwerty";
    public String address = "Narodnog fronta";
    public String state = "Serbia";
    public String city = "Novi Sad";
    public String zipcode = "21000";
    public String mobileNumber = "0606000066";
    public String validEmail = newEmail;
    public String invalidEmail = "random@gmail.com";
    public String validPassword = newPassword;
    public String invalidPassword = "123456789";
    public String lastName = "Mirkovic";
    public String name = "Milan Petrinovic";
    public String number = "6403 5432 9583 9673";
    public String cvc = "666";
    public String expirationMonth = "03";
    public String expirationYear = "2025";
    public String allProductsText = "ALL PRODUCTS";


    @BeforeClass
    public void setUP() throws IOException {
        // Set up WebDriver, wait, and initialize page objects
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        excelReader = new ExcelReader("TestData.xlsx");

        // Initialize page objects
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountInformation = new AccountInformation(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        brandsList = new BrandsList(driver);
        cartPage = new CartPage(driver);
        testCasesPage = new TestCasesPage(driver);
        apiTestingPage = new ApiTestingPage(driver);
        contactPage = new ContactPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        paymentDonePage = new PaymentDonePage(driver);
        deletedAccountPage = new DeletedAccountPage(driver);

    }
}

