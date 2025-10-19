package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Popup {
    private static final Logger logger = LoggerFactory.getLogger(Event.class);
    WebDriver driver = new FirefoxDriver();
    WebElement element;
    WebElement text;
    public Popup() {
        driver.get("https://practice-automation.com/popups/");
    }

    //обработка тестирования кнопки alert и модального окна после нажатия
    public void alert() {
        driver.findElement(By.id("alert")).click();
        driver.switchTo().alert().accept();
        logger.atInfo().log("Alert clicked");
    }

    //обработка тестирования кнопки confirm и модального окна после нажатия
    public void confirm() {
        element = driver.findElement(By.id("confirm"));
        element.click();
        logger.atInfo().log("Confirm text: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        text = driver.findElement(By.id("confirmResult"));
        logger.atInfo().log("Confirm accepted. Result: " + text.getText());
        element.click();
        driver.switchTo().alert().dismiss();
        logger.atInfo().log("Confirm dismissed. Result: " + text.getText());
    }

    //обработка тестирования кнопки prompt и модального окна после нажатия
    public void prompt(String text) {
        element = driver.findElement(By.id("prompt"));
        element.click();
        logger.atInfo().log("Prompt text: " + text);
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().dismiss();
        WebElement prompt = driver.findElement(By.id("promptResult"));
        logger.atInfo().log("Prompt dismissed. Result: " + prompt.getText());
        element.click();
        driver.switchTo().alert().accept();
        logger.atInfo().log("Prompt accepted. Result: " + prompt.getText());
    }

    //обработка тестирования кнопки click me to see a tooltip и нажатие на текст появляющийся после
    public void tooltip() {
        element = driver.findElement(By.xpath("//div[@class='tooltip_1']"));
        element.click();
        logger.atInfo().log("Text clicked");
        WebElement text = driver.findElement(By.id("myTooltip"));
        logger.atInfo().log("Tooltip text: " + text.getText());
        text.click();
        logger.atInfo().log("Tooltip clicked");
    }
}
