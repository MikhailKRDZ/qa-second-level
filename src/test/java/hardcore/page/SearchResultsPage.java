package hardcore.page;


import hardcore.page.pricingcalculator.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SearchResultsPage extends AbstractPageHardcore {

    @FindBy(xpath = "//div[@class='gsc-resultsbox-visible']")
    private WebElement searchResults;

    private final String searchResultLocator = "//div[@class='gs-title']//b[text()='%s']";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage selectSearchResult(String searchResultData) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(searchResults));
        driver.findElement(By.xpath(String.format(this.searchResultLocator, searchResultData))).click();
        return new GoogleCloudPricingCalculatorPage(this.driver);
    }
}
