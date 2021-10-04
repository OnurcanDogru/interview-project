package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonDashboardPage {
    AmazonSignInPage signInPage = new AmazonSignInPage();

    public AmazonDashboardPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }


    @FindBy(xpath = "//a[@data-nav-role = 'signin']")
    public WebElement helloSignInButton;


    @FindBy(xpath = "(//span[. = 'Sign in'])[1]")
    public WebElement signInButton;

    public void logIn(String email, String password){

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(helloSignInButton).perform();
        signInButton.click();
        signInPage.emailInputBox.sendKeys(email);
        signInPage.continueButton.click();
        signInPage.passwordInputBox.sendKeys(password);
        signInPage.signInSubmitButton.click();

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

}
