package com.ecosystems.qe.butter;

import com.ecosystems.qe.framework.BrowserDriver;
import com.ecosystems.qe.framework.EcoConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class ButterTest {

    WebDriver browsertest;

    @BeforeSuite

    public void testSetup() throws Exception {
        System.out.println("testSetup");
        Capabilities cap = new DesiredCapabilities();
        BrowserDriver.add(EcoConfig.get("browser"), cap);
        browsertest = BrowserDriver.currentdriver();
        browsertest.get(EcoConfig.get("url"));
    }

    @AfterSuite
    public void testEnd(){
        System.out.println("testEnd");
        browsertest.close();
        browsertest.quit();
    }

    @BeforeTest
    public void testStart(){
        System.out.println("testStart");
    }

    @AfterTest
    public void testFinish(){
        System.out.println("testFinish");
    }

    @Test
    public void calllandingPage() throws InterruptedException {

        System.out.println("call LP");
        TestLP.checkLandingPage(browsertest);
    }
    /*@BeforeMethod
    public void setUp() throws Exception {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("afterMethod");
    }*/

    //@Test

}
