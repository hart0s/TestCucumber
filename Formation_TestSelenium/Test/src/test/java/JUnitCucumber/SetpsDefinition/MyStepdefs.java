package JUnitCucumber.SetpsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static JUnitCucumber.SetpsDefinition.Hooks.driver;

public class MyStepdefs {

    @Given("A user goes to {string}")
    public void andUserGoTo(String arg0) {
        driver.get(arg0);
    }

    @When("He fills in the Email or phone number field with {string}")
    public void heFillsInTheEmailOrPhoneNumberField(String arg0) {
        driver.findElement(By.xpath("//input[@id=\"inputPhoneNumber\"]")).sendKeys(arg0);
    }

    @When("He fills in the Pin code field with {string}")
    public void heFillsInThePinCodeFieldWith(String arg0) {
        driver.findElement(By.xpath("//input[@id=\"inputSmsCode\"]")).sendKeys(arg0);
    }

    @When("He clicks on the login button")
    public void heClicksOnTheLoginButton() {
        driver.findElement(By.xpath("//button[@id=\"connexion\"]")).click();
    }

    @Then("He arrives on {string} page")
    public void heArrivesOnPage(String arg0) {
        Assert.assertEquals(driver.getCurrentUrl(), arg0);
    }

    @Then("The field  Email or phone number is fill with {string}")
    public void theFieldEmailOrPhoneNumberIsFillWith(String arg0) {
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"inputPhoneNumber\"]")).getAttribute("value"), arg0);
    }

    @Then("The field Pin code is fill with {string}")
    public void theFieldPinCodeIsFillWith(String arg0) {
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"inputSmsCode\"]")).getAttribute("value"), arg0);
    }

    @Then("He arrives on M2ISign signature page")
    public void heArrivesOnMISigneSignaturePage() {
        Assert.assertFalse(driver.findElements(By.xpath("//div[@class=\"login_button\"]")).isEmpty());
    }

    @When("He clicks on the button timesheet")
    public void heClicksOnTheButtonTimesheet() {
        driver.findElement(By.xpath("//li/a[@href=\"/timesheet\"]/span/../..")).click();
    }

    @Then("He arrives on the timesheet page")
    public void heArrivesOnTheTimesheetPage() {
        Assert.assertFalse(driver.findElements(By.xpath("//li[@class=\"active\"]/a[@href=\"/timesheet\"]")).isEmpty());
    }

    private static String getTimeToXpath() {
        return new SimpleDateFormat("MM/dd/yyyyaa").format(new Date()).toLowerCase(Locale.ROOT);
    }

    @When("He clicks on the current period")
    public void heClicksOnTheCurrentPeriod() throws InterruptedException {
        driver.findElement(By.xpath("//img[@id=\"" + getTimeToXpath() + "\"]/../..")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    @Then("The current period is signed")
    public void theCurrentPeriodIsSigned() {
        Assert.assertFalse("Signature", driver.findElement(By.xpath("//img[@id=\"" + getTimeToXpath() + "\"]")).getAttribute("src").contains("signatureicon.jpg"));
    }

    @When("He validate and log out")
    public void heValidateAndLogOut() {
        WebElement header = driver.findElement(By.xpath("//header"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].className = \"header\";", header);
        driver.findElement(By.xpath("//div[@class=\"login_button\"]")).click();
    }

    @Then("He arrives on the login page")
    public void heArrivesOnTheLoginPage() {
        Assert.assertFalse(driver.findElements(By.xpath("//button[@id=\"connexion\"]")).isEmpty());
    }
}
