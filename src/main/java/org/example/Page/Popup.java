package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Popup {

    WebDriver driver = new FirefoxDriver();
    Actions actions = new Actions(driver);

    WebElement alert;
    WebElement button2;
    WebElement button3;
    public Popup() {
        driver.get("https://practice-automation.com/popups/");
    }

    public void alert() {
        alert = driver.findElement(By.id("alert"));
        alert.click();
        driver.switchTo().alert().accept();
    }

    public void button2() {

    }

    public void button3() {

    }


}
