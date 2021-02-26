package framework.page;


import org.openqa.selenium.WebDriver;

public abstract class AbstractPageHardcore {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;


    protected AbstractPageHardcore(WebDriver driver) {
        this.driver = driver;
    }
}
