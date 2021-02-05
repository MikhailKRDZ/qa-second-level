package hurtmeplenty.page.pricingcalculator;

import hurtmeplenty.page.AbstractPageHurtMePlenty;
import hurtmeplenty.page.pricingcalculator.frame.GoogleCloudPricingCalculatorFormToFill;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPricingCalculator extends AbstractPageHurtMePlenty {


    protected String searchTerm;

    @FindBy(id = "cloud-site")
    private WebElement cloudFrame;


    @FindBy(xpath = "//iframe")
    private WebElement frame;

    public GoogleCloudPricingCalculator(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public GoogleCloudPricingCalculator(WebDriver driver) {
        super(driver);
    }


    @Override
    protected AbstractPageHurtMePlenty openPage() {
        throw new RuntimeException("Please 'think twice' whether you need this page open directly " +
                "if direct access is still needed - please dig into Google Custom Search engine at" +
                " https://cse.google.com/cse/ for proper implementation " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage.");
    }

    public GoogleCloudPricingCalculatorFormToFill switchToFrameCalculator() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.switchTo().frame(0);
        new GoogleCloudPricingCalculatorFormToFill(this.driver, "text").activateButtonComputeEngine();
        return new GoogleCloudPricingCalculatorFormToFill(this.driver, this.searchTerm);
    }

    public GoogleCloudPricingCalculator switchToDefaultFrame() {
        int a = 0;
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame)).click();
        driver.switchTo().defaultContent();
        return new GoogleCloudPricingCalculator(this.driver);
    }
}
