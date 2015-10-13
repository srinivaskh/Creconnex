package test.pages;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import test.Support.ReadData;
import test.Support.ReasonsInResultSheet;
import test.steps.VerificationStatements;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bhavana
 * Date: 7/3/14
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class LoginRealConnexPage extends FluentWebDriverPage {
    public static String lStrNewCreatedUserName = "";
    public static String gStrReason = "";
    public static String gStrFieldName = "";
    ReadData ReadData = new ReadData();
    public LoginRealConnexPage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void launchRealConnexPage() throws IOException {
        // Runtime.getRuntime().exec("D:\\SampleScenarios\\src\\AutoIt\\authenticationPopUp.exe");
        getDriverProvider().get().manage().deleteAllCookies();
        //get("http://realconnex.project-release.info/");
       //get("http://realconnex-release.project-release.info/");
       // get("http://realconnex-features.project-release.info/");
        get("http://creconnex.com");
       // get("http://54.213.177.129/");
        getDriverProvider().get().manage().window().maximize();
        //wait until page load
        WaitUtil.simpleSleep(5000);
    }

    public void clickLogInButtonInLoginPage(){
        //wait until page load
        WaitUtil.simpleSleep(5000);
        findElement(By.cssSelector("#header > div > a.login")).click();
    }

    public void enterEmailId(int RowIndex) {
        try {
            String strEmailId = ReadData.readDataExcel("LoginRealConnex", RowIndex, "EmailId");
            gStrFieldName = findElement(By.id("UserLoginPopupEmail")).getAttribute("placeholder");
            ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.id("UserLoginPopupEmail"), strEmailId, gStrFieldName, LoginRealConnexPage.gStrReason);
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    public void enterPassword(int RowIndex) throws Exception {
        String strPassword = ReadData.readDataExcel("LoginRealConnex", RowIndex, "Password");
        gStrFieldName = findElement(By.id("UserLoginPopupPassword")).getAttribute("placeholder");
        ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.id("UserLoginPopupPassword"), strPassword, gStrFieldName, LoginRealConnexPage.gStrReason);
    }

    public void clickLogIn(){
        gStrFieldName = findElement(By.xpath("//form[@id='UserLoginPopup']/fieldset/div/input")).getAttribute("value");
        int intCnt=0;
        boolean blnFound=false;
        while(!blnFound && intCnt<=5){
            try{
                findElement(By.xpath("//form[@id='UserLoginPopup']/fieldset/div/input[@value='Login']")).sendKeys(Keys.ENTER);
                Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//nav[@id='nav']/div/a"), getDriverProvider().get()));
                blnFound=true;
            }catch(WebDriverException e){
                WaitUtil.simpleSleep(100);
                LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+gStrFieldName+"\nReason of Error:"+"Login button is not clicked\n";
                intCnt++;
            } catch (AssertionError A){
                WaitUtil.simpleSleep(100);
                LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+gStrFieldName+"\nReason of Error:"+"RealConnex home page is not displayed\n";
                intCnt++;
            }
        }
    }

    public void enterLoginDetails(ExamplesTable LoginDetailsTable){
        String strEmailId = "", strPassword = "";
        String strArr[] =new String[LoginDetailsTable.getRowCount()];
        int i= 0;
        for (Map<String,String> row : LoginDetailsTable.getRows()) {
            strArr[i] = row.get("Value");
            i++;
        }
        strEmailId = strArr[0];
        strPassword = strArr[1];
        findElement(By.id("UserLoginPopupEmail")).clear();
        findElement(By.id("UserLoginPopupEmail")).sendKeys(strEmailId);
        VerificationStatements.VerifyInputValue(getDriverProvider().get(),By.id("UserLoginPopupEmail"),strEmailId);
        findElement(By.id("UserLoginPopupPassword")).clear();
        findElement(By.id("UserLoginPopupPassword")).sendKeys(strPassword);
        VerificationStatements.VerifyInputValue(getDriverProvider().get(),By.id("UserLoginPopupPassword"),strPassword);
    }

    public void enterEmailIdOfUsers(int intRowIndex) {
        try{
             gStrFieldName = findElement(By.id("UserLoginPopupEmail")).getAttribute("placeholder");
            String lStrEmail = ReadData.readDataExcel("LoginRealConnex", intRowIndex,"EmailId");
            ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.id("UserLoginPopupEmail"), lStrEmail, gStrFieldName, LoginRealConnexPage.gStrReason);
        } catch (Exception e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"\nReason of Error:"+"Unable to read excel\n";
        }
    }

    public void enterPasswordOfUser(int intRowIndex) throws Exception {
        String lStrPasswordOfUser = ReadData.readDataExcel("LoginRealConnex", intRowIndex,"Password");
        gStrFieldName = findElement(By.id("UserLoginPopupPassword")).getAttribute("placeholder");
        ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.id("UserLoginPopupPassword"), lStrPasswordOfUser, gStrFieldName, LoginRealConnexPage.gStrReason);
    }

    public void clickCntrlF() throws AWTException {
        WaitUtil.simpleSleep(5000);
        Robot robot = new Robot();
        robot.delay(5000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
    }

    public void verifyConfirmationNeeded(){
        WaitUtil.waitForElementAppearance(getDriverProvider().get(),"h4.ui-pnotify-title");
        Assert.assertEquals("Confirmation needed.", findElement(By.cssSelector("h4.ui-pnotify-title")).getText());
    }

    public void clickOkButtonAndVerifySignInRealConnexIsDisplayed(){
        findElement(By.xpath("//button[@type='button']")).click();
        WaitUtil.waitForElementAppearance(getDriverProvider().get(),"#login > div.title > strong");
        WaitUtil.simpleSleep(1000);
        Assert.assertEquals("Sign In to RealConnex!",findElement(By.cssSelector("#login > div.title > strong")).getText());
        WaitUtil.simpleSleep(1000);
    }

}
