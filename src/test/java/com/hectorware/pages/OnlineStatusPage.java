package com.hectorware.pages;

import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatusPage extends BasePage {

    Actions actions = new Actions(Driver.get());

    @FindBy (css = "div[class='avatardiv avatardiv-shown']")
    public WebElement statusBtn;

    @FindBy(css = "a[class='user-status-menu-item__toggle']")
    public WebElement currentStatus;
    @FindBy(xpath = "//label[contains(@class, 'user-status-online-select__label icon-user-status')]")
    public  List<WebElement>statusOptions;

    @FindBy(css = ".user-status-menu-item>.user-status-menu-item__toggle")
    public WebElement setStatusBtn;

    @FindBy(xpath = "//form[@class='custom-input__form']/input")
    public WebElement statusMessageInputBox;

    @FindBy(xpath = "//button[@class='status-buttons__primary primary']")
    public WebElement statusMsgBtn;

    @FindBy(xpath = "//div/span[@class='predefined-status__message']")
    public List<WebElement> statusMessages;


    public List<String> getStatusOptions(){
        List<String> availableOptions = new ArrayList<>();

        for (WebElement option : statusOptions) {
            if(option.getAttribute("outerText").contains("\n")){
                String[] arr = option.getAttribute("outerText").split("\n");
                availableOptions.add(arr[0]);
            }else {
                availableOptions.add(option.getAttribute("outerText"));
            }
        }
        return availableOptions;
    }

    public void selectStatusByName(String name){
        Driver.get().findElement(By.xpath("//label[contains(.,'"+name+"')]")).click();
        Utils.waitForClickablility(statusMessageInputBox, 4);
        statusMessageInputBox.sendKeys(Keys.CONTROL+ "A" + Keys.DELETE);
        statusMessageInputBox.sendKeys(name);
        clickSetStatusMessage();
    }


    public List<String> getStatusMessages(){
        List<String> messages = new ArrayList<>();
        for (WebElement each : statusMessages) {
            messages.add(each.getText());
        }
        return messages;
    }

    public void selectStatusMessageByName( String message){
        String xpathLocator = "//div[@class='predefined-statuses-list']//span[contains(.,'"+message+"')]";
        WebElement statusMessage = Driver.get().findElement(By.xpath(xpathLocator));
        actions.moveToElement(statusMessage);
        Utils.waitFor(2);
        statusMessage.click();
    }

    public void clickSetStatusMessage(){
        actions.moveToElement(statusMsgBtn).perform();
        statusMsgBtn.click();
    }


}
