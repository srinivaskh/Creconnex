package test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


/**
 * Created with IntelliJ IDEA.
 * User: Bhavana
 * Date: 6/23/14
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */

public class LogoutPage extends FluentWebDriverPage {
    String gStrFieldName = "";
    public LogoutPage(WebDriverProvider driverProvider){
        super(driverProvider);
    }

    public void logOutPage(){

        try {
            executeScript("scrollTo(250,0)");
            //wait until search field gets loaded
            WaitUtil.simpleSleep(500);
            findElement(By.xpath("//div[@id='searchFilters']/div[@class='box']/a")).click();
            //findElement(By.xpath("//div[@id='searchFilters']/div[@class='box']/a[@class='edit']")).click();
            //wait until search field gets loaded
            WaitUtil.simpleSleep(500);
            findElement(By.xpath("//header[@id='header']/div[@class='user']/a/img")).click();
            findElement(By.linkText("Logout")).click();
            //close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void clickLogout(){
        int intCnt=0;
        boolean blnFound=false;
        while(!blnFound && intCnt<=5){
            try{
                WaitUtil.simpleSleep(5000);
                //WebElement myLink = findElement(By.xpath("//header[@id='header']/div[@class='user']/a/span/strong"));
                findElement(By.xpath("//header[@id='header']/div[@class='user']/a/span/strong")).click();
                if(!findElement(By.xpath("//a[text()='Logout']")).isDisplayed()) {
                    findElement(By.xpath("//header[@id='header']/div[@class='user']/a/span/strong")).click();
                } else{                                                  https://github.com/srinivaskh/Realconnex.git
                findElement(By.xpath("//a[text()='Logout']")).click();
                WaitUtil.simpleSleep(5000);
                Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//header[@id='header']/a[contains(text(),'Log In')]"), getDriverProvider().get()));
                blnFound=true;
                }
            }catch(NoSuchElementException e){
                WaitUtil.simpleSleep(5000);
                LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Logout link cannot be clicked\n";
                intCnt++;
            } catch(AssertionError A){
                WaitUtil.simpleSleep(5000);
                LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Real Connex page is not displayed\n";
                intCnt++;
            }  catch(StaleElementReferenceException S){
                WaitUtil.simpleSleep(5000);
                LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Real Connex page is not displayed\n";
                intCnt++;
            }
        }

    }

    public void clickEditToFindNow(){
        boolean bnlFound = false;
        int intCount = 0;
        while (!bnlFound && intCount <= 5){
            try{
                executeScript("scroll(150,0)");
                WaitUtil.simpleSleep(10000);
                findElement(By.xpath("//div[@id='searchFilters']/div[@class='box']/a[@class='edit']")).click();
                bnlFound= true;
            }catch(ElementNotVisibleException e){
                WaitUtil.simpleSleep(1000);
                intCount = intCount+1;
            }
        }
    }
}
