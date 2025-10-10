package org.example.algorithm;

import org.example.gui.ConsoleInterface;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorithm {
    private final WebDriver driver;

    public Algorithm() {
        this.driver = new FirefoxDriver();
    }

    private void connection(String url) {
        if (url == null) return;
        driver.get(url);
    }

    private WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public String form(int count, String[] form) {
        connection("https://practice-automation.com/form-fields/");
        Actions actions = new Actions(driver);
        Select select = new Select(findElement(By.id("automation")));

        String[] drinks = new String[] {form[2]};
        if (!form[2].isEmpty()) {
            if (form[2].contains(",")) drinks = form[2].split(",");
        }





        for (int i = 0; i < count; i++) {
            findElement(By.id("name-input")).sendKeys(form[0]);
            findElement(By.xpath("//input[@type='password']")).sendKeys(form[1]);

            if (!form[2].isEmpty()) for (String drink : drinks) actions.moveToElement(findElement(By.id("drink" + drink))).click().perform();

            actions.scrollByAmount(0, 500).perform();

            if (!form[3].isEmpty()) findElement(By.id("color" + form[3])).click();

            switch (form[4]) {
                case "1":
                    select.selectByValue("yes");
                    break;
                case "2":
                    select.selectByValue("no");
                    break;
                case "3":
                    select.selectByValue("undecided");
                    break;
                default: select.selectByValue("default");
            }

            actions.scrollByAmount(0, 500).perform();

            findElement(By.id("email")).sendKeys(form[5]);
            findElement(By.id("message")).sendKeys(form[6]);
            findElement(By.id("submit-btn")).click();

            Alert alert = driver.switchTo().alert();
            alert.accept();

            System.out.println("Проверка " + (i+1) + " прошла успешно");
        }

        driver.close();

        return "Проверка завершена. Проведено " + count + " запусков";
    }

    public String event() {
        connection("https://practice-automation.com/click-events/");

        return "task complete";
    }

    public String window() {
        connection("https://practice-automation.com/popups/");


        return "task complete";
    }

}
