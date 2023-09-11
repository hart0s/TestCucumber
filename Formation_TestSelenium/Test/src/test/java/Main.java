import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\apache-maven-3.9.4\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("test");
        driver.findElement(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]//input[@type=\"submit\" and @class=\"gNO89b\"]")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.close();
    }
}