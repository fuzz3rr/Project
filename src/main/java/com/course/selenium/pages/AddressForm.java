package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressForm {
    private final WebDriver driver;

    @FindBy (css = "#field-alias")
    WebElement aliasField;

    @FindBy (css = "#field-address1")
    WebElement addressOneField;

    @FindBy (css = "#field-city")
    WebElement cityField;

    @FindBy (css = "#field-postcode")
    WebElement postalCode;

    @FindBy (css = "#field-id_country")
    WebElement countryField;

    @FindBy (css = "#field-phone")
    WebElement phoneField;

    @FindBy (xpath = "//footer/button")
    WebElement saveButton;


    public AddressForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void typeAliasIntoForm(String alias){
        aliasField.click();
        aliasField.clear();
        aliasField.sendKeys(alias);
    }

    public void typeAddressIntoForm(String address){
        addressOneField.click();
        addressOneField.clear();
        addressOneField.sendKeys(address);
    }

    public void typeCityIntoForm(String city){
        cityField.click();
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void typePostalCodeIntoForm(String code){
        postalCode.click();
        postalCode.clear();
        postalCode.sendKeys(code);
    }

    public void selectCountryInField(String country) {
        countryField.click();
        String expression = String.format("//option[text()='%s']", country);
        WebElement category = driver.findElement(By.xpath(expression));
        category.click();
    }

    public void typePhoneIntoField (String phone){
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

}