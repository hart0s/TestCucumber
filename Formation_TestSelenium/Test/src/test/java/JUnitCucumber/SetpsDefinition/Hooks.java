package JUnitCucumber.SetpsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    static WebDriver driver;

    @Before
    public void beforeScenario() throws InterruptedException {
        String pathToUblockOrigin = "src\\test\\resources\\ublockOrigin.crx";
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(pathToUblockOrigin));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void afterScenario()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }


}
