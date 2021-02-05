package hurtmeplenty.page.pricingcalculator;

import hurtmeplenty.page.AbstractPageHurtMePlenty;
import hurtmeplenty.page.pricingcalculator.frame.GoogleCloudPricingCalculatorResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPricingCalculatorResultsPage extends AbstractPageHurtMePlenty {


        String searchTerm;

        @FindBy(id = "cloud-site")
        private WebElement cloudFrame;


        @FindBy(xpath = "//iframe")
        private WebElement frame;

        protected GoogleCloudPricingCalculatorResultsPage(WebDriver driver, String searchTerm) {
            super(driver);
            this.searchTerm = searchTerm;
        }

        public GoogleCloudPricingCalculatorResultsPage(WebDriver driver) {
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

//    public List<String> getResults() {
//        switchToFramePricingCalculatorResults();
//        getListResults();
//
////            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeSelected(results));
////            return new ArrayList<>(Collections.singleton(results.getText()));
//        return null;
//    }
//
//        public GoogleCloudPricingCalculatorResult switchToFramePricingCalculatorResults() {
//            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
//            driver.switchTo().frame(0);
//            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
//            driver.switchTo().frame(0);
////            new GoogleCloudPricingCalculatorResultsPage(this.driver, "text").activateButtonComputeEngine();
//            return new GoogleCloudPricingCalculatorResult(this.driver, this.searchTerm);
//        }

        public GoogleCloudPricingCalculatorResultsPage switchToDefaultFrame() {
            int a = 0;
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame)).click();
            driver.switchTo().defaultContent();
            return new GoogleCloudPricingCalculatorResultsPage(this.driver);
        }

    public GoogleCloudPricingCalculatorResult switchToFrameCalculatorResults() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.switchTo().frame(0);
//            new GoogleCloudPricingCalculatorResultsPage(this.driver, "text").activateButtonComputeEngine();
        return new GoogleCloudPricingCalculatorResult(this.driver, this.searchTerm);
    }

    public List<WebElement> getResults() {
//        return new ArrayList<>(Collections.singleton(driver.findElement(By.id("resultBlock")).getText()));
        return new ArrayList<>(driver.findElements(By.xpath("//*[@id='resultBlock']//div[contains(text(),'')]")));
    }

//    public GoogleCloudPricingCalculatorFormToFill switchToFrameCalculator() {
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
//        driver.switchTo().frame(0);
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
//        driver.switchTo().frame(0);
//        new GoogleCloudPricingCalculatorFormToFill(this.driver, "text").activateButtonComputeEngine();
//        return new GoogleCloudPricingCalculatorFormToFill(this.driver, this.searchTerm);
//    }
//
//    public GoogleCloudPricingCalculator switchToDefaultFrame() {
//        int a = 0;
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame)).click();
//        driver.switchTo().defaultContent();
//        return new GoogleCloudPricingCalculator(this.driver);
//    }



}
