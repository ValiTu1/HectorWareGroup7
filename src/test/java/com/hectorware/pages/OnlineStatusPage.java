package com.hectorware.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class OnlineStatusPage extends BasePage {

    @FindBy (css = "div[class='avatardiv avatardiv-shown']")
    public WebElement OnlineStatus;

    @FindBy(css = "a[class='user-status-menu-item__toggle']")
    public WebElement InAmeetingButton;
    @FindBy(css = "div[class='set-status-modal__online-status']>div")
    public  List<WebElement>statusOptions;

}
