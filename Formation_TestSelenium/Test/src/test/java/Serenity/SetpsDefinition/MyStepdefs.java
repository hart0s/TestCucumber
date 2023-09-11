package Serenity.SetpsDefinition;

import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.time.temporal.ChronoUnit;

public class MyStepdefs extends PageObject {

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    WebElementFacade searchBar;

    @FindBy(xpath = "//input[@id=\"sp-cc-accept\"]")
    WebElementFacade cookieAcceptButton;

    @FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
    WebElementFacade spyGlassButton;

    @When("Un utilisateur va sur {string}")
    public void unUtilisateurVaSur(String arg0) {
        openAt(arg0);
    }

    @When("Un utilisateur tape dans la barre de recherche {string}")
    public void unUtilisateurTapeDansLaBarreDeRecherche(String arg0) {
        searchBar.sendKeys(arg0);
    }

    @When("Un utilisateur valide les cookie")
    public void unUtilisateurValideLesCookie() {
        cookieAcceptButton.click();
    }

    @When("Un utilisateur appuye sur la loupe")
    public void unUtilisateurAppuyeSurLaLoupe() {
        spyGlassButton.withTimeoutOf(10, ChronoUnit.SECONDS).waitUntilVisible();
        spyGlassButton.waitUntilClickable().click();
    }
}
