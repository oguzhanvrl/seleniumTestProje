package common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

    private static final int TIMEOUT_WAIT_SECONDS = 10;

    public static void waitUntilTextToBePresentInElementValue(WebDriver driver,WebElement element,
                                                              String value) {
        try {
            boolean myElementt = (new WebDriverWait(driver,TIMEOUT_WAIT_SECONDS))
                    .until(ExpectedConditions.textToBePresentInElement(element,value));
        } catch (TimeoutException e) {
            //TODO : log
            throw e;
        }
    }

    public static void waitUntilElementVisible(WebDriver driver, WebElement element){
        try {
            WebElement myDynamicElement = (new WebDriverWait(driver, TIMEOUT_WAIT_SECONDS))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch(TimeoutException e) {
            // TODO : log
            throw e;
        }
    }

    public static void waitUntilElementClickable(WebDriver driver, WebElement element){
        try {
            WebElement myDynamicTextElement = (new WebDriverWait(driver, TIMEOUT_WAIT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch(TimeoutException e) {
            // TODO : log
            throw e;
        }
    }

    public static void waitUntilElementInvisible(WebDriver driver, WebElement element){
        try {
            Boolean myDynamicElement = (new WebDriverWait(driver, TIMEOUT_WAIT_SECONDS))
                    .until(ExpectedConditions.invisibilityOf(element));
        } catch(TimeoutException e) {
            // TODO : log
            throw e;
        }
    }
}
