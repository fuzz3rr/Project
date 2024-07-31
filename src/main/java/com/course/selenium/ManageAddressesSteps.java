package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ManageAddressesSteps {
    private final WebDriver driver = BrowserFactory.getDriver();

    @Given("the user is on the authentication page")
    public void theUserIsOnTheAuthenticationPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }


    @When("the user types {string} and {string} and clicks sign in button")
    public void theUserTypesAndAndClicksSignInButton(String email, String password) {
        AuthPage authPage = new AuthPage(driver);
        authPage.typeEmailIntoForm(email);
        authPage.typePasswordIntoForm(password);
        authPage.clickSignIn();
    }


    @And("the user clicks addresses button")
    public void theUserClicksAddressesButton() {
        MyAccount myAccount = new MyAccount(driver);
        myAccount.clickIntoAddresses();
    }

    @And("the user clicks Create new address")
    public void theUserClicksCreateNewAddress() {
        Addresses addresses = new Addresses(driver);
        addresses.clickCreateNewAddress();
    }

    @And("the user fills the form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFillsTheFormWith(String alias, String address, String city, String postalCode, String country, String phone) {
        AddressForm addressForm = new AddressForm(driver);
        addressForm.typeAliasIntoForm(alias);
        addressForm.typeAddressIntoForm(address);
        addressForm.typeCityIntoForm(city);
        addressForm.typePostalCodeIntoForm(postalCode);
        addressForm.selectCountryInField(country);
        addressForm.typePhoneIntoField(phone);
    }
    @Then("the user saves")
    public void theUserSaves() {
        AddressForm addressForm = new AddressForm(driver);
        addressForm.clickSaveButton();
    }

    @And("the page should display message {string}")
    public void thePageShouldDisplayMessage(String arg0) {
        Addresses addresses = new Addresses(driver);
        Assert.assertEquals(arg0,
                addresses.addressAddedMessage());
    }
}
