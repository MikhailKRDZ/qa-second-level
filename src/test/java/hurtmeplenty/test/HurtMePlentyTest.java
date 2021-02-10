package hurtmeplenty.test;

import hurtmeplenty.page.MainPage;
import hurtmeplenty.page.pricingcalculator.GoogleCloudPricingCalculatorFrame;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HurtMePlentyTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "1. Открыть https://cloud.google.com/" +
            "2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска 'Google Cloud Platform Pricing Calculator'" +
            "3. Запустить поиск, нажав кнопку поиска." +
            "4. В результатах поиска кликнуть 'Google Cloud Platform Pricing Calculator' и перейти на страницу калькулятора." +
            "5. Активировать раздел COMPUTE ENGINE вверху страницы" +
            "6. Заполнить форму следующими данными:" +
            "    * Number of instances: 4" +
            "    * What are these instances for?: оставить пустым" +
            "    * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS" +
            "    * VM Class: Regular" +
            "    * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)" +
            "    * Выбрать Add GPUs" +
            "        * Number of GPUs: 1" +
            "        * GPU type: NVIDIA Tesla V100" +
            "    * Local SSD: 2x375 Gb" +
            "    * Datacenter location: Frankfurt (europe-west3)" +
            "    * Commited usage: 1 Year" +
            "7. Нажать Add to Estimate" +
            "8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term" +
            "9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста.")
    public void checkRentalAmountPerMonth() {
        String inputData = "Google Cloud Platform Pricing Calculator";
        String searchResultData = "Google Cloud Platform Pricing Calculator";
        String numberOfInstances = "4";
        String whatInstancesForInputData = "";
        String operationSystemInputData = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
        String virtualMachineTypeInputData = "Regular";
        String instanceNodeSeriesInputData = "N1";
        String instanceNodeNameInputData = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
        String numberOfGPUsInputData = "4";
        String typeOfGPUsInputData = "NVIDIA Tesla V100";
//        String localSSDInputData     = "2x375 GB";  в условии
        String localSSDInputData = "24x375 GB";
        String datacenterLocationInputData = "Frankfurt (europe-west3)";
        String committedUsageInputData = "1 Year";
        String manualCostResultInputData = "USD 3,095.85 per 1 month";

        GoogleCloudPricingCalculatorFrame googleCloudPricingCalculatorFrame = new MainPage(driver)
                .openPage()
                .search(inputData)
                .selectSearchResult(searchResultData)
                .switchToFrameCalculator()
                .inputNumberOfInstances(numberOfInstances)
                .inputWhatInstancesFor(whatInstancesForInputData)
                .selectOperationSystem(operationSystemInputData)
                .selectVirtualMachineType(virtualMachineTypeInputData)
                .selectInstanceNodeSeries(instanceNodeSeriesInputData)
                .selectInstanceNodeName(instanceNodeNameInputData)
                .clickAddGPUs()
                .selectNumberOfGPUs(numberOfGPUsInputData)
                .selectTypeOfGPUs(typeOfGPUsInputData)
                .selectLocalSSD(localSSDInputData)
                .selectDatacenterLocation(datacenterLocationInputData)
                .selectCommittedUsage(committedUsageInputData)
                .clickAddToEstimate();

        Assert.assertEquals(googleCloudPricingCalculatorFrame.getVMClassResult()
                , virtualMachineTypeInputData.toLowerCase()
                , "Search result, VMClass value, is equals virtualMachineTypeInputData.");

        Assert.assertTrue(instanceNodeNameInputData
                        .contains(googleCloudPricingCalculatorFrame.getInstanceTypeResult()),
                "The instanceNodeNameInputData, is contains, Search result, InstanceType value.");

        Assert.assertTrue(datacenterLocationInputData
                        .contains(googleCloudPricingCalculatorFrame.getRegionResult()),
                "The datacenterLocationInputData, is contains search result, Region value.");

        Assert.assertEquals(googleCloudPricingCalculatorFrame.getLocalSSDResult()
                , localSSDInputData.replaceAll("\\s+", ""),
                "The search result, LocalSSD value, is equals localSSDInputData.");

        Assert.assertEquals(googleCloudPricingCalculatorFrame.getCommitmentTermValue()
                , committedUsageInputData.replaceAll("\\s+", ""),
                "The search result, CommitmentTerm value, is equals committedUsageInputData.");

        Assert.assertEquals(googleCloudPricingCalculatorFrame.getTotalEstimatedCostResult()
                , manualCostResultInputData.replaceAll("\\s+", "")
                , "The search result, TotalEstimatedCost value, is equals manualCostResultInputData.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
