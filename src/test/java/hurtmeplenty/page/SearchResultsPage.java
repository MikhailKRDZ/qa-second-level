package hurtmeplenty.page;

import hurtmeplenty.page.pricingcalculator.GoogleCloudPricingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SearchResultsPage extends AbstractPageHurtMePlenty {

    private final String splitRegex = "\\s";
    private String searchTerm;

    //use dynamic locator with "contains", split and iteration over the list of search terms
    private String defaultLocator = "//div[contains(@class,'gsc-webResult')%s]";
    private String containsPart = " and contains(.,'%s')";

    @FindBy(xpath = "//div[contains(@class,'gsc-webResult')]")
    private List<WebElement> generalSearchResults;

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResultLink;


    public SearchResultsPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }


    public int countGeneralNumberOfSearchResults() {
        System.out.println("Search results number for requested term: " + generalSearchResults.size());
        return generalSearchResults.size();
    }

    public int countResultsNumberWithSearchTerm() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath(buildLocatorForSearch()));
        System.out.println("Search results number for requested term: " + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    }

    private String buildLocatorForSearch() {
        String partWithSearchTerm = "";
        String[] terms = searchTerm.split(splitRegex);
        for (String term : terms) {
            partWithSearchTerm += String.format(containsPart, term);
        }
        String locatorForSearch = String.format(defaultLocator, partWithSearchTerm);

        //below is just utility output via System.out.println since dedicated logger is out of scope at this stage
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }

    public GoogleCloudPricingCalculator clickSearchResult() {
        // исправить на составной локатор
        //добавить в опен page ожидание
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(searchResultLink)).click();
//        searchResultLink.click();
        return new GoogleCloudPricingCalculator(this.driver,this.searchTerm);
    }

    @Override
    protected AbstractPageHurtMePlenty openPage() {
        throw new RuntimeException ("Please 'think twice' whether you need this page open directly " +
                "if direct access is still needed - please dig into Google Custom Search engine at" +
                " https://cse.google.com/cse/ for proper implementation " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage.");
    }
}
