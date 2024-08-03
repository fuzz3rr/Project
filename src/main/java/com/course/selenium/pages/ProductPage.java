package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class ProductPage {
    private WebDriver driver;

    @FindBy (css = ".discount.discount-percentage")
    WebElement discount;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkDiscount(String disc){
        return Objects.equals(discount.getText(), disc);
    }
}
