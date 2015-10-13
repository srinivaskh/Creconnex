package test.steps;

import com.google.inject.Inject;
import org.jbehave.core.annotations.When;
import test.pages.PageFactory;
import test.pages.WindowHandling;

/**
 * Created with IntelliJ IDEA.
 * User: Himanth
 * Date: 8/12/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class WindowHandlingSteps {
    private final WindowHandling windowHandling;

    @Inject
    public WindowHandlingSteps(PageFactory thePageFactory) {
        windowHandling = thePageFactory.newWindowHandling();
    }

    @When("I close all the open browser windows")
    public void closeAllWindows() {
        windowHandling.closeAllWindows();
    }
}
