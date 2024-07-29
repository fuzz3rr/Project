package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {
    private final WebDriver driver;


    @FindBy(id = "field-email")
    WebElement emailInput;

    @FindBy (id = "field-password")
    WebElement password;

    @FindBy(id = "submit-login")
    WebElement signInButton;


    public AuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeEmailIntoForm(String mail){
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(mail);
    }

    public void typePasswordIntoForm(String passwd){
        password.click();
        password.clear();
        password.sendKeys(passwd);
    }

    public void clickSignIn(){
        signInButton.click();
    }

}
