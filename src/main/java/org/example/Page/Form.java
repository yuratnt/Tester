package org.example.Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form {
    WebDriver driver = new FirefoxDriver();
    Actions actions = new Actions(driver);
    WebElement name;
    WebElement password;

    WebElement checkbox;
    WebElement radio;

    Select select;
    WebElement email;
    WebElement message;

    public Form() {
        driver.get("https://practice-automation.com/form-fields/");

        name = driver.findElement(By.id("name-input"));
        password = driver.findElement(By.xpath("//input[@type='password']"));
    }

    public void login(String username, String pass) {
        name.sendKeys(username);
        password.sendKeys(pass);
    }

    public void checkbox(String option) {
        if (option.isEmpty()) return;

        if (!option.contains(",")) {
            checkbox = driver.findElement(By.id("drink" + option));
            checkbox.click();
            return;
        }
        String[] options = option.split(",");
        for (String o : options) {
            checkbox = driver.findElement(By.id("drink" + o));
            checkbox.click();
        }

    }

    public void radio(String option) {
        actions.scrollByAmount(0, 700).perform();

        if (option.isEmpty()) return;
        radio = driver.findElement(By.id("color" + option));
        radio.click();
    }

    public void select(String option) {
        if (option.isEmpty()) return;
        select = new Select(driver.findElement(By.id("automation")));
        select.selectByValue(option);
    }

    public void email(String text) {
        email = driver.findElement(By.id("email"));
        email.sendKeys(text);
    }

    public void message() {
        message = driver.findElement(By.xpath("//"));

    }



    private WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public String form(int count, String[] form) {
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

}
