package hurtmeplenty.page.pricingcalculator.frame;

import hurtmeplenty.page.pricingcalculator.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPricingCalculatorFrame extends GoogleCloudPricingCalculatorPage {

    @FindBy(xpath = "//md-tab-item//div[contains(text(),'Compute Engine')]")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//*[contains(text(),'Number of instances')]/../input")
    private WebElement inputNumberOfInstances;

    @FindBy(xpath = "//*[contains(text(),'What are these instances for?')]/..//input")
    private WebElement whatInstancesForInput;

    @FindBy(xpath = "//*[contains(text(),'Operating System / Software')]/..//md-select")
    private WebElement operatingSystemValue;

    @FindBy(xpath = "//*[contains(text(),'Machine Class')]/..//md-select")
    private WebElement webElementVirtualMachineTypeValue;

    @FindBy(xpath = "//*[contains(text(),'Series')]/..//md-select")
    private WebElement instanceNodeTypeValue;

    @FindBy(xpath = "//*[contains(text(),'Machine type')]/..//md-select")
    private WebElement webElementInstanceMachineValue;

    @FindBy(xpath = "//div[contains(text(),'Add GPUs.')]")    // иногда два checkbox появляются проверить на кликально
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//*[contains(text(),'GPU type')]/..//md-select-value")
    ////*[contains(text(),'Number of GPUs')]/../md-select
    private WebElement typeGPUValue;

    @FindBy(xpath = "//*[contains(text(),'Number of GPUs')]/..//md-select")
    private WebElement currentNumbersGPUs;

//    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/..//md-select-value")
    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/..//div")
    private WebElement localSSDValue;

    @FindBy(xpath = "//form[@name='SoleTenantForm']//*[contains(text(),'Datacenter location')]/..//md-select-value")
//    @FindBy(xpath = "//form[@name='SoleTenantForm']//*[contains(text(),'Datacenter location')]/..//md-select-value//div")//проверить
    private WebElement datacenterLocationValue;

    @FindBy(xpath = "//form[@name='SoleTenantForm']//*[contains(text(),'Committed usage')]/..//md-select-value")
//    @FindBy(xpath = "//form[@name='SoleTenantForm']//*[contains(text(),'Committed usage')]/..//md-select-value//div")
    private WebElement webElementCommittedUsageValue;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']")
    private WebElement mdSelectMenuContainer;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;


    private String defaultLocatorInSelectArea =
    "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";

    private String defaultLocatorInResultArea =
            "//md-card-content[@id='resultBlock']//*[contains(text(),'%s')]";

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']")
    private WebElement availableNumbersGPUs;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text']")
    private WebElement availableDataText;
//form[@name='SoleTenantForm']//*[contains(text(),'Committed usage')]/..//div


////////////
//    //use dynamic locator with "contains", split and iteration over the list of search terms
////    private String defaultLocator1 = "//div[contains(@class,'gsc-webResult')%s]";
//    private String containsPart = " and contains(.,'%s')";
//
//    @FindBy(xpath = "//div[contains(@class,'gsc-webResult')]")
//    private List<WebElement> generalSearchResults;
//
//    private final String splitRegex = "\\s";
//    private String searchTerm;
//////////////////

    public GoogleCloudPricingCalculatorFrame(WebDriver driver) {
        super(driver);
    }

////
    public GoogleCloudPricingCalculatorFrame activateButtonComputeEngine() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(computeEngineButton)).click();
        return this;
    }

    public GoogleCloudPricingCalculatorFrame inputNumberOfInstances(String numberOfInstances) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(inputNumberOfInstances))
                .sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorFrame inputWhatInstancesFor(String whatInstancesForData) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(whatInstancesForInput))
                .click();
        whatInstancesForInput.sendKeys(whatInstancesForData);
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectOperationSystem(String operationSystemData) {
        if (!operatingSystemValue.getText().equals(operationSystemData)) {
            selectDataInProcess(operatingSystemValue, operationSystemData);
//            operatingSystemValue.click();
//            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(mdSelectMenuContainer));
//            driver.findElement(By.xpath(buildLocatorForSearch(defaultLocatorInputValue, operationSystemData))).click();
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectVirtualMachineType(String virtualMachineTypeInputData) {
//        String xpath = buildLocatorForSearch(defaultLocatorInputValue, virtualMachineTypeInputData);
        if (!webElementVirtualMachineTypeValue.getText().equals(virtualMachineTypeInputData)) {
            selectDataInProcess(webElementVirtualMachineTypeValue, virtualMachineTypeInputData);
//            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(webElementVirtualMachineTypeValue)).click();
//            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(driver.findElement(
//                    By.xpath(xpath)))).click();
//            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(
//                    By.xpath(xpath)));
        }
        return this;
    }


  ////////////////////
  //  Series

    public GoogleCloudPricingCalculatorFrame selectInstanceNodeType(String instanceNodeTypeInputData) {
        System.out.println(webElementInstanceMachineValue.getText());
        if (!webElementInstanceMachineValue.getText().equals(instanceNodeTypeInputData)) {
//        String seriesName = instanceNodeTypeInputData.substring(0, 2).toUpperCase(Locale.ROOT);
        selectDataInProcess(instanceNodeTypeValue, instanceNodeTypeInputData.substring(0, 2).toUpperCase(Locale.ROOT));

//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(instanceNodeTypeValue)).click();
//
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath(buildLocatorForSearch(defaultLocatorInputValue, seriesName))));
//
//
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable( driver.findElement(
//                By.xpath(buildLocatorForSearch(defaultLocatorInputValue, seriesName))))).click();
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(
//                By.xpath(buildLocatorForSearch(defaultLocatorInputValue, instanceNodeTypeInputData))));
//        System.out.println(instanceMachineValue.getText());

        selectDataInProcess(webElementInstanceMachineValue,instanceNodeTypeInputData);
//        instanceMachineValue.click();
//
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(
//                driver.findElement(By.xpath(buildLocatorForSearch(defaultLocatorInputValue, instanceNodeTypeInputData)))))
//                .click();
//
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(
//                By.xpath(defaultLocatorInputValue)));
//        System.out.println(instanceMachineValue.getText());

        }
        return this;
    }
    public GoogleCloudPricingCalculatorFrame selectAddGPUs(String inputNumberOfGPUs, String inputTypeOfGPUs) {
        //проверить несколько раз тк появляются 2 checkbox


        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(addGPUsCheckBox)).click();


//        chooseNumberOfGPUs(inputNumberOfGPUs);
        selectDataInProcess(currentNumbersGPUs, inputNumberOfGPUs);

//        typeGPUValue.click();
        selectDataInProcess(typeGPUValue, inputNumberOfGPUs);
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableNumbersGPUs));
//        List<WebElement> webElements = driver.findElements(By.xpath(
//                "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']"));
//
//        System.out.println(webElements.size());
//        for (WebElement webelement : webElements) {
//            if (webelement.getText().equals(inputTypeOfGPUs)) {
//                webelement.click();
//            }
//        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectLocalSSD(String inputLocalSSD) {
        // можно объединить с предыдущим(chooseAddGPUs)??
        // если ошибка тоже дописать

        if (!localSSDValue.getText().equals(inputLocalSSD)) {
            selectDataInProcess(localSSDValue, inputLocalSSD);
        }
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(localSSDValue)).click();
////        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableDataText));
//
//        List<WebElement> webElements = driver.findElements(By.xpath(
//                "//*[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'')]"));
//
//        System.out.println(webElements.size());
//        for (WebElement webelement : webElements) {
//            if (webelement.getText().equals(inputLocalSSD)) {
//                webelement.click();
//            }
//        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectDatacenterLocation(String inputDatacenterLocation) {
        // тут слетело
        if (!datacenterLocationValue.getText().equals(inputDatacenterLocation)) {
            selectDataInProcess(datacenterLocationValue, inputDatacenterLocation);
        }
//        datacenterLocationValue.click();
//
//        List<WebElement> webElements = driver.findElements(By.xpath(
//                "//*[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'')]"));
//
//        System.out.println(webElements.size());
//        for (WebElement webelement : webElements) {
//            if (webelement.getText().equals(inputDatacenterLocation)) {
//                webelement.click();
//            }
//        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame selectCommittedUsage(String inputCommittedUsage) {

        if (!webElementCommittedUsageValue.getText().equals(inputCommittedUsage)) {
            System.out.println(webElementCommittedUsageValue.getText());
            selectDataInProcess(webElementCommittedUsageValue, inputCommittedUsage);
        }
//        committedUsageValue.click();
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableDataText));
//
//        List<WebElement> webElements = driver.findElements(By.xpath(
//                "//*[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'')]"));
//
//        System.out.println(webElements.size());
//        for (WebElement webelement : webElements) {
//            if (webelement.getText().equals(inputCommittedUsage)) {
//                webelement.click();
//            }
//        }
        return this;
    }

    public GoogleCloudPricingCalculatorFrame clickAddToEstimate() {
       addToEstimateButton.submit();
        return this;
    }



