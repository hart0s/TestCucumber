import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Main2 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\apache-maven-3.9.4\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sign.m2iformation.fr/signin");
        driver.findElement(By.xpath("//input[@id=\"inputPhoneNumber\"]")).sendKeys("alexandre.renaud.08@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"inputSmsCode\"]")).sendKeys("39116");
        driver.findElement(By.xpath("//button[@id=\"connexion\"]")).click();
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.xpath("//li/a[@href=\"/timesheet\"]/span/../..")).click();
        driver.findElement(By.xpath("//img[@id=\"" + getTimeToXpath() + "\"]/../..")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.close();

    }

    private static String getTimeToXpath() {
        SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyyaa");
        return formater.format(new Date()).toLowerCase(Locale.ROOT);
    }
}