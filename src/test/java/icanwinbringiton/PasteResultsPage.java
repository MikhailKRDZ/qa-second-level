package icanwinbringiton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PasteResultsPage extends AbstractPage {

    @FindBy(xpath = "//textarea/text()")
    private WebElement pasteCodeResult;

    @FindBy(xpath = "//ol//div")
    private WebElement pasteExpirationResult;

    @FindBy(xpath = "//h1")
    private WebElement pasteName;

    public PasteResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getPasteName() {
        return pasteName.getTagName();
    }

    public String getPasteCode() {
        return pasteCodeResult.getText();
    }
    public String getPasteBash() {
        // не работает
        List<WebElement> webElements = driver.findElements(By.xpath("//ol//div"));
        return webElements.toString();
    }

    public ArrayList<String> getListResults() {
        ArrayList<String> listResults = new ArrayList<>();
        listResults.add(getPasteName());
        listResults.add(getPasteBash());
        listResults.add(getPasteCode());
        return new ArrayList<>();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException ("Please 'think twice' whether you need this page open directly " +
                "if direct access is still needed - please dig into Google Custom Search engine at" +
                " https://cse.google.com/cse/ for proper implementation " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage.");
    }
}