//    private GoogleCloudPricingCalculatorFrame chooseNumberOfGPUs(String inputNumberOfGPUs) {
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(currentNumbersGPUs)).click();
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableNumbersGPUs));
//        List<WebElement> webElements = driver.findElements(By.xpath(
//                "//*[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'')]"));
//
//        System.out.println(webElements.size());
//        for (WebElement webelement : webElements) {
//            if (webelement.getText().equals(inputNumberOfGPUs)) {
//                webelement.click();
//            }
//        }
//        return this;
//    }

    public List<String> getResults() {
        List<String> listResults = new ArrayList<>();
        listResults.add(selectDataResult(defaultLocatorInResultArea, "VM Class"));
        listResults.add(selectDataResult(defaultLocatorInResultArea, "Instance type"));
        listResults.add(selectDataResult(defaultLocatorInResultArea, "Region"));
        listResults.add(selectDataResult(defaultLocatorInResultArea, "local SSD"));
        listResults.add(webElementCommittedUsageValue.getText());
        listResults.add(selectDataResult(defaultLocatorInResultArea, "Total Estimated Cost"));

//"VM Class", "Instance type", "Region", "local SSD", "commitment term","Total Estimated Cost");
//        return new ArrayList<>(driver.findElements(By.xpath("//*[@id='resultBlock']//div[contains(text(),'')]")));
        return listResults;
    }


