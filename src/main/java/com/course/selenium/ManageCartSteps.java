package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;



public class ManageCartSteps {
    private final WebDriver driver = BrowserFactory.getDriver();

    ProductPage productPage;
    Order order;

    @Given("the user is on the auth page")
    public void theUserIsOnTheAuthPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @When("the user types {string} and {string} and clicks sign in")
    public void theUserTypesAndAndClicksSignIn(String email, String password) {
        AuthPage authPage = new AuthPage(driver);
        authPage.typeEmailIntoForm(email);
        authPage.typePasswordIntoForm(password);
        authPage.clickSignIn();
    }

    @And("the user returns to main page")
    public void theUserReturnsToMainPageA() {
        MyAccount myAccount = new MyAccount(driver);
        myAccount.clickReturnToMainPage();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickProduct();

    }

    @And("and clicks product and checks if it has discount of {string} the user chooses the size {string} of product")
    public void andClicksProductAndChecksIfItHasDiscountOfTheUserChoosesTheSizeOfProduct(String discount, String size) {
        ProductPage productPage = new ProductPage(driver);
        if(productPage.checkDiscount(discount)){
            productPage.chooseSize(size);
        }
    }

    @And("the uses chooses the amount {string} of product")
    public void theUsesChoosesTheAmountOfProduct(String amount) {
        productPage = new ProductPage(driver);
        productPage.chooseQuantity(amount);
    }

    @And("the user adds the products to a cart")
    public void theUserAddsTheProductsToACart() throws InterruptedException{
        productPage = new ProductPage(driver);
        productPage.addToCart();
    }

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        productPage = new ProductPage(driver);
        productPage.proceedToCheckout();

        Cart cart = new Cart(driver);
        cart.clickCheckoutButton();
    }

    @And("the user confirms the {string} and clicks continue")
    public void theUserConfirmsTheAndClicksContinue(String address) {
        Order order = new Order(driver);
        order.selectAddress(address);
        order.clickContinueToShipping();
    }

    @And("the user chooses pickup method")
    public void theUserChoosesPickupMethod() {
        order = new Order(driver);
        order.clickSelfPickUp();
        order.clickContinueToPayment();
    }

    @And("the user chooses Pay by check")
    public void theUserChoosesPayByCheck() {
        order = new Order(driver);
        order.clickPayByCheck();
        order.clickTermsOfService();
    }

    @Then("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        order = new Order(driver);
        order.clickPlaceOrder();
    }

    @And("the page should show message {string}")
    public void thePageShouldShowMessage(String message) {
        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
        Assert.assertEquals(message, orderConfirmation.orderConfirmedMessageBanner());
    }

    @And("the script will take the screenshot of the order")
    public void theScriptWillTakeTheScreenshotOfTheOrder() {
    }

}
