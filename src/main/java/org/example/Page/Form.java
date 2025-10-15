package org.example.Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.TestException;


public class Form {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    int scroll = 500;
    WebDriver driver = new FirefoxDriver();
    Actions actions = new Actions(driver);
    boolean submit = false;

    public Form() {
        driver.get("https://practice-automation.com/form-fields/");
    }

    public void username(String username) {
        if (username.isEmpty()) throw new TestException("Username is empty");
        driver.findElement(By.id("name-input")).sendKeys(username);
        logger.atInfo().log("Username: " + username);
    }

    public void password(String pass) {
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
        logger.atInfo().log("Password: " + pass);
    }

    public void checkbox(String option) {
        if (option.isEmpty()) throw new SkipException("Drink option is empty");

        if (!option.contains(",")) {
            driver.findElement(By.id("drink" + option)).click();
            logger.atInfo().log("Drink: " + option + " clicked");
            return;
        }
        String[] options = option.split(",");
        for (String o : options) {
            driver.findElement(By.id("drink" + o)).click();
            logger.atInfo().log("Drink " + o + " clicked");
        }
    }

    public void radio(String option) {
        actions.scrollByAmount(0, scroll).perform();

        if (option.isEmpty()) throw new SkipException("Color option is empty");
        driver.findElement(By.id("color" + option)).click();
        logger.atInfo().log("Color: " + option + " clicked");
    }

    public void select(String option) {
        if (option.isEmpty()) throw new SkipException("Select option is empty");
        new Select(driver.findElement(By.id("automation"))).selectByValue(option);
        logger.atInfo().log("Selected: " + option);
    }

    public void email(String text) {
        driver.findElement(By.id("email")).sendKeys(text);
        logger.atInfo().log("Email: " + text);
    }

    public void message(String option) {
        actions.scrollByAmount(0, scroll + 500).perform();
        if (option.isEmpty()) {
            StringBuilder text = new StringBuilder();
            for (int i = 1; i <= 5; i++) {
                text.append(
                        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/main/div/article/div/form/ul/li[" + i +"]")).getText())
                        .append(", ");
            }
            text.delete(text.length() - 2, text.length());
            option = text.toString();
        }
        driver.findElement(By.id("message")).sendKeys(option);
        logger.atInfo().log("message: " + option);
    }

    public void submit(boolean option) {
        submit = option;
        if (submit) {
            driver.findElement(By.id("submit-btn")).click();
            logger.atInfo().log("Submit clicked");
        }
        else throw new SkipException("Submit option is false");
    }

    public void alert() {
        if (submit) {
            driver.switchTo().alert().accept();
            logger.atInfo().log("Alert clicked");
        }
        else {
            throw new SkipException("Submit option is empty");
        }
        driver.findElement(By.id("to-top")).click();
    }
}