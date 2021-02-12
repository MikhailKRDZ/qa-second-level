package hardcore.page.pricingcalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPricingCalculatorFrame extends GoogleCloudPricingCalculatorPage {

    @FindBy(xpath = "//*[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement webElementNumberOfInstances;

    @FindBy(xpath = "//*[contains(text(),'What are these instances for?')]/following-sibling::input")
    private WebElement webElementWhatInstancesForInput;

    @FindBy(xpath = "//*[contains(text(),'Operating System / Software')]/following-sibling::md-select")
    private WebElement webElementOperatingSystemValue;

    @FindBy(xpath = "//*[contains(text(),'Machine Class')]/following-sibling::md-select")
    private WebElement webElementVirtualMachineTypeValue;

    @FindBy(xpath = "//*[contains(text(),'Series')]/following-sibling::md-select")
    private WebElement webElementInstanceNodeSeries;

    @FindBy(xpath = "//*[contains(text(),'Machine type')]/following-sibling::md-select")
    private WebElement webElementInstanceMachineType;

    @FindBy(xpath = "//div[contains(text(),'Add GPUs.')]")
    private WebElement webElementAddGPUsCheckBox;

    @FindBy(xpath = "//*[contains(text(),'GPU type')]/following-sibling::md-select")
    private WebElement webElementTypeGPUValue;

    @FindBy(xpath = "//*[contains(text(),'Number of GPUs')]/following-sibling::md-select")
    private WebElement webElementNumberOfGPUs;

    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/following-sibling::md-select")
    private WebElement webElementLocalSSD;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[contains(text(),'Datacenter location')]/following-sibling::md-select")
    private WebElement webElementDatacenterLocation;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[contains(text(),'Committed usage')]/following-sibling::md-select")
    private WebElement webElementCommittedUsage;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
    private WebElement webElementAddToEstimateButton;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']")
    private WebElement webElementMdSelectMenuContainer;

    @FindBy(xpath = "//*[contains(text(),'Email Estimate')]")
    private WebElement webElementEmailEstimateButton;





    private String defaultLocatorInSelectArea =
            "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";

    private String defaultLocatorInResultArea =
            "//md-card-content[@id='resultBlock']//*[contains(text(),'%s')]";

    public GoogleCloudPricingCalculatorFrame(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorFrame inputNumberOfInstances(String numberOfInstances) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(webElementNumberOfInstances))
                .sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorFrame inputWhatInstancesFor(String whatInstancesForData) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(webElementWhatInstancesForInput))
                .click();
        webElementWhatInstancesForInput.sendKeys(whatInstancesForData);
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectOperationSystem(String operationSystemData) {
        if (!webElementOperatingSystemValue.getText().equals(operationSystemData)) {
            inputDataFromSelectMenuContainer(webElementOperatingSystemValue, operationSystemData);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectVirtualMachineType(String virtualMachineTypeInputData) {
        if (!webElementVirtualMachineTypeValue.getText().equals(virtualMachineTypeInputData)) {
            inputDataFromSelectMenuContainer(webElementVirtualMachineTypeValue, virtualMachineTypeInputData);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectInstanceNodeSeries(String instanceNodeSeriesInputData) {
        if (!webElementInstanceNodeSeries.getText().equals(instanceNodeSeriesInputData)) {
            inputDataFromSelectMenuContainer(webElementInstanceNodeSeries, instanceNodeSeriesInputData);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectInstanceNodeName(String instanceNodeNameInputData) {
        if (!webElementInstanceMachineType.getText().equals(instanceNodeNameInputData)) {
            inputDataFromSelectMenuContainer(webElementInstanceMachineType, instanceNodeNameInputData);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame clickAddGPUs() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(webElementAddGPUsCheckBox)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(webElementAddGPUsCheckBox));
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectNumberOfGPUs(String inputNumberOfGPUs) {
        inputDataFromSelectMenuContainer(webElementNumberOfGPUs, inputNumberOfGPUs);
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectTypeOfGPUs(String inputTypeOfGPUs) {
        inputDataFromSelectMenuContainer(webElementTypeGPUValue, inputTypeOfGPUs);
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectLocalSSD(String inputLocalSSD) {
        if (!webElementLocalSSD.getText().equals(inputLocalSSD)) {
            inputDataFromSelectMenuContainer(webElementLocalSSD, inputLocalSSD);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectDatacenterLocation(String inputDatacenterLocation) {
        if (!webElementDatacenterLocation.getText().equals(inputDatacenterLocation)) {
            inputDataFromSelectMenuContainer(webElementDatacenterLocation, inputDatacenterLocation);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectCommittedUsage(String inputCommittedUsage) {
        if (!webElementCommittedUsage.getText().equals(inputCommittedUsage)) {
            inputDataFromSelectMenuContainer(webElementCommittedUsage, inputCommittedUsage);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame clickAddToEstimate() {
        webElementAddToEstimateButton.submit();
        return this;
    }

    public String getVMClassResult() {
        return selectDataFromResultForm("VM class:");
    }

    public String getInstanceTypeResult() {
        return selectDataFromResultForm("Instance type:");
    }

    public String getRegionResult() {
        return selectDataFromResultForm("Region:");
    }

    public String getLocalSSDResult() {
        return selectDataFromResultForm("Total available local SSD space").replaceAll("i", "");
    }

    public String getCommitmentTermValue() {
        return selectDataFromResultForm("Commitment term:");
    }

    public String getTotalEstimatedCostResult() {
        return selectDataFromResultForm("Total Estimated Cost:");
    }

    private void inputDataFromSelectMenuContainer
            (WebElement webElementCurrentValue, String operationSystemData) {
        webElementCurrentValue.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(webElementMdSelectMenuContainer));
        driver.findElement(By.xpath(String.format(this.defaultLocatorInSelectArea, operationSystemData))).click();
    }


    private String selectDataFromResultForm(String elementsName) {
        WebElement webElement = driver.findElement(By.xpath(String.format(defaultLocatorInResultArea, elementsName)));
        return webElement.getText().split(elementsName)[1].replaceAll("\\s+", "");
    }

    public EmailYourEstimateFrame clickEmailEstimateButton() {
        webElementEmailEstimateButton.click();
        return new EmailYourEstimateFrame(this.driver);
    }

    public String getLetter() {
        return null;
    }
}
