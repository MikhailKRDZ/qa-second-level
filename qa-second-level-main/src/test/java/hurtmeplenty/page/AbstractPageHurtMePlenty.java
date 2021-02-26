package hurtmeplenty.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageHurtMePlenty {

	protected WebDriver driver;

	protected abstract AbstractPageHurtMePlenty openPage();
	protected final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPageHurtMePlenty(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
