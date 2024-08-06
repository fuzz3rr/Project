package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.course.selenium.helpers.Helpers.waitForElementVisible;
import static com.course.selenium.helpers.Helpers.waitForElementToBeClickable;
import java.util.Objects;

public class ProductPage {
    private final WebDriver driver;

    @FindBy (css = ".discount.discount-percentage")
    WebElement discount;

    @FindBy (id = "group_1")
    WebElement sizeButton;

    @FindBy (id = "quantity_wanted")
    WebElement quantityField;

    @FindBy (css = ".btn.btn-primary.add-to-cart")
    WebElement addToCartButton;

    @FindBy (xpath = "//a[text()='Proceed to checkout']")
    WebElement checkoutFloatingButton;


    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkDiscount(String disc){
        return Objects.equals(discount.getText(), disc);
    }

    public void chooseSize(String size) {
        sizeButton.click();
        String expression = String.format("//option[text()='%s']", size);
        WebElement category = driver.findElement(By.xpath(expression));
        category.click();
        waitForElementToBeClickable(driver, addToCartButton); //czeka az guzik bedzie odszarzony bo inacze parametryzacja produktu nie dziala
    }

    public void chooseQuantity(String quantity) {
        quantityField.click();
        quantityField.sendKeys(Keys.HOME);
        quantityField.sendKeys(Keys.DELETE); //clear nie dziala bo nie czysci pola
        quantityField.sendKeys(quantity);
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public void proceedToCheckout(){
        waitForElementVisible(driver, checkoutFloatingButton); //czeka az pojawi sie okno z checkoutem
        checkoutFloatingButton.click();
    }
}
