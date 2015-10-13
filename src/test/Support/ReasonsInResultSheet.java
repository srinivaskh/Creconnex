package test.Support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import test.pages.LoginRealConnexPage;
import test.pages.WaitUtil;
import test.steps.VerificationStatements;
import java.util.NoSuchElementException;


/**
 * Created with IntelliJ IDEA.
 * User: Bhavana
 * Date: 7/28/14
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public final class ReasonsInResultSheet {

    private ReasonsInResultSheet() {
    }

    public static void enterDataToTextField(WebDriver driver,By by, String strValue, String strFieldName, String strReason) {
        try{
            driver.findElement(by).click();
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(strValue);
            VerificationStatements.VerifyInputValue(driver, by, strValue);
        } catch (NoSuchElementException e){
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+strFieldName+"\nReason of Error:"+"Unable to Enter User Name\n";
        } catch (NullPointerException e){
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+strFieldName+"\nReason of Error:"+"Error In Fetching Data From Excel\n";
        } catch (WebDriverException e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+strFieldName+"\nReason of Error:"+"Element is not clickable at point\n";
        }

    }

    public static void assertStatementIfElementIsPresent(By by, WebDriver driver, String strVerifyUserName){
        try{
            Assert.assertTrue(WaitUtil.isElementPresent(by, driver));
        } catch (AssertionError e){
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+""+strVerifyUserName+" user name is not retrieved in Search Result\n";
        }
    }

    public static void assertStatementIfElementIsNotPresent(By by, WebDriver driver){
        try{
            Assert.assertTrue(WaitUtil.verifyElementNotPresent(by, driver,30));
        } catch (AssertionError e){
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"User Name is Retrieved in Search Result\n";
        }
    }

    public static void assertStatementIfElementIsPresentAndFieldName(By by, WebDriver driver, String gStrFieldName){
        //wait until page loads
        WaitUtil.simpleSleep(3000);
        try{
            Assert.assertTrue(WaitUtil.isElementPresent(by, driver));
        }catch (AssertionError e){
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+LoginRealConnexPage.gStrFieldName+"\nReason of Error:"+"Matching User Is Not Displayed\n";
        }
    }

    public static void assertStatementIfElementIsNotPresentAndFieldName(By by, WebDriver driver){
        //wait until page loads
        WaitUtil.simpleSleep(5000);
        try{
            Assert.assertTrue(WaitUtil.verifyElementNotPresent(by, driver,30));
        }catch (AssertionError e){
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+LoginRealConnexPage.gStrFieldName+"\nReason of Error:"+"User Is Displayed\n";
        }
    }
}
