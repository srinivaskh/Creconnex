package test.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import test.Support.OfficeCommonFunctions;
import test.pages.ResultHandlingPage;
import java.io.File;
import test.pages.PageFactory;
import com.google.inject.Inject;


/**
 * Created with IntelliJ IDEA.
 * User: Moulya
 * Date: 3/27/14
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.*/


public class ResultHandlingSteps {
    private final ResultHandlingPage ResultHandlingPage;

    @Inject
    public ResultHandlingSteps(PageFactory thePageFactory) {
        ResultHandlingPage = thePageFactory.newResultHandlingPage();
    }

   @When("I update TestCaseId $theTestCaseId")
    public void updateTestCaseId(@Named("theTestCaseId") String strTestCaseId){
        String file1 = this.getClass().getResource("").getPath();
        //String file = this.getClass().getResource(System.getProperty("User.file", "/src/test/Resources/TestData.xls")).getPath();
        String file = "D:/RealConnex/out/production/RealConnex/test/Resources/TestData.xls";
        File newFile = new File(file);
        System.out.println("TestData File: " + newFile);
        OfficeCommonFunctions.UpdateDataToExcel("RunTimeExecutionIds", newFile.getAbsolutePath(),1,"TestCaseId",strTestCaseId);
    }

    @When("I update TestCaseName $theTestCaseName")
    public void updateTestCaseName(@Named("theTestCaseName") String strTestCaseName){
        String file1 = this.getClass().getResource("").getPath();
        //String file = this.getClass().getResource(System.getProperty("User.file", "/src/test/Resources/TestData.xls")).getPath();
        String file = "D:/RealConnex/out/production/RealConnex/test/Resources/TestData.xls";
        File newFile = new File(file);
        System.out.println("TestData File: " + newFile);
        OfficeCommonFunctions.UpdateDataToExcel("RunTimeExecutionIds", newFile.getAbsolutePath(),1,"TestCaseName",strTestCaseName);
    }

}
