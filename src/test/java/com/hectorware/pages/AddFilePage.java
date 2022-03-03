package com.hectorware.pages;

import com.hectorware.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AddFilePage extends BasePage{

    public AddFilePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement plusSign;

    @FindBy(xpath = "//span[@class='displayname']")
    public List<WebElement> addFileOptions;

    @FindBy(css = "span[class='name']")
    public List<WebElement> loadedFileNames;

    @FindBy(css = "#view13-input-folder")
    public WebElement newFolderInput;

    @FindBy(css = "input[class='icon-confirm']")
    public WebElement newFolderArrowSign;

    @FindBy(xpath = "//span[contains(text(),'EU7Project')] ")
    public WebElement getFileText;

    @FindBy(css = "#view13-input-file")
    public WebElement newTexDocInputBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement newTexDocArrowSign;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement errorMessage;



    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    public void uploadFile() throws AWTException {
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("C:\\Users\\Pc\\Desktop\\EU7Project.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }
    public void uploadExeFile() throws AWTException {
        Robot rb = new Robot();
        StringSelection str = new StringSelection("C:\\Users\\Pc\\Desktop\\EU_7_Cucumber_Framework_Review");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }
    public  void  addFileOptions(String option){
        String xpath="//span[contains(text(),'"+option+"')]";
        Driver.get().findElement(By.xpath(xpath)).click();
    }
    public void addNewFolder() throws InterruptedException {
        Thread.sleep(1);
        newFolderInput.sendKeys("EU7Project");
        newFolderArrowSign.click();

    }
    public void addNewTextDoc() {

        newTexDocInputBox.sendKeys("EU7");
        newTexDocArrowSign.click();


    }

}

