package test.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created with IntelliJ IDEA.
 * User: Himanth
 * Date: 10/25/13
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */
public final class VerificationStatements {
    private VerificationStatements() {
    }

    public static void VerifyClickSelectedStatus(WebDriver driver,By by){
        Assert.assertTrue(driver.findElement(by).isSelected());
    }

    public static void VerifyClickNotSelectedStatus(WebDriver driver,By by){
        Assert.assertFalse(driver.findElement(by).isSelected());
    }

    public static void VerifyInputValue(WebDriver driver,By by, String pStrValue){
        Assert.assertEquals(pStrValue, driver.findElement(by).getAttribute("value"));
    }

    public static void VerifySelectedValue(WebDriver driver,By by, String pStrValue){
        WebElement option = new Select(driver.findElement(by)).getFirstSelectedOption();
        String lStrLabel = option.getText();
        Assert.assertEquals(pStrValue, lStrLabel);
    }
}
