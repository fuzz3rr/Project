package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Order {

    private WebDriver driver;

    public Order(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectAddress(String alias){
        String expression = String.format("//*[text()='%s']", alias);
        WebElement address = driver.findElement(By.xpath(expression));
        address.click();
    }
}
