package com.hectorware.pages;

import com.hectorware.utilities.Driver;
import com.hectorware.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ContactsPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(Driver.get(), 5);

    @FindBy(xpath = "//span[contains(text(),'New group')]")
    public WebElement newGroupBtn;

    @FindBy(css = ".action-input__input.focusable")
    public WebElement newGroupInputBox;

    @FindBy(xpath = "//label[@class='action-input__label']")
    public WebElement createGroupArrowBtn;

    @FindBy(xpath = "//p[@class='action-text__longtext']")
    public WebElement newGroupErrorMessage;

    @FindBy(id = "new-contact-button")
    public WebElement newContactBtn;

    @FindBy(id = "contact-org")
    public WebElement companyFormInputBox;

    @FindBy(id = "contact-title")
    public WebElement titleFormInputBox;

    @FindBy (xpath = "//input[@inputmode='tel']")
    public WebElement phoneFormInputBox;

    @FindBy(xpath = "//input[@inputmode='email']")
    public WebElement emailFormInputBox;

    @FindBy(xpath = "//div[contains(.,'Post office')]/../input[@class='property__value']")
    public WebElement poBoxInputBox;

    @FindBy(xpath = "//div[contains(.,'Address')]/../input[@class='property__value']")
    public WebElement addressInputBox;

    @FindBy(xpath = "//div[contains(.,'Extended')]/../input[@class='property__value']")
    public WebElement extendedAddressInputBox;

    @FindBy(xpath = "//div[contains(.,'Postal')]/../input[@class='property__value']")
    public WebElement postalCodeInputBox;

    @FindBy(xpath = "//div[contains(.,'City')]/../input[@class='property__value']")
    public WebElement cityInputBox;

    @FindBy(xpath = "//div[contains(.,'State')]/../input[@class='property__value']")
    public WebElement stateInputBox;

    @FindBy(xpath = "//div[contains(.,'Country')]/../input[@class='property__value']")
    public WebElement countryInputBox;

    @FindBy(xpath = "//input[@placeholder='Add contact in group']")
    public WebElement addContactInGroupDropdown;

    @FindBy(xpath = "//input[@placeholder='Choose property type']")
    public WebElement addNewPropertyDropdown;

    @FindBy(xpath = "//div[@aria-describedby='tooltip_0m0x6czt01']")
    public WebElement saveContactBtn;

    @FindBy(xpath = "//div[@class='contact-header__actions']//button")
    public WebElement dottedMenuBtn;

    @FindBy(xpath = "//div[contains(@class,'popover vue-popover-theme open')]//span[contains(.,'Delete')]")
    public WebElement deleteButton;

    @FindBy(css = ".vue-recycle-scroller__item-wrapper> .vue-recycle-scroller__item-view")
    public List<WebElement> allContacts;



    public boolean isGroupCreated(String groupName){
        Utils.wait(1);
        if(Driver.get().findElement(By.xpath("//ul[@class='app-navigation__list']//a[contains(.,'"+groupName+"')]")).isDisplayed()){
            return true;
        }
        return false;
    }

    public void enterGroupName(String groupName){
        wait.until(ExpectedConditions.elementToBeClickable(newGroupInputBox));
        wait.until(ExpectedConditions.visibilityOf(newGroupInputBox));
        newGroupInputBox.sendKeys(groupName);
    }

    public void selectFromListOfOptions(String valueName){
        Utils.wait(1);
        Driver.get().findElement(By.xpath("//div[@title='"+valueName+"']/span")).click();
    }

    public void addContactDetails(String company, String title,String phone, String email, String poBox, String address, String extendedAddress, String postalCode, String city, String state, String country){
        Utils.waitFor(1);
        Utils.waitForVisibility(companyFormInputBox, 5);
        companyFormInputBox.sendKeys(company);
        titleFormInputBox.sendKeys(title);
        phoneFormInputBox.sendKeys(phone);
        emailFormInputBox.sendKeys(email);
        poBoxInputBox.sendKeys(poBox);
        addressInputBox.sendKeys(address);
        extendedAddressInputBox.sendKeys(extendedAddress);
        postalCodeInputBox.sendKeys(postalCode);
        cityInputBox.sendKeys(city);
        stateInputBox.sendKeys(state);
        countryInputBox.sendKeys(country);
        Utils.waitFor(1);
    }

    public boolean isContactDisplayed(String contactName){
        if(Driver.get().findElement(By.xpath("//div[@class='app-content-list-item-line-one' and contains(.,'"+contactName+"')]")).isDisplayed()){
            return true;
        }
        return false;
    }

    public void selectContact(String contactName){
        Utils.waitForPageToLoad(5);
        Driver.get().findElement(By.xpath("//div[@class='app-content-list-item-line-one' and contains(.,'"+contactName+"')]")).click();
    }

    public void selectGroup(String groupName){
        Driver.get().findElement(By.xpath("//ul[@class='app-navigation__list']//a[contains(.,'"+groupName+"')]")).click();
    }

    public void editContactDetails(String propertyName, String newProperty){
        String propertyPath = "//div[contains(.,'"+propertyName+"')]/../input[@class='property__value']";
        Utils.waitFor(1);
        Driver.get().findElement(By.xpath(propertyPath)).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        Driver.get().findElement(By.xpath(propertyPath)).sendKeys(newProperty);
    }

    public boolean isPropertyValueDisplayed(String propertyName, String propertyValue){
        String propertyPath = "//div[contains(.,'"+propertyName+"')]/../input[@class='property__value']";
        return Driver.get().findElement(By.xpath(propertyPath)).getAttribute("value").equals(propertyValue);
    }

    public List<String> getContactsText(){
        List<String> contacts = new ArrayList<>();
        for (WebElement contact : allContacts) {
            contacts.add(contact.getText());
        }
        return contacts;
    }


    public boolean isExistingContact(String contactName){

        boolean flag =false;
        List<String> contacts = new ArrayList<>(getContactsText());

        for (String contact : contacts) {
            if(contact.contains(contactName)){
                flag = true;
            }
        }
        return flag;
    }


}
