package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class PaymentDonePage {
    WebDriver driver;

    WebElement orderPlacedMessage, downloadInvoice, continueButton;

    public WebElement getDownloadInvoice() {
        return driver.findElement(By.cssSelector(".btn.btn-default.check_out"));
    }

    public void clickOnDownloadInvoice() {
        getDownloadInvoice().click();
    }


    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public void clickOnContinue() {
        getContinueButton().click();
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".btn.btn-primary"));
    }

    public WebElement getOrderPlacedMessage() {
        return driver.findElement(By.cssSelector(".title.text-center"));
    }

    public PaymentDonePage(WebDriver driver) {
        this.driver = driver;
    }
}
