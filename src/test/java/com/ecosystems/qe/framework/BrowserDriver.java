package com.ecosystems.qe.framework;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BrowserDriver {

    private BrowserDriver(){

    }

    private static WebDriver browserdriver;

    private static final HashMap<String, Class<?>> driverMap = new HashMap<String, Class<?>>() {
        {
            put("chrome", ChromeDriver.class);
            put("firefox", FirefoxDriver.class);
            put("ie", InternetExplorerDriver.class);
            put("safari", SafariDriver.class);
            put("opera", OperaDriver.class);
            put("edge", EdgeDriver.class);
        }

    };
    public static void add(String browser, Capabilities capability) throws Exception{

        Class<?> driverClass = driverMap.get(browser);
        System.out.println("BrowserDriver - add2: "+browser);
        System.out.println("BrowserDriver - add3: "+driverClass);
        System.out.println("BrowserDriver - add3.5: "+capability);
        browserdriver = (WebDriver) driverClass.getConstructor(Capabilities.class).newInstance(capability);
        System.out.println("BrowserDriver - add4: "+browserdriver);
    }
    public static WebDriver currentdriver(){
        System.out.println("Current Driver");
        return browserdriver;
    }
}
