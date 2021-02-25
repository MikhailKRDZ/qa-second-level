package framework.page.pricingcalculator;

import framework.page.AbstractPageHardcore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPricingCalculatorPage extends AbstractPageHardcore {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//iframe")
    private WebElement frame;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPricingCalculatorFrame switchToFrameCalculator() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.switchTo().frame(0);
        logger.info("PricingCalculatorPage page opened");
        return new GoogleCloudPricingCalculatorFrame(this.driver);
    }

    public GoogleCloudPricingCalculatorPage switchToDefaultFrame() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().defaultContent();
        return new GoogleCloudPricingCalculatorPage(this.driver);
    }
}
