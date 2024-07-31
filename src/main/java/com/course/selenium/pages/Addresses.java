package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.course.selenium.helpers.Helpers.waitForElementVisible;

public class Addresses {
    private final WebDriver driver;

    @FindBy (xpath = "//div[@class=\"addresses-footer\"]/a")
    WebElement createNewAddressButton;

    @FindBy (css = ".alert.alert-success")
    WebElement addAddressAlert;

    public Addresses(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewAddress(){
        createNewAddressButton.click();
    }

    public String addressAddedMessage(){
        waitForElementVisible(driver, addAddressAlert);
        return addAddressAlert.getText();
    }
}
