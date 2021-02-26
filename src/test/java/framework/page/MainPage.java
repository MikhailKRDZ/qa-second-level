package framework.page;

import framework.model.User;
import framework.page.pricingcalculator.GoogleCloudPricingCalculatorFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPageHardcore {
    private final Logger logger = LogManager.getRootLogger();
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    private WebElement searchButton;

    @FindBy(xpath = "//form[@class='devsite-search-form']//input")
    private WebElement inputDataField;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public SearchResultsPage search(String inputData) {
        searchButton.click();
        inputDataField.sendKeys(inputData);
        inputDataField.submit();
        return new SearchResultsPage(this.driver);
    }

    public GoogleCloudPricingCalculatorFrame fillData(User testUser) {
        openPage()
                .search(testUser.getSearchInput())
                .selectSearchResult(testUser.getSearchResult())
                .switchToFrameCalculator()
                .inputNumberOfInstances(testUser.getNumberOfInstances())
                .inputWhatInstancesFor(testUser.getWhatInstancesFor())
                .selectOperationSystem(testUser.getOperationSystem())
                .selectVirtualMachineType(testUser.getVirtualMachineType())
                .selectInstanceNodeSeries(testUser.getInstanceNodeSeries())
                .selectInstanceNodeName(testUser.getInstanceNodeName())
                .clickAddGPUs()
                .selectNumberOfGPUs(testUser.getNumberOfGPUs())
                .selectTypeOfGPUs(testUser.getTypeOfGPUs())
                .selectLocalSSD(testUser.getLocalSSD())
                .selectDatacenterLocation(testUser.getDatacenterLocation())
                .selectCommittedUsage(testUser.getCommittedUsage())
                .clickAddToEstimate();
        logger.info("Pricing Calculator filled");
        return new GoogleCloudPricingCalculatorFrame(this.driver);
    }
}
