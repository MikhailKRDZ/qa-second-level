package hurtmeplenty.page.pricingcalculator.frame;

import hurtmeplenty.page.pricingcalculator.GoogleCloudPricingCalculatorResultsPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudPricingCalculatorResult extends GoogleCloudPricingCalculatorResultsPage {
    public GoogleCloudPricingCalculatorResult(WebDriver driver, String searchTerm) {
        super(driver, searchTerm);
    }

    public GoogleCloudPricingCalculatorResult(WebDriver driver) {
        super(driver);
    }

//
//    public List<String> getResults() {
//
//        return null;
//    }
}
