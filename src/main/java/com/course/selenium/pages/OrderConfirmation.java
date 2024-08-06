package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}


