package test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import test.Support.ReadData;
import test.Support.ReasonsInResultSheet;
import java.util.NoSuchElementException;


public class PeopleSearchPage extends FluentWebDriverPage {
    ReadData ReadData = new ReadData();
    int i = 1;
    String gStrFieldName;
    public PeopleSearchPage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void verifyFind(int RowIndex){
        try{
            WaitUtil.simpleSleep(3000);
            String strVerifyFind= ReadData.readDataExcel("PeopleDetails", RowIndex, "VerifyFind");
            Assert.assertEquals(strVerifyFind, findElement(By.xpath("//span[contains(text(),'Find:')]/strong")).getText());
        } catch (AssertionError e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Verification of Find failed";
        } catch (NullPointerException e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Not Able to Find the Excel Sheet";
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*public void verifyDealSponsorUserIsDisplayedName(String strDealSponsorUserName){
        //wait until page loads
        WaitUtil.simpleSleep(3000);
        ReasonsInResultSheet.assertStatementIfElementIsPresentAndFieldName(By.xpath("//a/strong[text()='"+strDealSponsorUserName+"']"), getDriverProvider().get(),gStrFieldName);
    }*/

    public void clickVerifiedDealSponsorUser(int RowIndex){
        try{
            String strClickDealSponsor = ReadData.readDataExcel("PeopleDetails", RowIndex, "DealSponsorName");
            findElement(By.xpath("//strong[contains(text(),'"+strClickDealSponsor+"')]")).click();
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div/h1[contains(text(),'" + strClickDealSponsor + "')]"), getDriverProvider().get()));
        } catch (AssertionError A) {
            System.out.println(A);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"User In Search Result Is not able to Click\n";
        } catch (NoSuchElementException N) {
            System.out.println(N);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Element Is Not Found\n";
        } catch (NullPointerException NP){
            System.out.println(NP);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Data Cannot be Retrieved from Excel\n";
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void verifyInvestorUserName(String strInvestorUserName){
        //wait until page loads
        WaitUtil.simpleSleep(3000);
        ReasonsInResultSheet.assertStatementIfElementIsPresent(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strInvestorUserName+"')]"),getDriverProvider().get(),strInvestorUserName);
    }

    public void clickVerifiedInvestorUser(int RowIndex){
        try{
            String strClickInvestorUser = ReadData.readDataExcel("PeopleDetails", RowIndex, "InvestorUserName");
            findElement(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strClickInvestorUser+"')]")).click();
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div/h1[contains(text(),'"+strClickInvestorUser+"')]"),getDriverProvider().get()));
        } catch (AssertionError e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Investor User Name In Search Result Is Not Able To Click";
        } catch (Exception e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Excel Cannot be Retrieved\n";
        }
    }

    public void verifyLenderUserName(String strLenderUserName){
         //wait until page loads
        WaitUtil.simpleSleep(3000);
        ReasonsInResultSheet.assertStatementIfElementIsPresent(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strLenderUserName+"')]"),getDriverProvider().get(),strLenderUserName);
    }

    public void clickVerifiedLenderUser(int RowIndex){
        try{
            executeScript("scrollTo(250,0)");
            String strClickLenderUser = ReadData.readDataExcel("PeopleDetails", RowIndex, "LenderUserName");
            findElement(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strClickLenderUser+"')]")).click();
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div/h1[contains(text(),'"+strClickLenderUser+"')]"),getDriverProvider().get()));
        } catch (AssertionError e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+ "Lender User Name Cannot Be Clicked\n";
        }
        catch (Exception e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Excel Cannot be Retrieved\n";
        }

    }

