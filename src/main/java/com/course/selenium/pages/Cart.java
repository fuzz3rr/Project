package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    WebElement checkoutButton;

    public Cart (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }
}
