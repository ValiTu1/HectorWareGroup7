package com.hectorware.pages;

import com.hectorware.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    public CalendarPage(){
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

    @FindBy (xpath = "(//a[@aria-label='Calendar'])[1]")
    public WebElement calendarButton;

    @FindBy(xpath = "//*[@id=\"app-navigation\"]/header/div[2]/div/a")
    public WebElement hamburgerButton;

    @FindBy(xpath = "//*[@id=\"menu-lmarg\"]/li[1]/button/span[1]")
    public WebElement dayButton;

    @FindBy(xpath = "//*[@id=\"menu-lmarg\"]/li[2]/button/span[2]")
    public WebElement weekButton;

    @FindBy(xpath = "//*[@id=\"menu-lmarg\"]/li[3]/button/span[2]")
    public WebElement monthButton;

}
