package com.hectorware.pages;

import com.hectorware.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user")
    public WebElement username;

    @FindBy(id = "password")
    public  WebElement password;

    @FindBy(id = "submit-form")
    public WebElement submitBtn;

    public void login(String userNameValue, String passwordValue){


        username.sendKeys(userNameValue);
        password.sendKeys(passwordValue);
        submitBtn.click();
    }

}
