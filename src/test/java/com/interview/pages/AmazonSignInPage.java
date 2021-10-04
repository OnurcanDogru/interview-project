package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignInPage {
    public AmazonSignInPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy (id = "ap_email")
    public WebElement emailInputBox;

    @FindBy (id = "continue")
    public WebElement continueButton;

    @FindBy (id = "ap_password")
    public WebElement passwordInputBox;

    @FindBy (id = "signInSubmit")
    public WebElement signInSubmitButton;

}
