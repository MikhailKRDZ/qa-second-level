package hurtmeplenty.page.pricingcalculator;

import hurtmeplenty.page.AbstractPageHurtMePlenty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPricingCalculatorPage extends AbstractPageHurtMePlenty {

    @FindBy(xpath = "//iframe")
    private WebElement frame;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorFrame switchToFrameCalculator() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.switchTo().frame(0);
        return new GoogleCloudPricingCalculatorFrame(this.driver);
    }

    public GoogleCloudPricingCalculatorPage switchToDefaultFrame() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame)).click();
        driver.switchTo().defaultContent();
        return new GoogleCloudPricingCalculatorPage(this.driver);
    }

    @Override
    protected AbstractPageHurtMePlenty openPage() {
        throw new RuntimeException("Please 'think twice' whether you need this page open directly " +
                "if direct access is still needed - please dig into Google Custom Search engine at" +
                " https://cse.google.com/cse/ for proper implementation " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage.");
    }
}
