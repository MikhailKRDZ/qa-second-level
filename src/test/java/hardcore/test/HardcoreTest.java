package hardcore.test;


import hardcore.page.MainPage;
import hardcore.page.TemporaryEmailPage;
import hardcore.page.pricingcalculator.GoogleCloudPricingCalculatorFrame;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class HardcoreTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "1. Открыть https://cloud.google.com/ " +
            "2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска" +
            "'Google Cloud Platform Pricing Calculator'" +
            "3. Запустить поиск, нажав кнопку поиска." +
            "4. В результатах поиска кликнуть 'Google Cloud Platform Pricing Calculator' и перейти на страницу калькулятора" +
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
            //
            "8. Выбрать пункт EMAIL ESTIMATE" +
            "9. В новой вкладке открыть https://10minutemail.com или аналогичный сервис для генерации временных email'ов" +
            "10. Скопировать почтовый адрес сгенерированный в 10minutemail" +
            "11. Вернуться в калькулятор, в поле Email ввести адрес из предыдущего пункта" +
            "12. Нажать SEND EMAIL" +
            "13. Дождаться письма с рассчетом стоимости и проверить что " +
            "Total Estimated Monthly Cost в письме совпадает с тем, что отображается в калькуляторе")
    public void checkRentalAmountPerMonth() {
        String inputData = "Google Cloud Platform Pricing Calculator";
        String searchResultData = "Google Cloud Platform Pricing Calculator";
        String numberOfInstances = "4";
        String whatInstancesForInputData = "";
        String operationSystemInputData = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
        String virtualMachineTypeInputData = "Regular";
        String instanceNodeSeriesInputData = "N1";
        String instanceNodeNameInputData = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
        String numberOfGPUsInputData = "1";
        String typeOfGPUsInputData = "NVIDIA Tesla V100";
        String localSSDInputData     = "2x375 GB";
        String datacenterLocationInputData = "Frankfurt (europe-west3)";
        String committedUsageInputData = "1 Year";

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

        String totalCalculatorEstimatedCostResult = googleCloudPricingCalculatorFrame
                .getTotalEstimatedCostResult();

        googleCloudPricingCalculatorFrame =
                googleCloudPricingCalculatorFrame
                        .clickEmailEstimateButton();

        ((JavascriptExecutor) driver).executeScript("window.open()");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String postAddressFromTemporaryEmailService = new TemporaryEmailPage(driver)
                .openPage()
                .getTemporaryEmail();

        driver.switchTo().window(tabs.get(0));

        googleCloudPricingCalculatorFrame
                .switchToFrameCalculator()
                .inputPostAddressValueToEstimate(postAddressFromTemporaryEmailService)
                 .clickSendEmailButton();

        driver.switchTo().window(tabs.get(1));

        String totalPostEstimatedCostResult = new TemporaryEmailPage(driver)
                .waitUntilElementToBeClickable(100)
                .clickElementOpenEmailLink()
                .getMessageFromTemporaryEmailService();

        Assert.assertTrue(totalCalculatorEstimatedCostResult.contains(totalPostEstimatedCostResult)
                , "The search result, totalCalculatorEstimatedCostResult contains totalPostEstimatedCostResult");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
