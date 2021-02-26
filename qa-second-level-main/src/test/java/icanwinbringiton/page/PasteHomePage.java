package icanwinbringiton.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PasteHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";

    private String expirationsLocator = "//span[@class='select2-results']//li[text()='%s']";
    private String syntaxHighlightingLocator = "//*[@aria-label='------ ALL LANGUAGES -------']//li[text()='%s']";

    @FindBy(id = "postform-text")
    private WebElement textMessageArea;

    @FindBy(xpath = "//*[@data-select2-id='1']")
    private WebElement syntaxHighlightingDropDown;

    @FindBy(xpath = "//*[@data-select2-id ='3']")
    private WebElement expirationDropDown;

    @FindBy(id = "postform-name")
    private WebElement textNameArea;

    @FindBy(xpath = "//div[@class='form-group form-btn-container']/button")
    private WebElement createNewPasteButton;

    public PasteHomePage(WebDriver driver) {
        super(driver);
    }

    public PasteHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteHomePage sendPasteCode(String pasteCodeMessage) {
        textMessageArea.sendKeys(pasteCodeMessage);
        return this;
    }

    public PasteHomePage chooseExpiration(String pasteExpiration) {
        expirationDropDown.click();
        String xpath = String.format(expirationsLocator, pasteExpiration);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(By.xpath(xpath))).click();
        return this;
    }

    public PasteHomePage sendPasteName(String pasteName) {
        textNameArea.sendKeys(pasteName);
        return this;
    }

    public PasteHomePage chooseSyntaxHighlighting(String syntaxHighlighting) {
        syntaxHighlightingDropDown.click();
        String xpath = String.format(syntaxHighlightingLocator, syntaxHighlighting);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(By.xpath(xpath))).click();
        return this;
    }

    public PasteResultsPage createNewPaste() {
        createNewPasteButton.click();
        return new PasteResultsPage(driver);
    }
}

