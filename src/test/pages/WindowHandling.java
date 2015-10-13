package test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandling extends FluentWebDriverPage {
    public static final String PAGE_PREFIX = "";
    public static String handle;
    public static String name;
    public static String parentHandle;
    public static int instanceCount = 0;

    public WindowHandling(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public static String getPopupWindowHandle(WebDriver driver, WebElement link) {
        String strPopUp = null;
        try {
            // get all the window handles before the popup window appears
            Set<String> beforePopup = driver.getWindowHandles();

            // click the link which creates the popup window
            WaitUtil.simpleSleep(1000);
            link.click();
            WaitUtil.simpleSleep(3000);
            // get all the window handles after the popup window appears
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
            Set<String> afterPopup = driver.getWindowHandles();

            // remove all the handles from before the popup window appears
            afterPopup.removeAll(beforePopup);

            // there should be only one window handle left
            if (afterPopup.size() == 1) {
                strPopUp = (String) afterPopup.toArray()[0];
            }

        } catch (Exception E) {

        }
        return strPopUp;
    }

    public static boolean switchToWindow(WebDriver driver, String strWindow) {
        int intCnt = 0;
        boolean blnSel = false;
        Set<String> windowList = driver.getWindowHandles();
        try {

            while (blnSel == false && intCnt < 20) {
                try {
                    for (String handle : windowList) {
                        if ((strWindow.equals(handle))) {
                            driver.switchTo().window(handle);
                            blnSel = true;

                        }
                    }


                } catch (Exception E) {
                    WaitUtil.simpleSleep(1000);
                    intCnt++;
                }
            }


        } catch (Exception E) {

        }
        if (blnSel == true) {
            return true;
        } else {
            return false;
        }

    }

    public static void switchToWindowUsingTitle(WebDriver driver, String strWindowTitle) {
        WebDriver popup = null;
        Actions actions = new Actions(driver);
        String strDesiredWin = "";
        Set<String> windowIterator = driver.getWindowHandles();
        String[] wins = windowIterator.toArray(new String[0]);

        for (String a : wins) {
            popup = driver.switchTo().window(a);
            String title = popup.getTitle();
            if (title.contains(strWindowTitle)) {
                strDesiredWin = a.toString();
                break;
            }
        }
        if (!strDesiredWin.equals("")) {
            driver.switchTo().window(strDesiredWin);
        } else {
            wins = null;
            windowIterator = null;
            windowIterator = driver.getWindowHandles();
            wins = windowIterator.toArray(new String[0]);
            for (String a : wins) {
                popup = driver.switchTo().window(a);
                String title = popup.getTitle();
                if (title.contains(strWindowTitle)) {
                    strDesiredWin = a.toString();
                }
            }
        }
    }

    public static void waitForWindow(WebDriver driver, final String title) {

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS) //How long should WebDriver wait for new window
                .pollingEvery(5, TimeUnit.SECONDS)  //How often should it check if a searched window is present
                .ignoring(NoSuchWindowException.class);

        wait.until(ExpectedConditions.titleContains(title));

    }

    public void closeAllWindows() {
        //String strTitle="Leads Open Leads - Microsoft Dynamics CRM";
        String parentWindowHandle = getWindowHandle(); // save the current window handle.
        Set<String> windowIds = getWindowHandles();
        int count = windowIds.size();
        Iterator<String> windowIterator = windowIds.iterator();

        while (windowIterator.hasNext() && count > 1) {
            String windowHandle = windowIterator.next();
            WebDriver popup = switchTo().window(windowHandle);

            popup.close();
            count--;

        }
    }

    public String getWindowHandle() {
        return handle;
    }

    public String getParentHandle() {
        return parentHandle;
    }

    public void close(WebDriver driver) {
        switchToWindow(driver).close();
        handle = "";
        //Switch back to the parent window
        driver.switchTo().window(parentHandle);
    }

    public static String createUniqueName() {
        return "a_Web_Window_" + instanceCount++;
    }

    public static WebDriver switchToWindow(WebDriver driver) {
        checkForClosed();
        return driver.switchTo().window(handle);
    }

    public WebDriver switchToParent(WebDriver driver) {
        checkForClosed();
        return driver.switchTo().window(parentHandle);
    }

    public static String createWindow(String url, WebDriver driver) {
        //Record old handles
        Set<String> oldHandles = driver.getWindowHandles();
        parentHandle = driver.getWindowHandle();

        //Inject an anchor element
        ((JavascriptExecutor) driver).
                executeScript(injectAnchorTag(name, url));

        //Click on the anchor element
        driver.findElement(By.id(name)).click();
        handle = getNewHandle(oldHandles, driver);
        return handle;
    }

    public static String getNewHandle(Set<String> oldHandles, WebDriver driver) {
        Set<String> newHandles = driver.getWindowHandles();
        newHandles.removeAll(oldHandles);
        //Find the new window
        for (String handle : newHandles)
            return handle;

        return null;
    }

    public static void checkForClosed() {
        if (handle == null || handle.equals(""))
            throw new WebDriverException("Web Window closed or not initialized");
    }

    public static String injectAnchorTag(String id, String url) {
        return String.format("var anchorTag = document.createElement('a'); " +
                "anchorTag.appendChild(document.createTextNode('nwh'));" +
                "anchorTag.setAttribute('id', '%s');" +
                "anchorTag.setAttribute('href', '%s');" +
                "anchorTag.setAttribute('target', '_blank');" +
                "anchorTag.setAttribute('style', 'display:block;');" +
                "document.getElementsByTagName('body')[0].appendChild(anchorTag);",
                id, url
        );
    }

    public void openNewWindow(String url) {
        try {
            parentHandle = getWindowHandle();
            name = createUniqueName();
            handle = createWindow(url, getDriverProvider().get());
            //Switch to that window and load the url to wait
            switchToWindow(getDriverProvider().get()).get(url);

        } catch (Exception E) {
            System.out.println(E);
        }
    }
}
