package com.ecosystems.qe.butter;

import com.ecosystems.qe.UI.ControlWrapper;
import com.ecosystems.qe.butterpages.LandingPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test(groups = "pageverification")

public class TestLP {

    public static void checkLandingPage(WebDriver browsertest) throws InterruptedException {

        System.out.println("In Landing Page: "+browsertest);
        String focustest = browsertest.getWindowHandle();
        //WebDriverWait wait = new WebDriverWait(browsertest, new TimeSpan(0, 1, 0));
        System.out.println("Handle");
        browsertest.switchTo().window(focustest);
        System.out.println("Switch");
        browsertest.manage().window().maximize();

        System.out.println("Butter Logo");

        /* verify Butter Logo */
        ControlWrapper logo = new ControlWrapper(browsertest, LandingPage.logoclass);
        System.out.println("Logo: " + logo);
        Assert.assertEquals(logo.getAlt(), "Butter");
        System.out.println("ALT");

        /* verify

         System.out.println("Sign up");
            /* verify 'signup' link */
        ControlWrapper lpsignup = new ControlWrapper(browsertest, LandingPage.signuplink);
        System.out.println("Signup");
        Assert.assertTrue(lpsignup.elementvisible());

        /* verify hero script */
        WebElement heroscript = browsertest.findElement(LandingPage.herotext);
        Assert.assertEquals("The smoothest way to see your Memberships & Subscriptions 1 place + 1% cashback",
                heroscript.getText().trim());

        /*ystem.out.println("Sign up");*/


    }
}
