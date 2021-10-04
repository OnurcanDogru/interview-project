package com.interview.step_definitions;

import com.interview.pages.AmazonDashboardPage;
import com.interview.pages.AmazonSearchPage;
import com.interview.pages.AmazonSignInPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonStepDefinitions {
    AmazonDashboardPage dashboardPage = new AmazonDashboardPage();
    AmazonSignInPage signInPage = new AmazonSignInPage();
    AmazonSearchPage searchPage = new AmazonSearchPage();


    @Given("User is on the {string} page")
    public void user_is_on_the_page(String page) {

        switch (page) {
            case "Dashboard":
                Driver.getDriver().get(ConfigurationReader.getProperty("url"));
                break;
        }

    }
    @When("User hover over {string} button")
    public void user_hover_over_button(String button) {

        switch (button){
            case "Hello, Sign in":
                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(dashboardPage.helloSignInButton).perform();
                break;
        }

    }
    @When("User clicks on {string} button")
    public void user_clicks_on_button(String button) {

        switch (button){
            case "Sign in":
                dashboardPage.signInButton.click();
                break;
            case  "Sign-In":
                signInPage.signInSubmitButton.click();
                break;
            case    "Subscribe & Save":
                searchPage.subscribeAndSaveButton.click();
                break;
            case "Set Up Now":
                searchPage.setUpNowButton.click();
                break;
            case "Proceed to checkout":
                WebDriverWait wait = new WebDriverWait(Driver.getDriver() , 10);
                wait.until(ExpectedConditions.visibilityOf(searchPage.proceedToCheckoutButton));

                searchPage.proceedToCheckoutButton.click();
                break;
            case "Place your order":
                //searchPage.placeYourOrderButton.click();

        }

    }
    @When("User enters {string} in the email input box")
    public void user_enters_in_the_email_input_box(String email) {

        signInPage.emailInputBox.sendKeys(email);
        signInPage.continueButton.click();

    }
    @When("User enters {string} in the password input box")
    public void user_enters_in_the_password_input_box(String password) {

        signInPage.passwordInputBox.sendKeys(password);

    }
    @When("User signs in with correct credentials {string} {string}")
    public void user_signs_in_with_correct_credentials(String email, String password) {

       dashboardPage.logIn(email,password);

    }
    @When("User clicks on the {string} product")
    public void user_clicks_on_the_product(String searchInput) {

        WebElement searchItem = Driver.getDriver().findElement(By.xpath("//span[. = 'Advil Pain Reliever and Fever Reducer, Ibuprofen 200mg for Pain Relief - 300 Count, Advil PM Pain Reliever and Nighttime Sleep Aid, Ibuprofen for Pain Relief and Diphenhydramine Citrate - 2 Count']"));
        searchItem.click();

    }
    @When("User adjusts quantity as {string}")
    public void user_adjusts_quantity_as(String quantity) {

        Select select = new Select(searchPage.quantityDropdown);
        select.selectByValue(quantity);

    }
    @When("User adjusts delivery frequency as {string}")
    public void user_adjusts_delivery_frequency_as_months(String frequency) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver() , 10);
        wait.until(ExpectedConditions.visibilityOf(searchPage.deliveryFrequencyDropdown));

        Select select = new Select(searchPage.deliveryFrequencyDropdown);
        select.selectByVisibleText(frequency);

    }
    @When("User clicks on {string} delivery option")
    public void user_clicks_on_delivery_option(String deliveryOptionInput) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver() , 10);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//legend/following-sibling::div["+deliveryOptionInput+"]/input"))));

        WebElement deliveryOption = Driver.getDriver().findElement(By.xpath("//legend/following-sibling::div["+deliveryOptionInput+"]/input"));
        deliveryOption.click();


    }
    @When("User searches for {string}")
    public void user_searches_for(String searchInput) {

        dashboardPage.searchBar.sendKeys(searchInput + Keys.ENTER);

    }

    @And("User successfully set up delivery for every {string}")
    public void userSuccessfullySetUpDeliveryForEvery(String deliveryFrequency) {

        String expectedFrequency = deliveryFrequency;

        WebElement actualFrequencyWebElement = Driver.getDriver().findElement(By.xpath("//div[@id = 'recurrence-section']/span[contains(text() , '"+deliveryFrequency+"')]"));
        String actualFrequencyString = actualFrequencyWebElement.getText();

        Assert.assertEquals(actualFrequencyString,expectedFrequency);

    }
}
