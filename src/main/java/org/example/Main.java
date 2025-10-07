package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;g

import java.util.List;


public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://practice-automation.com/form-fields/");

        WebElement element = driver.findElement(By.id("name-input"));
        System.out.println(element);

        System.out.println(element.getAttribute("clientWidth"));
    }
}