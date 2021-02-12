package hardcore.page.pricingcalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailYourEstimateFrame extends GoogleCloudPricingCalculatorFrame {

    public EmailYourEstimateFrame(WebDriver driver) {
        super(driver);
    }

//    public TemporaryEmailPage switchToTemporaryEmailPage() {
//        return new TemporaryEmailPage();
//    }

    public EmailYourEstimateFrame inputPostAddressValueToEstimate(String emailAddress) {
        driver.findElement(By.xpath(
                "//form[@name='emailForm']//label[contains(text(),'Email')]/..//input")).sendKeys(emailAddress);

        return this;
    }

    public GoogleCloudPricingCalculatorFrame clickSendEmailButton() {
        driver.findElement(By.xpath("//button[contains(text(),'Send Email')]")).click();
        return this;
    }
}
