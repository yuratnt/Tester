package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Event {
    WebDriver driver = new FirefoxDriver();
    Actions actions = new Actions(driver);

    WebElement catButton;
    WebElement dogButton;
    WebElement pigButton;
    WebElement cowButton;

    WebElement text;


    public Event() {
        driver.get("https://practice-automation.com/click-events/");
    }

    public void catButtonClick() {
        catButton = driver.findElement(By.xpath("//button[@onClick='catSound()']"));
        actions.moveToElement(catButton).click().pause(Duration.ofSeconds(1)).perform();
        text = driver.findElement(By.id("demo"));
        System.out.println("Click cat button, output text: " + text.getText());
    }

    public void dogButtonClick() {
        dogButton = driver.findElement(By.xpath("//button[@onClick='dogSound()']"));
        actions.moveToElement(dogButton).click().pause(Duration.ofSeconds(1)).perform();
        text = driver.findElement(By.id("demo"));
        System.out.println("Click dog button, output text: " + text.getText());

    }

    public void pigButtonClick() {
        pigButton = driver.findElement(By.xpath("//button[@onClick='pigSound()']"));
        actions.moveToElement(pigButton).click().pause(Duration.ofSeconds(1)).perform();
        text = driver.findElement(By.id("demo"));
        System.out.println("Click pig button, output text: " + text.getText());

    }
    public void cowButtonClick() {
        cowButton = driver.findElement(By.xpath("//button[@onClick='cowSound()']"));
        actions.moveToElement(cowButton).click().pause(Duration.ofSeconds(1)).perform();
        text = driver.findElement(By.id("demo"));
        System.out.println("Click cow button, output text: " + text.getText());
    }
}
