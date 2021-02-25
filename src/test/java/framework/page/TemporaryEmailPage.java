package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TemporaryEmailPage extends AbstractPageHardcore {
    private final Logger logger = LogManager.getRootLogger();
    private static final String EMAIL_PAGE_URL = "https://10minutemail.com/";

    @FindBy(xpath = "//section[@id='mail_messages']")
    private WebElement webElementEmailMessages;

    @FindBy(xpath = "//span[@class='copy_icon']")
    private WebElement webElementEmailCopyButton;

    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement webElementOpenEmailLink;

    @FindBy(xpath = "//table[@class='quote']//tr[last()]/td[last()]")
    private WebElement webElementEstimatedMonthlyCostValue;


    public TemporaryEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTemporaryEmail() {
        String generatedEmail="";
        try {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(
                webElementEmailCopyButton)).click();
            generatedEmail = String.valueOf(Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return generatedEmail;
    }

    public TemporaryEmailPage openPage() {
        driver.navigate().to(EMAIL_PAGE_URL);
        logger.info("Email page opened");
        return this;
    }

    public TemporaryEmailPage waitUntilElementToBeVisible(int waitSecond) {
        new WebDriverWait(driver, waitSecond).until(ExpectedConditions.jsReturnsValue(webElementEmailMessages.getText()));
        return this;
    }

    public TemporaryEmailPage clickElementOpenEmailLink() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(
                webElementOpenEmailLink)).click();
        return this;
    }

    public String getMessageFromTemporaryEmailService() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(
                webElementEstimatedMonthlyCostValue)).getText().replaceAll("\\s+", "");
    }
}
