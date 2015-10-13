package test.pages;

import com.google.common.base.Function;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class WaitUtil {
    public static final String SLEEP_DURATION_PROPERTY = "acceptance.sleep";
    public static final String SLEEP_DURATION_DEFAULT = "5000";

    private WaitUtil() {
    }

    public static void simpleSleep() {
        final String sleepString = System.getProperty(SLEEP_DURATION_PROPERTY, SLEEP_DURATION_DEFAULT);
        simpleSleep(Integer.parseInt(sleepString));
    }

    public static void simpleSleep(int theMilliSeconds) {
        long startTime = accurateSystemTimeInMillis();
        while (accurateSystemTimeInMillis() - startTime < theMilliSeconds) {
            try {
                Thread.sleep(theMilliSeconds - (accurateSystemTimeInMillis() - startTime));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Waited for " + (accurateSystemTimeInMillis() - startTime) + "ms");
    }

    /**
     * Wait for the provided css selector to return no elements.
     *
     * @param theDriver the web driver
     * @param theCssSelector the css selector
     */
    public static void waitForElementDisappearance(final WebDriver theDriver, final String theCssSelector) {
        waitForElementDisappearance(theDriver, theCssSelector, true);
    }

    /**
     * Wait for the provided css selector to return no elements, or for all the selected elements to be invisible.
     * The actual wait behavior is determined by the flag.
     *
     * @param theDriver the web driver
     * @param theCssSelector the css selector
     * @param theActualDisappearanceFlag if true, wait for elements to disappear, if false, wait for elements to become invisible
     */
    public static void waitForElementDisappearance(final WebDriver theDriver, final String theCssSelector, final boolean theActualDisappearanceFlag) {
        long start = accurateSystemTimeInMillis();
        new WebDriverWait(theDriver, 15).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver input) {
                List<WebElement> elements = input.findElements(By.cssSelector(theCssSelector));
                if (theActualDisappearanceFlag) {
                    return elements.size() == 0;
                } else {
                    for (WebElement element : elements) {
                        if (element.isDisplayed()) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        });
        System.out.println("Waited for " + (accurateSystemTimeInMillis() - start) + "ms for disappearance of : " + theCssSelector);
    }

    public static void waitForElementAppearance(WebDriver theDriver, final String theCssSelector) {
        waitForElementAppearance(theDriver, theCssSelector, true);
    }

    public static void waitForElementAppearance(WebDriver theDriver, final String theCssSelector, final boolean theVisibleFlag) {
        long start = accurateSystemTimeInMillis();
        new WebDriverWait(theDriver, 120).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver input) {
                int intCnt=0;
                boolean blnFound=false;
                while(!blnFound && intCnt<5){
                    try{
                        List<WebElement> foundElements = input.findElements(By.cssSelector(theCssSelector));
                        if(foundElements.size() > 0) {
                            if (theVisibleFlag) {
                                // If the element has to be visible, check to see if we found one that is
                                for(WebElement webElement : foundElements) {
                                    try {
                                        if(webElement.isDisplayed()) {
                                            return true;
                                        }
                                    } catch (Exception e) {
                                        // Do nothing, if it turns out we can't find it it'll end up throwing an exception
                                        // This is needed because while the DOM is in flux, this might throw exceptions
                                    }
                                }
                            } else {
                                // If visibility is not a requirement, we're good
                                return true;
                            }
                        }

                    }catch(ClassCastException e){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                        intCnt++;

                    }
                }


                return false;
            }
        });
        System.out.println("Waited for " + (accurateSystemTimeInMillis() - start) + "ms for appearance of : " + theCssSelector);
    }

    public static void WaitByXpath (String element,WebDriver driver){
        long start = accurateSystemTimeInMillis();
        try{
            int intCnt=0;
            boolean blnFound=false;
            while(!blnFound && intCnt<60){
                try{
                    blnFound = driver.findElements(By.xpath(element)).size() != 0;
                    blnFound = true;

                }catch(NoSuchElementException e){
                    Thread.sleep(1000);
                    intCnt++;

                }catch(StaleElementReferenceException e){
                    Thread.sleep(1000);
                    intCnt++;
                }
            }

            System.out.println("Waited for " + (accurateSystemTimeInMillis() - start) + "ms for appearance of : " + element);

        }catch(Exception E){
            System.out.println(E.toString());
        }
    }

    public static void waitForElementAppearanceByXPath(WebDriver driver, final String theXpathSelector) {
        long start = accurateSystemTimeInMillis();
        try{
            int intCnt=0;
            boolean blnFound=false;
            while(!blnFound && intCnt<50){
                try{
                    driver.findElements(By.xpath(theXpathSelector));
                    blnFound = true;

                }catch(NoSuchElementException e){
                    Thread.sleep(1000);
                    intCnt++;

                }catch(StaleElementReferenceException e){
                    Thread.sleep(1000);
                    intCnt++;
                }
            }

            System.out.println("Waited for " + (accurateSystemTimeInMillis() - start) + "ms for appearance of : " + theXpathSelector);

        }catch(Exception E){
            System.out.println(E.toString());
        }
    }

    public static String GetTextFromElement(WebDriver driver, final String theXpathSelector) {
        String lStrText = "";
        try{
            int intCnt=0;
            boolean blnFound=false;
            while(!blnFound && intCnt<10){
                try{
                    lStrText = driver.findElement(By.xpath(theXpathSelector)).getText();
                    blnFound = true;

                }catch(StaleElementReferenceException e){
                    Thread.sleep(300);
                    intCnt++;
                }
            }

            intCnt = 0;
            blnFound = false;
            while(!blnFound && intCnt<5){
                try{
                    lStrText = driver.findElement(By.xpath(theXpathSelector)).getText().trim();
                    Assert.assertTrue(!lStrText.equals(""));
                    blnFound = true;

                }catch(ComparisonFailure Ae){
                    Thread.sleep(1000);
                    intCnt++;
                }catch(AssertionError Ae){
                    Thread.sleep(1000);
                    intCnt++;
                }
            }

        }catch(Exception E){
            System.out.println(E.toString());
        }

        return lStrText;
    }

    private static long accurateSystemTimeInMillis() {
        return System.nanoTime() / 1000000;
    }

    public static void waitForElementAppearanceID(WebDriver theDriver, final String theIDSelector) {
        waitForElementAppearance(theDriver, theIDSelector, true);
    }

    public static void waitForElementAppearanceID(WebDriver theDriver, final String theIDSelector, final boolean theVisibleFlag) {
        long start = accurateSystemTimeInMillis();
        new WebDriverWait(theDriver, 120).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver input) {
                List<WebElement> foundElements = input.findElements(By.id(theIDSelector));
                if(foundElements.size() > 0) {
                    if (theVisibleFlag) {
                        // If the element has to be visible, check to see if we found one that is
                        for(WebElement webElement : foundElements) {
                            try {
                                if(webElement.isDisplayed()) {
                                    return true;
                                }
                            } catch (Exception e) {
                                // Do nothing, if it turns out we can't find it it'll end up throwing an exception
                                // This is needed because while the DOM is in flux, this might throw exceptions
                            }
                        }
                    } else {
                        // If visibility is not a requirement, we're good
                        return true;
                    }
                }

                return false;
            }
        });
        System.out.println("Waited for " + (accurateSystemTimeInMillis() - start) + "ms for appearance of : " + theIDSelector);
    }

    public static void waitForElementAppearanceLink(WebDriver theDriver, final String theLinkText) {
        waitForElementAppearanceLink(theDriver, theLinkText, true);
    }

    public static void waitForElementAppearanceLink(WebDriver theDriver, final String theLinkText, final boolean theVisibleFlag) {
        long start = accurateSystemTimeInMillis();
        new WebDriverWait(theDriver,120).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver input) {
                List<WebElement> foundElements = input.findElements(By.linkText(theLinkText));
                if(foundElements.size() > 0) {
                    if (theVisibleFlag) {
                        // If the element has to be visible, check to see if we found one that is
                        for(WebElement webElement : foundElements) {
                            try {
                                if(webElement.isDisplayed()) {
                                    return true;
                                }
                            } catch (Exception e) {
                                // Do nothing, if it turns out we can't find it it'll end up throwing an exception
                                // This is needed because while the DOM is in flux, this might throw exceptions
                            }
                        }
                    } else {
                        // If visibility is not a requirement, we're good
                        return true;
                    }
                }

                return false;
            }
        });
        System.out.println("Waited for " + (accurateSystemTimeInMillis() - start) + "ms for appearance of : " + theLinkText);
    }

    public static boolean isElementPresent(By by,WebDriver driver) {
        if(driver.findElements(by).size() != 0){
            return true;

        }else{
            return false;
        }
    }

    public void waitAndClickElement(WebDriver driver, final By selector) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(40, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement elementToClick = wait
                .until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(selector);
                    }
                });
        waitForElementVisible(driver, selector);
        elementToClick.click();
    }

    public void waitForElementVisible(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));

    }

    public static String CloseAlertAndGetItsText(WebDriver theDriver) throws InterruptedException {
        String alertText = "";
        int intCnt=0;
        boolean blnFound=false;
        while(!blnFound && intCnt<10){
            try{
                Alert alert = theDriver.switchTo().alert();
                alertText = alert.getText();
                alert.accept();
                blnFound=true;

            }catch(NoAlertPresentException e){
                Thread.sleep(1000);
                intCnt++;
            }
        }
        return alertText;
    }

    public static String DismissAlertAndGetItsText(WebDriver theDriver) throws InterruptedException {
        String alertText = "";
        int intCnt=0;
        boolean blnFound=false;
        while(!blnFound && intCnt<10){
            try{
                Alert alert = theDriver.switchTo().alert();
                alertText = alert.getText();
                alert.dismiss();
                blnFound=true;

            }catch(NoAlertPresentException e){
                Thread.sleep(1000);
                intCnt++;
            }
        }
        return alertText;
    }

    public static boolean isElementNotPresent(By by,WebDriver driver) {
        WebDriver driverForNotCond = driver;
        driverForNotCond.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try{
            if(driverForNotCond.findElements(by).size() != 0){
                return false;
            }else{
                return true;
            }
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public static boolean verifyElementNotPresent(By by,WebDriver driver,long lnTime) {
        WebDriver driverForNotCond = driver;
        driverForNotCond.manage().timeouts().implicitlyWait(lnTime, TimeUnit.SECONDS);
        try{
            if(driverForNotCond.findElements(by).size() != 0){
                return false;
            }else{
                return true;
            }
        } catch (NoSuchElementException e) {
            return true;
        }
    }

}