    public void verifyServiceProviderUserName(String strServiceProviderUserName){
        //wait until page loads
        WaitUtil.simpleSleep(3000);
        ReasonsInResultSheet.assertStatementIfElementIsPresent(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strServiceProviderUserName+"')]"),getDriverProvider().get(),strServiceProviderUserName);
    }

    public void clickVerifiedServiceProvider(int RowIndex){
        try{
            String strClickServiceProviderUser = ReadData.readDataExcel("PeopleDetails", RowIndex, "PropertyServiceProviderUserName");
            findElement(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strClickServiceProviderUser+"')]")).click();
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div/h1[contains(text(),'"+strClickServiceProviderUser+"')]"),getDriverProvider().get()));
        } catch (Exception e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Excel Cannot be Retrieved\n";
        } catch (AssertionError e) {
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Not Able to Click on Service Provider Name\n";
        }

    }

    public void enterUserTitle(int RowIndex) throws Exception {
        executeScript("scrollTo(250,0)");
        String strUserTitle = ReadData.readDataExcel("PeopleDetails", RowIndex, "UserTitle");
        gStrFieldName = findElement(By.xpath("//div/input-filter/div/label[text()='Name']")).getText();
        ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.xpath("//div/label[text()='Name']/parent::div/div/input[@type='text']"), strUserTitle, gStrFieldName, LoginRealConnexPage.gStrReason);
        WaitUtil.simpleSleep(5000);
    }

    public void enterUserJobTitle(int RowIndex){
        try {
             String strUserJobTitle = ReadData.readDataExcel("PeopleDetails", RowIndex, "UserJobTitle");
             gStrFieldName = findElement(By.xpath("//div/input-filter/div/label[text()='Title']")).getText();
             findElement(By.xpath("//div/label[text()='Title']/parent::div/div/input[@type='text']")).click();
              //wait until page load
             WaitUtil.simpleSleep(10000);
             ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.xpath("//div/label[text()='Title']/parent::div/div/input[@type='text']"), strUserJobTitle, gStrFieldName, LoginRealConnexPage.gStrReason);
            //wait until page load
            WaitUtil.simpleSleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void enterLocation(int RowIndex) {
        try {
            String strLocation = ReadData.readDataExcel("PeopleDetails", RowIndex, "Location");
            gStrFieldName = findElement(By.xpath("//div[@id='searchFilters']/div[2]/div[3]/label")).getText();
            findElement(By.id("LocationInputSearch")).click();
            //wait until page load
            WaitUtil.simpleSleep(10000);
            ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.id("LocationInputSearch"), strLocation, gStrFieldName, LoginRealConnexPage.gStrReason);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clickLocation(int RowIndex){
        try{
            //wait until location is found
            WaitUtil.simpleSleep(500);
            gStrFieldName = findElement(By.xpath("//div[@id='searchFilters']/div[2]/div[3]/label")).getText();
            String strLocation = ReadData.readDataExcel("PeopleDetails", RowIndex, "FullLocationName");
            findElement(By.xpath("//a[contains(text(),'"+strLocation+"')]")).click();
        } catch (NoSuchElementException e){
            System.out.println(e);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Affected Field:"+gStrFieldName+"\nReason of Error:"+"Element is not present\n";
        } catch (Exception e) {
            System.out.println(e);
        }
        //wait until location is found
        WaitUtil.simpleSleep(10000);
    }

    public void enterCompanyName(int RowIndex) {
        try {
            String strCompanyName = ReadData.readDataExcel("PeopleDetails", RowIndex, "UserCompanyName");
            gStrFieldName = findElement(By.xpath("//div/input-filter/div/label[text()='Company']")).getText();
            findElement(By.xpath("//div/label[text()='Company']/parent::div/div/input[@type='text']")).click();
            //wait until page load
            WaitUtil.simpleSleep(10000);
            ReasonsInResultSheet.enterDataToTextField(getDriverProvider().get(), By.xpath("//div/label[text()='Company']/parent::div/div/input[@type='text']"), strCompanyName, gStrFieldName, LoginRealConnexPage.gStrReason);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clearTitle(){
        //wait until title field appear
        WaitUtil.simpleSleep(500);
        findElement(By.xpath("//div/label[text()='Name']/parent::div/div/input[@type='text']")).clear();
        findElement(By.xpath("//div/label[text()='Name']/parent::div/div/input[@type='text']")).click();
        //wait until page load
        WaitUtil.simpleSleep(1000);
    }

    public void clearJobTitle(){
        //wait until job title field appear
        WaitUtil.simpleSleep(500);
        findElement(By.xpath("//div/label[text()='Title']/parent::div/div/input[@type='text']")).click();
        findElement(By.xpath("//div/label[text()='Title']/parent::div/div/input[@type='text']")).clear();
        //wait until page load
        WaitUtil.simpleSleep(1000);
    }

    public void clearLocation(){
         //wait until location field appear
        WaitUtil.simpleSleep(500);
        findElement(By.id("LocationInputSearch")).clear();
        findElement(By.id("LocationInputSearch")).click();
        //wait until page load
        WaitUtil.simpleSleep(10000);
    }

    public void clearCompanyField(){
        //wait until company title field appear
        WaitUtil.simpleSleep(500);
        findElement(By.xpath("//div/label[text()='Company']/parent::div/div/input[@type='text']")).clear();
        findElement(By.xpath("//div/label[text()='Company']/parent::div/div/input[@type='text']")).click();
        //wait until page load
        WaitUtil.simpleSleep(1000);
    }

    public void clickGeographicalCoverage(){
        //wait until page load
        WaitUtil.simpleSleep(2000);
        executeScript("scroll(150,0)");
        findElement(By.xpath("//a[text()='Geographic Coverage']")).click();
        WaitUtil.simpleSleep(1000);
    }

    public void clickOnCountries(){
        //wait until page load
        WaitUtil.simpleSleep(10000);
        findElement(By.xpath("//div/strong[text()='Countries:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
        WaitUtil.simpleSleep(1000);
    }

    public void selectUnitedStatesCheckBox(){
        //wait until page load
        WaitUtil.simpleSleep(1000);
        findElement(By.xpath("//div/strong[text()='Countries:']/parent::div/div/multi-selectbox/div/div/div/div/div/div/label[contains(text(),'United States')]")).click();
        findElement(By.xpath("//div/strong[text()='Countries:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void clickRegionField(){
        //wait until page load
        WaitUtil.simpleSleep(1000);
        findElement(By.xpath("//div/strong[text()='Regions:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }


    public void clickSouthWest(){
        //wait until page load
        WaitUtil.simpleSleep(1000);
        findElement(By.xpath("//div/strong[text()='Regions:']/parent::div/div/multi-selectbox/div/div/div/div/div/div/label[text()='Southwest ']")).click();
        findElement(By.xpath("//div/strong[text()='Regions:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void clickStatesField(){
        //wait until page load
        WaitUtil.simpleSleep(1000);
        findElement(By.xpath("//div/strong[text()='Select States:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void clickTexasState(){
        //wait until page load
        WaitUtil.simpleSleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)getDriverProvider().get();
        jse.executeScript("window.scrollBy(0,500)", "");
        findElement(By.xpath("//div/strong[text()='Select States:']/parent::div/div/multi-selectbox/div/div/div/div/div/div/label[text()='Texas ']")).click();
        findElement(By.xpath("//div/strong[text()='Select States:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void clickCitiesField(){
        //wait until page load
        WaitUtil.simpleSleep(1000);
        findElement(By.xpath("//div/strong[text()='Cities:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void enterAndSelectMassaCity(){
        //wait until page load
        WaitUtil.simpleSleep(1000);
        executeScript("scroll(150,0)");
        findElement(By.xpath("//div/strong[text()='Cities:']/parent::div/div/multi-selectbox/div/div/div/input[@type='text']")).sendKeys("Massa");
        executeScript("window.scrollBy(-350,0)", "");
        findElement(By.xpath("//multi-selectbox/div/div[@class='well msb-dropdown fixed-height']/div/div/div/div/label[contains(text(),'Massa (Texas)')]")).click();
        WaitUtil.simpleSleep(10000);
        findElement(By.xpath("//div/strong[text()='Cities:']/parent::div/div/multi-selectbox/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
        WaitUtil.simpleSleep(10000);
    }

    public void clickUserNameAndVerifyUserInSearch(String strUserName){
        try{
            //wait until page loads
            WaitUtil.simpleSleep(3000);
            findElement(By.xpath("//a/strong[contains(text(),'"+strUserName+"')]")).click();
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//h2[text()='"+strUserName+"']"),getDriverProvider().get()));
           // Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div/h2[contains(text(),'"+strUserName+"')]"),getDriverProvider().get()));
        } catch (NoSuchElementException N) {
            System.out.println(N);
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"Unable to click '"+strUserName+"' user name\n";
        }  catch (AssertionError A){
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +";"+"'"+strUserName+"' profile is not displayed\n";
        }
    }


    public void verifyUserNameDisplayed(String strVerifyUserName){
        ReasonsInResultSheet.assertStatementIfElementIsPresent(By.xpath("//a/strong[contains(text(),'"+strVerifyUserName+"')]"),getDriverProvider().get(),strVerifyUserName);
    }
}
