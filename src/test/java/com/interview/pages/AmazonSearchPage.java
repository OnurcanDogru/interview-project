package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage {
    public AmazonSearchPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy (xpath = "(//span[contains(text(),'Subscribe & Save')])[3]")
    public WebElement subscribeAndSaveButton;


    @FindBy (xpath = "(//select[@data-action = 'a-dropdown-select'])[2]")
    public WebElement quantityDropdown;


    @FindBy (xpath = "(//select[@data-action = 'a-dropdown-select'])[4]")
    public WebElement deliveryFrequencyDropdown;

    @FindBy (id = "rcx-subscribe-submit-button-announce")
    public WebElement setUpNowButton;

    @FindBy (xpath = "//input[@name = 'proceedToRetailCheckout']")
    public WebElement proceedToCheckoutButton;

    @FindBy(name = "placeYourOrder1")
    public WebElement placeYourOrderButton;


}
