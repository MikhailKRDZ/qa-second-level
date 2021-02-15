package hardcore.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageHardcore {

	protected WebDriver driver;
	protected Actions actions;

	protected final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPageHardcore(WebDriver driver)
	{
		this.driver = driver;
		actions = new Actions(driver);

		PageFactory.initElements(driver, this);
	}
}
