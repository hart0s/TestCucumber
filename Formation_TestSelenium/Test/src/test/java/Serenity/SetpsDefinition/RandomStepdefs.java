package Serenity.SetpsDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RandomStepdefs extends PageObject {

    @FindBy(xpath = "//input[contains(@id, \"max\")]")
    WebElementFacade inputMaxValue;

    @FindBy(xpath = "//input[contains(@id, \"min\")]")
    WebElementFacade inputMinValue;

    @FindBy(xpath = "//input[@value=\"Generate\"]")
    WebElementFacade generateButton;

    @FindBy(xpath = "//span[contains(@id, \"result\")]/center/span[2]")
    WebElementFacade resultMinMaxSpan;

    @FindBy(xpath = "//span[contains(@id, \"result\")]/center/span[1]")
    WebElementFacade resultValueSpan;

    @FindBy(xpath = "//button[text()=\"Allow Selected\"]")
    WebElementFacade cookieAllowSelected;

    @FindBy(xpath = "//a[@href=\"/#games\"]")
    WebElementFacade gamesMenu;

    @FindBy(xpath = "//a[@href=\"/#lists\"]")
    WebElementFacade listMoreMenu;

    @FindBy(xpath = "//a[@href=\"/dice/\"]")
    WebElementFacade diceRollMenu;
    @FindBy(xpath = "//a[@href=\"/lists/\"]")
    WebElementFacade listMenu;

    @FindBy(xpath = "//select[@name=\"num\"]")
    WebElementFacade diceRollSelector;

    @FindBy(xpath = "//h2[text()=\"List Randomizer\"]")
    WebElementFacade listTitle;

    @FindBy(xpath = "//input[@type=\"submit\" and @value=\"Roll Dice\"]")
    WebElementFacade diceRollerButton;

    @FindBy(xpath = "//p[contains(text(), \"You rolled\")]")
    WebElementFacade rolledText;

    @FindBy(xpath = "//p/img")
    List<WebElementFacade> diceImageList;

    @FindBy(xpath = "//textarea[@name=\"list\"]")
    WebElementFacade listTextArea;

    @Given("A random user goes to {string}")
    public void aRandomUserGoesTo(String url) {
        openAt(url);
    }

    @When("A random user sets the max value {string}")
    public void aRandomUserSetsTheMaxValue(String max) {
        getDriver().switchTo().frame(0);
        inputMaxValue.clear();
        inputMaxValue.sendKeys(max);
    }

    @And("A random user clicks on the generate button")
    public void aRandomUserClicksOnTheGenerateButton() {
        generateButton.click();
        waitABit(1000);
    }

    @Then("A random user verifies if the max value under the result shows {string}")
    public void aRandomUserVerifiesIfTheMaxValueUnderTheResultShows(String max) {
        Assert.assertTrue(resultMinMaxSpan.containsText(max));
    }

    @And("A random user verifies if the min value under the result shows {string}")
    public void aRandomUserVerifiesIfTheMinValueUnderTheResultShows(String min) {
        Assert.assertTrue(resultMinMaxSpan.containsText(min));
    }

    @And("A random user verifies if the result number between {int} and {int} \\(included) is generated")
    public void aRandomUserVerifiesIfTheResultNumberBetweenAndIncludedIsGenerated(int min, int max) {
        int randomResult = Integer.parseInt(resultValueSpan.getText());
        Assert.assertTrue(randomResult >= min && randomResult <= max);
    }

    @When("A random user sets the min value {string}")
    public void aRandomUserSetsTheMinValue(String min) {
        getDriver().switchTo().frame(0);
        inputMinValue.clear();
        inputMinValue.sendKeys(min);
    }

    @Then("A random user verifies if the max value input field is set at {string}")
    public void aRandomUserVerifiesIfTheMaxValueInputFieldIsSetAt(String max) {
        Assert.assertEquals(inputMaxValue.getValue(), max);
    }

    @When("A random user clicks on Allow selected for the cookies")
    public void aRandomUserClicksOnAllowSelectedForTheCookies() {
        cookieAllowSelected.click();
    }

    @And("A random user hovers the Games menu")
    public void aRandomUserHoversTheMenu() {
        withAction().moveToElement(gamesMenu).perform();
    }

    @And("A random user clicks on the Dice roller option")
    public void aRandomUserClicksOnTheOption() {
        diceRollMenu.click();
    }

    @Then("A random user arrives on the Dice roller page")
    public void aRandomUserArrivesOnThePage() {
        Assert.assertTrue(diceRollerButton.isVisible());
    }

    @When("A random user selects {int} on the number of dices selector")
    public void aRandomUserSelectsOnTheNumberOfDicesSelector(int arg0) {
        Select select = new Select(diceRollSelector);
        select.selectByValue(String.valueOf(arg0));
    }

    @And("A random user clicks on the Roll Dice button")
    public void aRandomUserClicksOnTheRollDiceButton() {
        diceRollerButton.click();
    }

    @Then("A random user verifies the sentence over the dice are {string}")
    public void aRandomUserVerifiesTheSentenceOverTheDiceAre(String arg0) {
        Assert.assertEquals(rolledText.getText(), arg0);
    }

    @And("A random user verifies there are {int} dices pictures shown")
    public void aRandomUserVerifiesThereAreDicesPicturesShown(int arg0) {
        Assert.assertEquals(diceImageList.size(), arg0);
    }

    @And("A random user hovers the List & More menu")
    public void aRandomUserHoversTheListMoreMenu() {
        withAction().moveToElement(listMoreMenu).perform();
    }

    @And("A random user clicks on the List & More option")
    public void aRandomUserClicksOnTheListMoreOption() {
        listMenu.click();
    }

    @Then("A random user arrives on the List page")
    public void aRandomUserArrivesOnTheListMorePage() {
        Assert.assertTrue(listTitle.isVisible());
    }

    @When("A random user input in the text box")
    public void aRandomUserInputNameListInTheTextBox(DataTable nameList) {
        List<List<String>> rows = nameList.asLists(String.class);
        for(List<String> column : rows) {
            listTextArea.sendKeys(column.get(0) + " : " + column.get(1) + "\n");
        }
    }
}
