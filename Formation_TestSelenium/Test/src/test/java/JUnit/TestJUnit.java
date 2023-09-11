package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestJUnit {
    static WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() throws InterruptedException {
        String pathToUblockOrigin = "src\\test\\java\\junit\\ublockOrigin.crx";
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(pathToUblockOrigin));
        driver = new ChromeDriver(options);
        TimeUnit.SECONDS.sleep(2);
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void connexionM2IFormationOK() throws InterruptedException {
        driver.get("https://sign.m2iformation.fr/signin");
        driver.findElement(By.xpath("//input[@id=\"inputPhoneNumber\"]")).sendKeys("alexandre.renaud.08@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"inputSmsCode\"]")).sendKeys("39116");
        driver.findElement(By.xpath("//button[@id=\"connexion\"]")).click();
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    void connexionM2IFormationKO() throws InterruptedException {
        driver.get("https://sign.m2iformation.fr/signin");
        driver.findElement(By.xpath("//input[@id=\"inputPhoneNumber\"]")).sendKeys("alexandre.renaud@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"inputSmsCode\"]")).sendKeys("39116");
        driver.findElement(By.xpath("//button[@id=\"connexion\"]")).click();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(driver.findElement(By.xpath("//div[@id=\"erreur-message\"]")).getText());
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    void demoqaSlider50() throws InterruptedException {
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//div[@class=\"category-cards\"]/div[4]")).click();
        WebElement footer = driver.findElement(By.xpath("//footer"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].remove();", footer);
        driver.findElement(By.xpath("//div[contains(@class, \"collapse show\")]/ul/li[4]")).click();
        WebElement slider = driver.findElement(By.xpath("//span[@class=\"range-slider__wrap\"]"));
        Dimension sliderDimension = slider.getSize();
        Actions actions = new Actions(driver);
        actions.moveByOffset(slider.getLocation().getX()+sliderDimension.width/2, slider.getLocation().getY()+1).click().perform();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"sliderValue\"]")).getAttribute("value"), "50");
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    void demoqaSortable() throws InterruptedException {
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//div[@class=\"category-cards\"]/div[5]")).click();
        WebElement footer = driver.findElement(By.xpath("//footer"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].remove();", footer);
        driver.findElement(By.xpath("//div[contains(@class, \"collapse show\")]/ul/li[1]")).click();
        WebElement one = driver.findElement(By.xpath("//div[contains(@class, \"tab-pane active show\")]/div/div[@class=\"list-group-item list-group-item-action\"][1]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(one);
        WebElement two = driver.findElement(By.xpath("//div[contains(@class, \"tab-pane active show\")]/div/div[@class=\"list-group-item list-group-item-action\"][2]"));
        actions.moveToElement(two);
        actions.release().perform();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, \"tab-pane active show\")]/div/div[@class=\"list-group-item list-group-item-action\"][2]")).getText(), "One");
        TimeUnit.SECONDS.sleep(2);
    }
}
