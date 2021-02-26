package hurtmeplenty.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPageHurtMePlenty
{
	private static final String HOME_PAGE_URL = "https://cloud.google.com/";

	@FindBy(xpath = "//form[@class='devsite-search-form']")
	private WebElement searchButton;

	@FindBy(xpath = "//form[@class='devsite-search-form']//input")
	private WebElement inputDataField;

	public MainPage(WebDriver driver)
	{
		super(driver);
	}

	public MainPage openPage()
	{
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
