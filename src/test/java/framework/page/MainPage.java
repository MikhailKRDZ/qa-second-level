package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPageHardcore
{
	private final Logger logger = LogManager.getRootLogger();
	private static final String HOME_PAGE_URL = "https://cloud.google.com/";

	@FindBy(xpath = "//form[@class='devsite-search-form']")
	private WebElement searchButton;

	@FindBy(xpath = "//form[@class='devsite-search-form']//input")
	private WebElement inputDataField;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public MainPage openPage() {
		driver.get(HOME_PAGE_URL);
		return this;
	}

	public SearchResultsPage search(String inputData) {
		searchButton.click();
		inputDataField.sendKeys(inputData);
		inputDataField.submit();
		return new SearchResultsPage(this.driver);
	}
}
