package icanwinbringiton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ICanWinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Автоматизировать следующий сценарий:"+
            "Открыть https://pastebin.com или аналогичный сервис в любом браузере " +
            "Создать New Paste со следующими деталями: " +
            "* Код: 'Hello from WebDriver' " +
            "* Paste Expiration: '10 Minutes'" +
            "* Paste Name / Title: 'helloweb'")
    public void isNewPasteCreated() {
        String pasteCode = "Hello from WebDriver";
        String pasteExpiration = "10 Minutes"; //есть
        String pasteName = "helloweb";

        String stringURL = new PasteHomePage(driver)
                .openPage()
                .sendPasteCode(pasteCode)
                .chooseExpiration10Minutes()
                .sendPasteName(pasteName)
                .createNewPaste()
                .getURL();
        Assert.assertTrue(stringURL.contains("https://pastebin.com"), "Search results contains pasteName!");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
