package com.ecosystems.qe.butterpages;

import org.openqa.selenium.By;

public class LandingPage {
    public static By heading = By.cssSelector("h2");
    public static By herotext = By.cssSelector("#home-hero");
    public static By logoclass = By.cssSelector(".logo");
    public static By grid = By.cssSelector("css=div.home-grid");
    public static By loginlink = By.cssSelector(".responsive-collapse");
    public static By signuplink = By.cssSelector("a[href^='/signup']");
}
