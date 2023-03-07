package com.learning.pages;

import com.learning.driver.DriverManager;
import com.learning.enums.WaitStrategy;
import com.learning.factories.ExplicitWaitFactory;
import com.learning.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elmName) {
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        elm.click();
        try {
            ExtentLogger.pass(elmName + " button is clicked", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendKeys(By by, String txtToBeEntered, WaitStrategy waitStrategy, String elmName) {
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        elm.sendKeys(txtToBeEntered);
        try {
            ExtentLogger.pass("Value is set on " + elmName + " text box field", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriverThreadLocal().getTitle();
    }

    protected String getInnerText(By by, WaitStrategy waitStrategy) {
        WebElement elm = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return elm.getText();
    }
}
