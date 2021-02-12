package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TemporaryEmailPage {
    private WebDriver driver;
    private static final String EMAIL_PAGE_URL = "https://10minutemail.com/";
    public TemporaryEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTemporaryEmail() {
        driver.findElement((By.xpath("//span[@class='copy_icon']"))).click();
        Actions actions = new Actions(driver);
        try {
            return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return   actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();
//        return   driver.findElement((By.xpath("//span[@class='copy_icon']"))).getText();
//        return  driver.findElement(By.xpath("//div[@class='mail_address']")).getText();
        return null;
    }

    public TemporaryEmailPage openPage() {
        driver.get(EMAIL_PAGE_URL);
        return this;
    }
    public TemporaryEmailPage waitUntilElementToBeClickable(int waitSecond) {
//        while (driver.findElements(By.xpath("//div[@class='message_top']")).size() == 0) {
        while (driver.findElements(By.xpath("//section[@id='mail_messages']")).size() == 0) {
            new WebDriverWait(driver, waitSecond);
        }
        return this;
    }

    public TemporaryEmailPage clickElement() {
        driver.findElement(By.xpath("//div[@class='message_top']")).click();
        return this;
    }

    public String getMessageFromTemporaryEmailService() {
//        System.out.println(driver.getTitle());
//
//        System.out.println(driver.findElement(By.xpath("//div[@class='message_top']/..//div[@dir='ltr']")).getText());
//        int a = 0;
//        return driver.findElement(By.xpath("//div[@class='message_top']/..//div[@dir='ltr']")).getText();
        return driver.findElement(By.xpath("//*[contains(text(),'Estimated Monthly Cost:')]")).getText();
    }
}
