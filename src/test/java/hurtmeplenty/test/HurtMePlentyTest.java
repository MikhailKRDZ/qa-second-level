package hurtmeplenty.test;

import hurtmeplenty.page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


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
    public void checkRentalAmountPerMonth() throws InterruptedException {
        String inputData = "Google Cloud Platform Pricing Calculator";
        String searchResultData = "Google Cloud Platform Pricing Calculator";
        String numberOfInstances = "4";
        String whatInstancesForData = "";
//        String whatInstancesForData = "test";
        String operationSystemData = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
        String virtualMachineTypeInputData = "Regular";
//        String instanceNodeTypeInputData = "n1-standard-8(vCPUs: 8, RAM: 30 GB)";
        String instanceNodeTypeInputData = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
//        String inputNumberOfGPUs = "1"; такого нету!!!
        String inputNumberOfGPUs = "4";
        String inputTypeOfGPUs = "NVIDIA Tesla V100";
//        String inputLocalSSD = "2x375 GB";// такого нету
        String inputLocalSSD = "24x375 GB";
        String inputDatacenterLocation = "Frankfurt (europe-west3)";
        String inputCommittedUsage = "1 Year";
        String manualResult = "USD 8,562.34 per 1 month"; //проверить


        List<String> results = new MainPage(driver)
                .openPage()
                .search(inputData)
                .selectSearchResult(searchResultData)
                .switchToFrameCalculator()
                .activateButtonComputeEngine()
                .inputNumberOfInstances(numberOfInstances)
                .inputWhatInstancesFor(whatInstancesForData)
                .selectOperationSystem(operationSystemData)
                .selectVirtualMachineType(virtualMachineTypeInputData)
                .selectInstanceNodeType(instanceNodeTypeInputData)
                .selectAddGPUs(inputNumberOfGPUs, inputTypeOfGPUs)
                .selectLocalSSD(inputLocalSSD)
                .selectDatacenterLocation(inputDatacenterLocation)//
                .selectCommittedUsage(inputCommittedUsage)
                .clickAddToEstimate()
                .getResults();
        for (String string : results) {
            System.out.println(string);
        }
        int a = 1;
// получить результаты
        //изменить точки на sibling и тд
        //    "8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term" +
////md-card-content[@id='resultBlock']//*[contains(text(),'%s')]
//        commitment term?
        //попробуем через commitment term (CommittedUsage)
//        md-card-content[@id='resultBlock']//*[contains(text(),'%s')]
        //            "9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста.")
//

        //sout убрать
        //дописать проверки на если  нет такого эл та
        //объединить

//        assertThat(createdRepositoryName, is(equalTo(expectedRepositoryName)));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
