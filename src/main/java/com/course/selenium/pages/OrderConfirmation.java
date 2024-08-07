package com.course.selenium.pages;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static com.course.selenium.helpers.Helpers.waitForElementVisible;

public class OrderConfirmation {

    private final WebDriver driver;

    @FindBy(css = ".h1.card-title")
    WebElement confirmOrderMessage;

    public OrderConfirmation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String orderConfirmedMessageBanner(){
        waitForElementVisible(driver, confirmOrderMessage);
        return confirmOrderMessage.getText().substring(1).toUpperCase();
    }

    public void takeScreenshot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("images/screenshot.png"));
        }catch(IOException e){
            e.getMessage();
        }
    }

    public boolean screenshotExist(String path){
        // Getting the file by creating object of File class
        File f = new File(path);
        // Checking if the specified file exists or not
        return f.exists();
    }
}


