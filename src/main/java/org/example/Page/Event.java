package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Event {
    private static final Logger logger = LoggerFactory.getLogger(Event.class);
    WebDriver driver = new FirefoxDriver();
    Actions actions = new Actions(driver);
    WebElement button;
    WebElement text;

    public Event() {
        driver.get("https://practice-automation.com/click-events/");
    }

    public void catButtonClick() {
        buttonClick("cat");
    }

    public void dogButtonClick() {
        buttonClick("dog");
    }

    public void pigButtonClick() {
        buttonClick("pig");
    }
    public void cowButtonClick() {
        buttonClick("cow");
    }

    //Обработка тестирования кнопок
    private void buttonClick(String type) {
        button = driver.findElement(By.xpath("//button[@onClick='" + type + "Sound()']"));
        actions.moveToElement(button).click().pause(Duration.ofSeconds(1)).perform();
        text = driver.findElement(By.id("demo"));
        logger.atInfo().log("Click " + type + " button, output text: " + text.getText());
    }
}
