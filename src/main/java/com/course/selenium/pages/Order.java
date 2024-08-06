package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.course.selenium.helpers.Helpers.waitForElementToBeClickable;

public class Order {

    private final WebDriver driver;

    @FindBy (name = "confirm-addresses")
    WebElement continueToShipping;

    @FindBy (id= "delivery_option_8")
    WebElement selfPickUpCheck;

    @FindBy (name = "confirmDeliveryOption")
    WebElement continueToPayment;

    @FindBy (id = "payment-option-1")
    WebElement payByCheckCheck;

    @FindBy (id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsOfService;

    @FindBy (css = ".btn.btn-primary.center-block")
    WebElement placeOrderButton;

    public Order(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectAddress(String alias){
        String expression = String.format("//*[text()='%s']", alias);
        WebElement address = driver.findElement(By.xpath(expression));
        address.click();
    }

    public void clickContinueToShipping(){
        continueToShipping.click();
    }

    public void clickSelfPickUp(){
        if (!selfPickUpCheck.isSelected()){
            selfPickUpCheck.click();
        }
    }

    public void clickContinueToPayment(){
        continueToPayment.click();
    }

    public void clickPayByCheck(){
        if (!payByCheckCheck.isSelected()){
            payByCheckCheck.click();
        }
    }
    public void clickTermsOfService(){
        if (!termsOfService.isSelected()){
            termsOfService.click();
        }

    }

    public void clickPlaceOrder(){
        waitForElementToBeClickable(driver, placeOrderButton);
        placeOrderButton.click();
    }


}
