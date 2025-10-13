package org.example.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Popup {

    WebDriver driver = new FirefoxDriver();
    Actions actions = new Actions(driver);

    public Popup() {
        driver.get("https://practice-automation.com/popups/");

    }



}
