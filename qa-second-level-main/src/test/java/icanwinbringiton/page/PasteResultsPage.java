package icanwinbringiton.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasteResultsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='source']")
    private WebElement pasteCodeResult;

    @FindBy(xpath = "//*[@class='left']//a")
    private WebElement syntaxHighlightingResults;

    @FindBy(className = "info-top")
    private WebElement pasteNameResults;

    public PasteResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getPasteNameResults() {
        return pasteNameResults.getText();
    }

    public String getPasteCode() {
        return pasteCodeResult.getText();
    }

    public String getPasteSyntax() {
        return syntaxHighlightingResults.getText();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please 'think twice' whether you need this page open directly " +
                "if direct access is still needed - please dig into Google Custom Search engine at" +
                " https://cse.google.com/cse/ for proper implementation " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage.");
    }
}
