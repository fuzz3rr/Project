package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Ignore;
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

    //TODO Ex. 1usuwanie adresu i sprawdzenie czy sie usunal
    @Ignore
    @Then("the user clicks delete button for address with {string}")
    public void theUserClicksDeleteButtonForAddressWith(String arg0) {
    }

    @And("the user returns to main page and clicks product and checks if it has discount of {string}")
    public void theUserReturnsToMainPageAndClicksProductAndChecksIfItHasDiscountOf(String discount) {
        MyAccount myAccount = new MyAccount(driver);
        myAccount.clickReturnToMainPage();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickProduct();

        ProductPage productPage = new ProductPage(driver);
        if (productPage.checkDiscount(discount)){
            System.out.printf("discount: %s%n",discount);

        }
    }

    @And("the user chooses the size {string} of product")
    public void theUserChoosesTheSizeOfProduct(String size) {

    }

    @And("the uses chooses the amount {string} of product")
    public void theUsesChoosesTheAmountOfProduct(String amount) {
    }

    @And("the user adds the products to a cart")
    public void theUserAddsTheProductsToACart() {
    }

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
    }

    @And("the user confirms the {string} and clicks continue")
    public void theUserConfirmsTheAndClicksContinue(String address) {
    }

    @And("the user chooses pickup method")
    public void theUserChoosesPickupMethod() {
    }

    @And("the user chooses Pay by check")
    public void theUserChoosesPayByCheck() {
    }

    @Then("the user confirms the order")
    public void theUserConfirmsTheOrder() {
    }

    @And("the script will take the screenshot of the order")
    public void theScriptWillTakeTheScreenshotOfTheOrder() {
    }
}
