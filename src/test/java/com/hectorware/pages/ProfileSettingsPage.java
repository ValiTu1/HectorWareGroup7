package com.hectorware.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileSettingsPage extends BasePage{

    @FindBy(xpath = "//*[@id='expand']")
    public WebElement dropdown;

    @FindBy(partialLinkText = "Settings")
    public WebElement settings;

    @FindBy(id = "selectavatar")
    public WebElement selectedavatar;

    @FindBy(xpath = "//*[@id=\"picker-filestable\"]/tbody/tr[6]/td[1]/span")
    public WebElement selectedpicture;

    @FindBy(xpath = "//*[@id=\"body-settings\"]/div[6]/div[2]/button")
    public WebElement choosebtn;

    @FindBy(id = "sendcropperbutton")
    public WebElement croppedpic;





}
