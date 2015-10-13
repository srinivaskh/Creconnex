package test.configuration;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverSteps;
import org.openqa.selenium.WebDriver;
import test.Support.DateTimeFunctions;
import test.Support.OfficeCommonFunctions;
import test.Support.ReadData;
import test.pages.LoginRealConnexPage;
import test.pages.PeopleSearchPage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PerStoryWebDriverConfiguration extends WebDriverSteps {
    public static int intFailureCount = 0;
    public static int intSuccessCount = 0;
    public static Date gdtStartDate;// Date variable
    ReadData ReadData= new ReadData(); //Created object to access ReadData class functions
    //static PerStoryWebDriverConfiguration perStoryWebDriverConfiguration;
    public PerStoryWebDriverConfiguration(WebDriverProvider driverProvider) {
        super(driverProvider);
    }
    WebDriver webDriver;
    OfficeCommonFunctions objOfficeCommonFunctions =new OfficeCommonFunctions();

    /*public static void writeToExcelFunction() throws Exception {
        if(LoginRealConnexPage.gStrReason!=""){
            perStoryWebDriverConfiguration.afterScenario();
        } else {
            perStoryWebDriverConfiguration.afterScenarioSuccess();
        }
    }*/

    @BeforeStory
    public void beforeStory() throws Exception {
        System.out.println("Initializing WebDriver");
        driverProvider.initialize();
        webDriver = driverProvider.get();
        webDriver.manage().deleteAllCookies();
        //Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //Sets the amount of time to wait for an asynchronous script to finish execution before throwing an error.
        webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        //Sets the amount of time to wait for a page load to complete before throwing an error.
        webDriver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);

        System.out.println("Initialized WebDriver: " + webDriver.getClass().getSimpleName());
    }

    @AfterStory
    public void afterStory() throws Exception {
        System.out.println("Shutting down WebDriver");
        try{
            getDriverProvider().get().close();
            webDriver.quit();

        }catch(Exception e){

        }
        System.out.println("Shut down WebDriver");
    }

    @BeforeScenario
    public void beforeScenario() throws Exception {
        System.out.println("Initializing WebDriver");
        try {
            if(driverProvider.get().getWindowHandle().length() == 0){
                driverProvider.initialize();
                webDriver = driverProvider.get();
                driverProvider.get().manage().deleteAllCookies();
            }
        }catch(Exception e){
            driverProvider.initialize();
            driverProvider.get().manage().deleteAllCookies();
        }

        //Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //Sets the amount of time to wait for an asynchronous script to finish execution before throwing an error.
        webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        //Sets the amount of time to wait for a page load to complete before throwing an error.
        webDriver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);

        //Set Start time
        gdtStartDate = new Date();

        System.out.println("Initialized WebDriver: " + webDriver.getClass().getSimpleName());
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE)
    public void afterScenario() throws Exception {
        //Read the User story ID and Scenario ID from the test data excel.
        String lStrTestCaseId = ReadData.readTestDataExcel("RunTimeExecutionIds", 1, "TestCaseId");
        String lStrTestCaseName = ReadData.readTestDataExcel("RunTimeExecutionIds",1,"TestCaseName");

        String lStrRunDate = DateTimeFunctions.getCurrentDate("MM/dd/yyyy hh:mm:ss z");
        String lStrTimeTaken = String.valueOf(DateTimeFunctions.TimeTaken(gdtStartDate));

        //Write the results to the Results excel file
        //String[] lArrData = {lStrTestCaseId,"FAIL",lStrRunDate,lStrTimeTaken};
        String[] lArrData = {lStrTestCaseId,lStrTestCaseName,"FAIL",lStrRunDate,lStrTimeTaken,LoginRealConnexPage.gStrReason};
        objOfficeCommonFunctions.AppendDataToExcel("Result",lArrData);
        LoginRealConnexPage.gStrReason = "";
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
    public void afterScenarioSuccess() throws Exception {
        //Read the User story ID and Scenario ID from the test data excel.
        if(LoginRealConnexPage.gStrReason!=""){

            String lStrTestCaseId = ReadData.readTestDataExcel("RunTimeExecutionIds", 1, "TestCaseId");
            String lStrTestCaseName = ReadData.readTestDataExcel("RunTimeExecutionIds",1,"TestCaseName");

            String lStrRunDate = DateTimeFunctions.getCurrentDate("MM/dd/yyyy hh:mm:ss z");
            String lStrTimeTaken = String.valueOf(DateTimeFunctions.TimeTaken(gdtStartDate));

            //Write the results to the Results excel file
            //String[] lArrData = {lStrTestCaseId,"PASS",lStrRunDate,lStrTimeTaken};
            String[] lArrData = {lStrTestCaseId,lStrTestCaseName,"FAIL",lStrRunDate,lStrTimeTaken,LoginRealConnexPage.gStrReason};
            objOfficeCommonFunctions.AppendDataToExcel("Result",lArrData);
            LoginRealConnexPage.gStrReason = "";
        }else {
            String lStrTestCaseId = ReadData.readTestDataExcel("RunTimeExecutionIds", 1, "TestCaseId");
            String lStrTestCaseName = ReadData.readTestDataExcel("RunTimeExecutionIds",1,"TestCaseName");

            String lStrRunDate = DateTimeFunctions.getCurrentDate("MM/dd/yyyy hh:mm:ss z");
            String lStrTimeTaken = String.valueOf(DateTimeFunctions.TimeTaken(gdtStartDate));

            //Write the results to the Results excel file
            //String[] lArrData = {lStrTestCaseId,"FAIL",lStrRunDate,lStrTimeTaken};
            String[] lArrData = {lStrTestCaseId,lStrTestCaseName,"PASS",lStrRunDate,lStrTimeTaken,LoginRealConnexPage.gStrReason};
            objOfficeCommonFunctions.AppendDataToExcel("Result",lArrData);
            LoginRealConnexPage.gStrReason = "";
        }
        LoginRealConnexPage.gStrReason = "";
    }
}
