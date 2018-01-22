package com.ecosystems.qe.UI;

import com.ecosystems.qe.framework.EcoConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlWrapper {


    protected static final long TIMEOUT = EcoConfig.timeout();
    private WebDriver browsertest;
    private By locator;
    public ControlWrapper (WebDriver browsertest, By locator){
        super();
        System.out.println("Control Wrapper");
        this.browsertest = browsertest;
        this.locator = locator;
    }

    public WebDriver getBrowsertest() {
        return browsertest;
    }

    public By getLocator() {
        return locator;
    }
    public WebElement element(){
        return browsertest.findElement(locator);
    }
    public WebElement element(int index){
        return browsertest.findElements(locator).get(index);
    }
    public boolean elementexists (long timeout){
        WebDriverWait browserwait = new WebDriverWait(browsertest, timeout);
        try {
                browserwait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (TimeoutException e) {
        }
            return false;
    }
    public boolean elementvisible (long timeout){
        WebDriverWait browserwait = new WebDriverWait(browsertest, timeout);
        try {
            browserwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (TimeoutException e){
            return false;
        }
        return true;
    }
    public boolean elementexists(){
        return elementexists(TIMEOUT);
    }
    public boolean elementvisible(){
        return elementvisible(TIMEOUT);
    }
    public void click(){
        Assert.assertTrue("Unable to find element: "+this.locator.toString(), elementexists());
        Assert.assertTrue("Element is not visible"+this.locator.toString(), elementvisible());
        this.element().click();
    }
    public String getText(){
        Assert.assertTrue("Unable to find element: "+this.locator.toString(), elementexists());
        return this.element().getText();
    }
    public String getAlt(){
        return this.locator.findElement(browsertest).getAttribute("alt");
    }

}
