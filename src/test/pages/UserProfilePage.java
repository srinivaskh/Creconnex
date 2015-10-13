package test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class UserProfilePage extends FluentWebDriverPage {
    public UserProfilePage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void searchImg(){

        //manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
            WaitUtil.simpleSleep(9000);
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//nav[@id='nav']/div"), getDriverProvider().get()));
            //Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//nav[@id='nav']/a/em/img"), getDriverProvider().get()));
        } catch (AssertionError e){
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Search image is not found\n";
        }
        //findElement(By.xpath("//nav[@id='nav']/a/em/img")).isDisplayed();
    }

    public void clickSearchImgButton(){
        //wait until page load
        WaitUtil.simpleSleep(9000);
        //executeScript("window.scrollBy(-350,0)", "");
        //executeScript("scrollTo(250,0)");
        try{
            WaitUtil.simpleSleep(100);
            findElement(By.xpath("//nav[@id='nav']/div")).click();
           // findElement(By.xpath("//nav[@id='nav']/a/em/img")).click();
        } catch (NoSuchElementException e){
            LoginRealConnexPage.gStrReason = LoginRealConnexPage.gStrReason +"; "+"Search image button is not clicked\n";
        }
        //wait until page load
        WaitUtil.simpleSleep(15000);
    }
}