//
//    public int countGeneralNumberOfSearchResults() {
//        System.out.println("Search results number for requested term: " + generalSearchResults.size());
//        return generalSearchResults.size();
//    }
////
//    public int countResultsNumberWithSearchTerm() {
//        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath(buildLocatorForSearch(operationSystemData)));
//        System.out.println("Search results number for requested term: " + resultsNumberWithSearchTerm.size());
//        return resultsNumberWithSearchTerm.size();
//    }
    private String buildLocatorForSearch(String defaultLocator, String inputData) {
        String locatorForSearch = String.format(defaultLocator, inputData);

        //below is just utility output via System.out.println since dedicated logger is out of scope at this stage
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }

//    private String buildLocatorForSearch(String defaultLocator,String inputData) {
//        String locatorForSearch = String.format(defaultLocator, inputData);
//
//        //below is just utility output via System.out.println since dedicated logger is out of scope at this stage
//        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
//        return locatorForSearch;
//    }

    private GoogleCloudPricingCalculatorFrame selectDataInProcess(WebElement webElementCurrentValue, String operationSystemData) {
        webElementCurrentValue.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(mdSelectMenuContainer));
        String requiredLocator = buildLocatorForSearch(this.defaultLocatorInSelectArea, operationSystemData);
        driver.findElement(By.xpath(requiredLocator)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath(requiredLocator)));
        return this;
    }

    private String selectDataResult(String defaultLocatorForSearch, String inputData) {
        String requiredLocator = buildLocatorForSearch(defaultLocatorForSearch, inputData);
        return driver.findElement(By.xpath(requiredLocator)).getText();
    }
}


