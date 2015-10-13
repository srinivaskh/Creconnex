package test.pages;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Himanth
 * Date: 7/30/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class WindowClose {
    public static void closeAllWindows(WebDriver driver)  {
        String parentWindowHandle =driver.getWindowHandle(); // save the current window handle.

        Set<String> windowIds =driver.getWindowHandles();
        Iterator<String> windowIterator = windowIds.iterator();
        while(windowIterator.hasNext()) {
            String windowHandle = windowIterator.next();
            driver.switchTo().window(windowHandle).close();
        }
    }
}
