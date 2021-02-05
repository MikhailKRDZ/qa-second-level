package hurtmeplenty.page.pricingcalculator.frame;

import hurtmeplenty.page.pricingcalculator.GoogleCloudPricingCalculator;
import hurtmeplenty.page.pricingcalculator.GoogleCloudPricingCalculatorResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPricingCalculatorFormToFill extends GoogleCloudPricingCalculator {

    @FindBy(id = "mainForm")
    private WebElement mainForm;

    @FindBy(id = "resultBlock")
    private WebElement results;


    //    @FindBy(xpath = "//div[@class='md-ripple-container']/..//div[contains(text(),'Compute Engine')]")
    @FindBy(xpath = "//md-tab-item/div[@class='tab-holder compute']")
//    @FindBy(xpath = "//md-tab-item//div[contains(text(),'Compute Engine')]")
    private WebElement computeEngineButton;

//    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;


//    @FindBy(xpath = "//md-tab-item/div[contains(text(),'Compute Engine')]']")
//    private WebElement computeEngineText;

    String iframeName = "goog_658667040";

    @FindBy(xpath = "//*[contains(text(),'Number of instances')]")
    private WebElement instances;

    @FindBy(id = "input_63")
    private WebElement currentNumberOfInstances;

    @FindBy(id = "input_64")
    private WebElement whatInstancesFor;

    @FindBy(id = "select_value_label_56")
    private WebElement operationSystemLabel;

    @FindBy(id = "select_value_label_57")
    private WebElement virtualMachineTypeLabel;

    @FindBy(id = "select_value_label_101")
    private WebElement instanceNodeTypeLabel;


    @FindBy(xpath = "//div[contains(text(),'Add GPUs.')]")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']")
    private WebElement availableNumbersGPUs;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text']")
    private WebElement availableDataText;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']")
    private WebElement availableDatacenterLocation;

    @FindBy(xpath = "//*[contains(text(),'Number of GPUs')]/..//span")
    private WebElement currentNumbersGPUs;

    @FindBy(id = "select_value_label_352")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//body[@type]")
    private WebElement frameBody;

    @FindBy(id = "app-progress")
    private WebElement appProgressPricingCalculator;
    @FindBy(xpath = "//h2[contains(text(),'Instances')]")
    private WebElement titleInstances;


    public GoogleCloudPricingCalculatorFormToFill(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }


    public GoogleCloudPricingCalculatorFormToFill activateButtonComputeEngine() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(computeEngineButton)).click();
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill inputNumberOfInstances(String numberOfInstances) {
        currentNumberOfInstances.click();
        currentNumberOfInstances.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill inputWhatInstancesFor(String whatInstancesForData) {
        whatInstancesFor.click();
        if (!whatInstancesFor.getText().equals(whatInstancesForData)) {
            whatInstancesFor.sendKeys(whatInstancesForData);
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill selectOperationSystem(String operationSystemData) {
        if (!operationSystemLabel.getText().equals(operationSystemData)) {
//дописать
            System.out.println(" bad data");
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill selectVirtualMachineType(String virtualMachineTypeInputData) {
        if (!virtualMachineTypeLabel.getText().equals(virtualMachineTypeInputData)) {
//дописать
            System.out.println(" bad data");
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill selectInstanceNodeType(String instanceNodeTypeInputData) {
        if (!instanceNodeTypeLabel.getText().equals(instanceNodeTypeInputData)) {
//дописать
            // и дописать если нету такого
            System.out.println(" bad data");
        }
        //
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill chooseAddGPUs(String inputNumberOfGPUs, String inputTypeOfGPUs) {
        //объединить методы и локаторы?

//        addGPUsCheckBox.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(addGPUsCheckBox)).click();
        chooseNumberOfGPUs(inputNumberOfGPUs);


        //"GPU type: NVIDIA Tesla V100"
        driver.findElement(By.xpath("//*[contains(text(),'GPU type')]/..//md-select-value")).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableNumbersGPUs));
//        driver.findElement(By.xpath(
//                "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']"));
        List<WebElement> webElements = driver.findElements(By.xpath(
                "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']"));

        System.out.println(webElements.size());
        for (WebElement webelement : webElements) {
            if (webelement.getText().equals(inputTypeOfGPUs)) {
                webelement.click();
            }
        }

        int a = 0;
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill chooseLocalSSD(String inputLocalSSD) {
        // можно объединить с предыдущим(chooseAddGPUs)??
        // если ошибка тоже дописать

        driver.findElement(By.xpath("//label[contains(text(),'Local SSD')]/..//md-select-value")).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableDataText));

        List<WebElement> webElements = driver.findElements(By.xpath(
                "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text']"));

        System.out.println(webElements.size());
        for (WebElement webelement : webElements) {
            if (webelement.getText().equals(inputLocalSSD)) {
                webelement.click();
            }
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill chooseDatacenterLocation(String inputDatacenterLocation) {
        driver.findElement(By.xpath(
                "//form[@name='SoleTenantForm']//*[contains(text(),'Datacenter location')]/..//md-select-value"))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableDatacenterLocation));

        List<WebElement> webElements = driver.findElements(By.xpath(
                "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']"));

        System.out.println(webElements.size());
        for (WebElement webelement : webElements) {
            if (webelement.getText().equals(inputDatacenterLocation)) {
                webelement.click();
            }
        }
        return this;
    }

    public GoogleCloudPricingCalculatorFormToFill chooseCommittedUsage(String inputCommittedUsage) {
        driver.findElement(By.xpath(
                "//form[@name='SoleTenantForm']//*[contains(text(),'Committed usage')]/..//md-select-value"))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableDataText));

        List<WebElement> webElements = driver.findElements(By.xpath(
                "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text']"));

        System.out.println(webElements.size());
        for (WebElement webelement : webElements) {
            if (webelement.getText().equals(inputCommittedUsage)) {
                webelement.click();
            }
        }
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(driver.findElement(By.xpath(
//                "//form[@name='SoleTenantForm']//label[contains(text(),'Committed usage')]")))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorResultsPage clickAddToEstimate() throws InterruptedException {
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        System.out.println("checkbox selected");
//        Thread.sleep(4000);
//// JavascriptExecutor js = (JavascriptExecutor) driver;
//        jse.executeScript("scroll(0, -250);"); //x value '250' can be altered
//        Thread.sleep(2000);

//        WebElement element = driver.findElement(By.xpath("//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element);
//        actions.perform();
//        WebElement element = driver.findElement(By.xpath("//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(500);

        //form[@name='ComputeEngineForm']//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']
        // не работает пока невидим ( адо двигать страницу
//        //form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(addToEstimateButton)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(addToEstimateButton)).submit();
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(element)).click();
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(element)).submit();
        return new  GoogleCloudPricingCalculatorResultsPage(this.driver);
//        return this;
    }



    private GoogleCloudPricingCalculatorFormToFill chooseNumberOfGPUs(String inputNumberOfGPUs) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(currentNumbersGPUs)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(availableNumbersGPUs));
        List<WebElement> webElements = driver.findElements(By.xpath(
                "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding']"));

        System.out.println(webElements.size());
        for (WebElement webelement : webElements) {
            System.out.println(webelement.getText() + "  " + inputNumberOfGPUs);
            if (webelement.getText().equals(inputNumberOfGPUs)) {
//                System.out.println(webelement.getText() + "  " + inputNumberOfGPUs + " equals!!!!!!!!!!!");
                webelement.click();
            }
        }
        return this;
    }
}


