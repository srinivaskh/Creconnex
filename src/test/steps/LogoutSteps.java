package test.steps;

import com.google.inject.Inject;
import org.jbehave.core.annotations.When;
import test.pages.LogoutPage;
import test.pages.PageFactory;

public class LogoutSteps {
    private final LogoutPage logoutPage;

    @Inject
    public LogoutSteps(PageFactory thePageFactory) {
        logoutPage = thePageFactory.newLogoutPage();
    }

    @When("I logout from RealConnex application")
    public void logOutPage(){
        logoutPage.logOutPage();
    }

    @When("I logout RealConnex application")
    public void clickLogout(){
        logoutPage.clickLogout();
    }


    @When("I click on edit button to start search")
    public void clickEditToFindNow(){
        logoutPage.clickEditToFindNow();
    }

}
