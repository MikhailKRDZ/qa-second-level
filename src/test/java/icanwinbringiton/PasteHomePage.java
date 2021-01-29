package icanwinbringiton;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PasteHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement textMessageArea;

    @FindBy(xpath = "//*[@ data-select2-id ='3']")
    private WebElement expirationDropDown;

    @FindBy(id = "postform-name")
    private WebElement textNameArea;

    @FindBy(xpath = "//div[@class='form-group form-btn-container']/button")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-format-container']")
    private WebElement syntaxHighlightingContainer;

    public PasteHomePage(WebDriver driver) {
        super(driver);
    }

    public PasteHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PasteHomePage sendPasteCode(String pasteCodeMessage) {
        textMessageArea.sendKeys(pasteCodeMessage);
        return this;
    }

    public PasteHomePage chooseExpiration10Minutes() {
// дописать проверку на происк?
        expirationDropDown.click();
        Actions actions = new Actions(driver);
        actions.build().perform();
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.build().perform();
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.build().perform();
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
        return this;
    }

    public PasteHomePage sendPasteName(String pasteName) {
        textNameArea.sendKeys(pasteName);
        return this;
    }

    public PasteHomePage chooseSyntaxHighlightingBash() {
        // дописать проверку на происк ?
        syntaxHighlightingContainer.click();
        Actions actions = new Actions(driver);
        actions.build().perform();
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.build().perform();
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
        return this;
    }

    public PasteResultsPage createNewPaste() {
        createNewPasteButton.click();
        return new PasteResultsPage(driver);
    }
}


