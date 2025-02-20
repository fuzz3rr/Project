package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
    private final WebDriver driver;

    @FindBy(id = "addresses-link")
    WebElement addressesButton;

    @FindBy (xpath = "//img[contains(@alt, 'mystore-testlab.coderslab.pl')]")
    WebElement returnToMainPageButton;


    public MyAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickIntoAddresses(){
        addressesButton.click();
    }

    public void clickReturnToMainPage(){
        returnToMainPageButton.click();
    }
}
