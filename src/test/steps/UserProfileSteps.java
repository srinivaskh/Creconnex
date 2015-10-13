package test.steps;

import com.google.inject.Inject;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import test.pages.PageFactory;
import test.pages.UserProfilePage;

public class UserProfileSteps {
    private final UserProfilePage userProfilePage;

    @Inject
    public UserProfileSteps(PageFactory thePageFactory) {
        userProfilePage = thePageFactory.newUserProfilePage();
    }

    @Then("I should see 'Search' image")
    public void searchImg(){
        userProfilePage.searchImg();
    }

    @When("I click on 'Search' button")
    public void clickSearchImgButton(){
        userProfilePage.clickSearchImgButton();
    }
}
