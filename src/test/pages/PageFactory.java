package test.pages;

import com.google.inject.Inject;
import org.jbehave.web.selenium.WebDriverProvider;
import test.Support.ReasonsInResultSheet;


public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    @Inject
    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public WindowHandling newWindowHandling() {
        return new WindowHandling(webDriverProvider);
    }

    public LoginRealConnexPage newLoginRealConnexPage () {
        return new LoginRealConnexPage(webDriverProvider);
    }

    public UserProfilePage newUserProfilePage () {
        return new UserProfilePage(webDriverProvider);
    }

    public PeopleSearchPage newPeopleSearchPage () {
        return new PeopleSearchPage(webDriverProvider);
    }

    public ResultHandlingPage newResultHandlingPage () {
        return new ResultHandlingPage(webDriverProvider);
    }

    public LogoutPage newLogoutPage() {
        return new LogoutPage(webDriverProvider);

    }
}
