package icanwinbringiton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BringItOnTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере" +
            "2. Создать New Paste со следующими деталями:" +
            "* Код:" +
            "git config --global user.name 'New Sheriff in Town'" +
            "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')" +
            "git push origin master --force" +
            "* Syntax Highlighting: 'Bash'" +
            "* Paste Expiration: '10 Minutes'" +
            "* Paste Name / Title: 'how to gain dominance among developers'" +
            "3. Сохранить paste и проверить следующее:" +
            "* Заголовок страницы браузера соответствует Paste Name / Title" +
            "* Синтаксис подвечен для bash" +
            "* Проверить что код соответствует введенному в пункте 2")
    public void isNewPasteContains() {
        String pasteCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String syntaxHighlighting= "Bash";
        String pasteExpiration = "10 Minutes";
        String pasteName = "how to gain dominance among developers";
        boolean searchResultsContainsPasteCode = false;
        boolean searchResultsContainsPasteExpiration = false;
        boolean searchResultsContainsPasteName = false;

List<String> expectedPasteResults = new PasteHomePage(driver)
                .openPage()
                .sendPasteCode(pasteCode)
                .chooseSyntaxHighlightingBash()
                .chooseExpiration10Minutes()
                .sendPasteName(pasteName)
                .createNewPaste()
                .getListResults();

        searchResultsContainsPasteName = expectedPasteResults.get(0).equals(pasteName);
        searchResultsContainsPasteExpiration = expectedPasteResults.get(1).equals(pasteExpiration);
        searchResultsContainsPasteCode = expectedPasteResults.get(2).equals(pasteCode);

        System.out.println(expectedPasteResults.get(0));
        System.out.println(expectedPasteResults.get(1) );
        System.out.println(expectedPasteResults.get(2));

        Assert.assertTrue(searchResultsContainsPasteName, "Search results contains pasteName!");
        Assert.assertTrue(searchResultsContainsPasteExpiration, "Search results contains pasteExpiration!");
        Assert.assertTrue(searchResultsContainsPasteCode, "Search results contains pasteCode! ");
        int a = 0;

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
