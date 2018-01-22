package com.ecosystems.qe.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextEntry extends ControlWrapper {

    public TextEntry(WebDriver browsertest, By locator){
        super(browsertest, locator);
    }

    public void editText(String text){
        this.click();
        this.element().clear();
        this.element().sendKeys();
    }
}
