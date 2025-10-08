package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {
    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();
        driver.get("https://practice-automation.com/form-fields/");

        WebElement element = driver.findElement(By.id("drink1"));

        element.click();

        System.out.println(element.getAttribute("value"));

        System.out.println("task completed");

    }
}