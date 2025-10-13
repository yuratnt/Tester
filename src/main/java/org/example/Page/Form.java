package org.example.Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


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

    WebElement submit;

    WebElement top;

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
        actions.scrollByAmount(0, 500).perform();

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

    public void message(String option) {
        actions.scrollByAmount(0, 500).perform();

        if (option.isEmpty()) {
            StringBuilder text = new StringBuilder();
            for (int i = 1; i <= 5; i++) {
                message = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/main/div/article/div/form/ul/li[" + i +"]"));
                text.append(message.getText()).append(", ");
            }
            text.delete(text.length() - 2, text.length());
            option = text.toString();
        }
        message = driver.findElement(By.id("message"));
        message.sendKeys(option);
    }

    public void submit() {
        submit = driver.findElement(By.id("submit-btn"));
        submit.click();
    }

    public void alert() {
        driver.switchTo().alert().accept();
        driver.findElement(By.id("to-top")).click();
    }
}
